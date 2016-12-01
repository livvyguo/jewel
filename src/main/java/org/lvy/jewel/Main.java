package org.lvy.jewel;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.temporal.ChronoField;

public class Main {

    public static void main(String[] args) {

        BigDecimal a = BigDecimal.ZERO;

        System.out.println(a);

        YearMonth now = YearMonth.now();

        int i = now.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(i);
    }
}
