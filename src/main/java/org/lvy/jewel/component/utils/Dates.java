package org.lvy.jewel.component.utils;

import java.time.Period;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by livvy (livvyguo@gmail.com) on 2016/12/1.
 */
public final class Dates {

    private Dates() {
    }

    public static final long durationMonths(YearMonth start, YearMonth end) {
        return Period.between(start.atDay(1), end.atDay(1)).toTotalMonths();
    }

    public static final List<YearMonth> monthRanges(YearMonth start, YearMonth end) {
        long l = durationMonths(start, end);
        return Stream.iterate(start,
            month -> month.plusMonths(1)).
            limit(
                Math.abs(l)
            ).collect(Collectors.toList());
    }


    public static void main(String[] args) {

        YearMonth startMonth = YearMonth.now().minusMonths(1);
        YearMonth endMonth = startMonth.plusYears(1);

        List<YearMonth> yearMonths = monthRanges(startMonth, endMonth);
        System.out.println(yearMonths);

    }
}
