package com.schibsted.infojobs.examples.datetime.with.timezone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.schibsted.infojobs.util.Utils.print;

/**
 * Contains a date, time and a time zone.
 */
public class TryZonedDateTime {

    public static void main(String[] args) {
        int year = Year.now().getValue();
        int month = Month.MARCH.getValue();
        int dayOfMonth = 3;
        int hour = 11;
        int minute = 30;
        int second = 45;
        int nanoOfSecond = 1000;

        print(() -> "Creating ZonedDateTimes");
        print(() -> ZonedDateTime.of(
                LocalDate.of(year, month, dayOfMonth),
                LocalTime.of(hour, minute, second, nanoOfSecond),
                ZoneId.systemDefault()));
        print(() -> "");

        print(() -> "Formatting ZonedDateTimes");
        print(() -> DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.now()));
        print(() -> "");

        ZonedDateTime now = ZonedDateTime.now();

        print(() -> "Printing ZonedDateTimes");
        print(() -> now.withZoneSameLocal(ZoneId.of("Europe/London")));
        print(() -> now.withZoneSameLocal(ZoneId.of("Europe/London")));
        print(() -> now.withZoneSameLocal(ZoneId.of("Z")));
        print(() -> now.withZoneSameLocal(ZoneOffset.UTC));
        print(() -> now.withZoneSameLocal(ZoneOffset.of("+02:00")));
        print(() -> now.withZoneSameLocal(ZoneOffset.of("-03:30")));
        print(() -> "");
    }
}
