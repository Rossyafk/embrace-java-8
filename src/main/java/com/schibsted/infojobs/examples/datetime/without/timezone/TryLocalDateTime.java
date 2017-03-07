package com.schibsted.infojobs.examples.datetime.without.timezone;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
 * LocalDateTime both a date and a time but no time zone.
 */
public class TryLocalDateTime {

    public static void main(String[] args) {
        int year = Year.now().getValue();
        int month = Month.MARCH.getValue();
        int dayOfMonth = 3;
        int hour = 11;
        int minute = 30;
        int second = 45;
        int nanoOfSecond = 1000;

        print(() -> "Creating LocalDateTimes");
        print(() -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond));
        print(() -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
        print(() -> LocalDateTime.of(year, month, dayOfMonth, hour, minute));
        print(() -> LocalDateTime.of(
                LocalDate.of(year, month, dayOfMonth),
                LocalTime.of(hour, minute, second, nanoOfSecond)));
        print(() -> LocalDateTime.MAX);
        print(() -> LocalDateTime.MIN);
        print(() -> "");

        print(() -> "Formatting LocalDateTimes");
        print(() -> DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
        print(() -> "");

        LocalDateTime now = LocalDateTime.now();

        print(() -> "Increase / Decrease LocalDateTimes");
        print(() -> now.plusDays(1));
        print(() -> now.minusWeeks(1));
        print(() -> now.plusMonths(1));
        print(() -> now.minusYears(1));
        print(() -> now.plusHours(1));
        print(() -> now.minusMinutes(1));
        print(() -> now.plusSeconds(1));
        print(() -> now.minusNanos(1));
        print(() -> now.plus(1, ChronoUnit.MILLIS));
        print(() -> now.minus(1, ChronoUnit.HALF_DAYS));
        print(() -> now.plus(1, ChronoUnit.CENTURIES));
        print(() -> now.minus(1, ChronoUnit.MILLENNIA));
        print(() -> "");

        print(() -> "Adjusting LocalDateTimes");
        print(() -> now.withYear(2100));
        print(() -> now.withMonth(Month.DECEMBER.getValue()));
        print(() -> now.withDayOfMonth(25));
        print(() -> now.withHour(10));
        print(() -> now.withMinute(50));
        print(() -> now.withSecond(15));
        print(() -> now.withNano(500));
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
        print(() -> ChronoUnit.YEARS.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.MONTHS.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.DAYS.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.DECADES.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.MILLENNIA.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.ERAS.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.HOURS.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.MINUTES.between(now, LocalDateTime.MAX));
        print(() -> ChronoUnit.SECONDS.between(now, LocalDateTime.MAX));
        print(() -> "");

        print(() -> "Transformations");
        print(() -> now.toLocalDate());
        print(() -> now.toLocalTime());
        print(() -> "");
    }
}
