package com.schibsted.infojobs.datetime.without.timezone;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static com.schibsted.infojobs.util.Utils.print;

/**
 * LocalTime contains just a time.
 */
public class TryLocalTime {

    public static void main(String[] args) {
        int hour = 11;
        int minute = 30;
        int second = 45;
        int nanoOfSecond = 1000;

        print(() -> "Creating LocalTimes");
        print(() -> LocalTime.of(hour, minute));
        print(() -> LocalTime.of(hour, minute, second));
        print(() -> LocalTime.of(hour, minute, second, nanoOfSecond));
        print(() -> LocalTime.MAX);
        print(() -> LocalTime.MIN);
        print(() -> LocalTime.MIDNIGHT);
        print(() -> LocalTime.NOON);
        print(() -> "");

        print(() -> "Formatting LocalTimes");
        print(() -> DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.now()));
        print(() -> "");

        LocalTime now = LocalTime.now();

        print(() -> "Increase / Decrease LocalTimes");
        print(() -> now.plusHours(1));
        print(() -> now.minusMinutes(1));
        print(() -> now.plusSeconds(1));
        print(() -> now.minusNanos(1));
        print(() -> now.plus(1, ChronoUnit.MILLIS));
        print(() -> now.minus(1, ChronoUnit.HALF_DAYS));
        print(() -> "");

        print(() -> "Adjusting LocalTimes");
        print(() -> now.withHour(10));
        print(() -> now.withMinute(50));
        print(() -> now.withSecond(15));
        print(() -> now.withNano(500));
        print(() -> "");

        print(() -> "Others");
        print(() -> ChronoUnit.HOURS.between(now, LocalTime.MAX));
        print(() -> ChronoUnit.MINUTES.between(now, LocalTime.MAX));
        print(() -> ChronoUnit.SECONDS.between(now, LocalTime.MAX));
        print(() -> ChronoUnit.MILLIS.between(now, LocalTime.MAX));
        print(() -> ChronoUnit.MICROS.between(now, LocalTime.MAX));
        print(() -> ChronoUnit.NANOS.between(now, LocalTime.MAX));
        print(() -> "");
    }
}
