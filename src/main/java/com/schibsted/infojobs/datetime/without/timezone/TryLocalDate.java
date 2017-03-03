package com.schibsted.infojobs.datetime.without.timezone;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

import static com.schibsted.infojobs.util.Utils.print;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstDayOfNextYear;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.next;
import static java.time.temporal.TemporalAdjusters.previous;

/**
 * LocalDate contains just a date.
 */
public class TryLocalDate {

    public static void main(String[] args) {


        int year = Year.now().getValue();
        int month = Month.MARCH.getValue();
        int dayOfMonth = 3;
        int dayOfYear = 1;

        print(() -> "Creating LocalDates");
        print(() -> LocalDate.of(year, month, dayOfMonth));
        print(() -> LocalDate.of(year, Month.MARCH, dayOfMonth));
        print(() -> LocalDate.ofEpochDay(0L));
        print(() -> LocalDate.ofYearDay(year, dayOfYear));
        print(() -> LocalDate.MAX);
        print(() -> LocalDate.MIN);
        print(() -> "");

        print(() -> "Formatting LocalDates");
        print(() -> DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(year, month, dayOfMonth)));
        print(() -> "");

        LocalDate now = LocalDate.now();

        print(() -> "Increase / Decrease LocalDates");
        print(() -> now.plusDays(1));
        print(() -> now.minusWeeks(1));
        print(() -> now.plusMonths(1));
        print(() -> now.minusYears(1));
        print(() -> now.plus(1, ChronoUnit.CENTURIES));
        print(() -> now.minus(1, ChronoUnit.MILLENNIA));
        print(() -> "");

        print(() -> "Adjusting LocalDates");
        print(() -> now.withYear(2100));
        print(() -> now.withMonth(Month.DECEMBER.getValue()));
        print(() -> now.withDayOfMonth(25));
        print(() -> now.with(firstDayOfMonth()));
        print(() -> now.with(firstDayOfNextYear()));
        print(() -> now.with(firstInMonth(DayOfWeek.FRIDAY)));
        print(() -> now.with(next(DayOfWeek.SUNDAY)));
        print(() -> now.with(previous(DayOfWeek.MONDAY)));

        TemporalAdjuster temporalAdjuster =
                temporal -> temporal.with(ChronoField.DAY_OF_WEEK, 7).plus(1, ChronoUnit.DECADES);
        print(() -> now.with(temporalAdjuster));
        print(() -> "");

        print(() -> "Others");
        print(() -> ChronoUnit.YEARS.between(now, LocalDate.MAX));
        print(() -> ChronoUnit.MONTHS.between(now, LocalDate.MAX));
        print(() -> ChronoUnit.DAYS.between(now, LocalDate.MAX));
        print(() -> ChronoUnit.DECADES.between(now, LocalDate.MAX));
        print(() -> ChronoUnit.MILLENNIA.between(now, LocalDate.MAX));
        print(() -> ChronoUnit.ERAS.between(now, LocalDate.MAX));
        print(() -> "");
    }


}
