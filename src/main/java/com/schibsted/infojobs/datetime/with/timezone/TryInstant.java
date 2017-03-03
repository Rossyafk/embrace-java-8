package com.schibsted.infojobs.datetime.with.timezone;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static com.schibsted.infojobs.util.Utils.print;

/**
 * Represents a specific moment in time in the GMT / UTC time zone.
 */
public class TryInstant {

    public static void main(String[] args) {
        print(() -> "Creating Instants");
        print(() -> Instant.now());
        print(() -> Instant.EPOCH);
        print(() -> ZonedDateTime.now().toInstant());
        print(() -> LocalDateTime.now().toInstant(ZoneOffset.UTC));
        print(() -> "");

        print(() -> "Formatting LocalDateTimes");
        print(() -> DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
        print(() -> "");

        Instant now = Instant.now();

        print(() -> "Truncating Instants");
        print(() -> now.truncatedTo(ChronoUnit.DAYS));
        print(() -> now.truncatedTo(ChronoUnit.SECONDS));
        print(() -> "");
    }
}
