package org.lvy.jewel.component.utils;

import com.google.common.math.IntMath;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/2/3.
 */
public final class TimeUtils {

    private TimeUtils() {
        throw new AssertionError("no instance for you!");
    }

    public static final Date getFirstDayOfWeek(Date date) {
        Objects.requireNonNull(date);
        LocalDate localDate = dateToLocalDate(date);
        LocalDate firstDayOfWeek = getFirstDayOfWeek(localDate);
        return localDateToDate(firstDayOfWeek);
    }

    public static LocalDate getFirstDayOfWeek(LocalDate localDate) {
        return localDate.with(firstDayOfWeek());
    }

    public static final Date getFirstDayOfNextWeek(Date date) {
        Objects.requireNonNull(date);
        LocalDate localDate = dateToLocalDate(date);
        LocalDate firstDayOfNextWeek = getFirstDayOfNextWeek(localDate);
        return localDateToDate(firstDayOfNextWeek);
    }

    public static LocalDate getFirstDayOfNextWeek(LocalDate localDate) {
        LocalDate firstDayOfWeek = getFirstDayOfWeek(localDate);
        return firstDayOfWeek.plusWeeks(1);
    }

    public static Date localDateToDate(LocalDate firstDayOfWeek) {
        return Date.from(firstDayOfWeek.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = toInstant(date);
        return toLocalDate(instant);
    }

    private static LocalDate toLocalDate(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    private static Instant toInstant(Date date) {
        return Instant.ofEpochMilli(date.getTime());
    }

    public static TemporalAdjuster firstDayOfWeek() {
        return (temporal) -> temporal.with(DAY_OF_WEEK, 1);
    }

    public static TemporalAdjuster lastDayOfWeek() {
        return (temporal) -> temporal.with(DAY_OF_WEEK, 7);
    }

    public static List<LocalDate> daysRange(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);
        Period period = Period.between(start, end);
        Integer months = period.getYears() * 12 + period.getMonths() + 1;
        return Stream.iterate(start,
                date -> date.plusDays(1)).
                limit(
                        months
                ).collect(Collectors.toList());
    }

    public static int getWeekOfYear(LocalDate now) {
        Objects.requireNonNull(now);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return now.get(weekFields.weekOfWeekBasedYear());
    }

    public static int getMonthFromPatternYyyyMMddDate(int date) {
        yyyyMMddDateFormatter().parse(String.valueOf(date));
        int ym = Math.floorDiv(date, 100);
        return IntMath.mod(ym, 100);
    }

    /**
     * 比较一个int类型 格式为yyyyMMdd 的日期与另一个LocalDate格式的日期是不是同一天
     * @param iDay  yyyyMMdd格式的日期
     * @param day 日期
     * @return
     */
    public static boolean isSameDay(int iDay, LocalDate day) {
        String sDay = yyyyMMddDateFormatter().format(day);
        Integer iiDay = Integer.valueOf(sDay);
        return Objects.equals(iDay, iiDay);
    }


    private static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static DateTimeFormatter yyyyMMddDateFormatter() {
        return yyyyMMdd;
    }





}
