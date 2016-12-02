package org.lvy.jewel.component.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.UsesJava8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/3/3.
 */
@UsesJava8
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
