package org.lvy.jewel.component.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.UsesJava8;

import java.time.Year;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/3/3.
 */
@UsesJava8
public class IntToYearConverter implements Converter<Integer, Year> {

    @Override
    public Year convert(Integer source) {
        return Year.of(source);
    }
}
