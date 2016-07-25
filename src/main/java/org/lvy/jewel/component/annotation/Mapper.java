package org.lvy.jewel.component.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/25.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Mapper {
    String value() default "";
}
