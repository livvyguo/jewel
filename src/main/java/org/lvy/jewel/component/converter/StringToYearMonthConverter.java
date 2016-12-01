package org.lvy.jewel.component.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.UsesJava8;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/3/3.
 */
@UsesJava8
public class StringToYearMonthConverter implements Converter<String,YearMonth> {

    @Override
    public YearMonth convert(String source) {
        return YearMonth.parse(source, DateTimeFormatter.ofPattern("yyyy-MM"));
    }
}
