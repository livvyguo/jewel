package org.lvy.jewel.component.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.UsesJava8;

import java.time.Year;
import java.time.format.DateTimeFormatter;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/3/3.
 */
@UsesJava8
public class StringToYearConverter implements Converter<String,Year> {

    @Override
    public Year convert(String source) {
        return Year.parse(source, DateTimeFormatter.ofPattern("yyyy"));
    }

}
