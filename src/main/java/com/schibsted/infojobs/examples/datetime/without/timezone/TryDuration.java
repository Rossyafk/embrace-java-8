package com.schibsted.infojobs.examples.datetime.without.timezone;

import java.time.Duration;
import java.time.LocalTime;

import static com.schibsted.infojobs.util.Utils.print;

/**
 * Time-based amount of time
 */
public class TryDuration {

    public static void main(String[] args) {
        print(() -> "Creating Durations");
        print(() -> Duration.ofDays(1));
        print(() -> Duration.ofHours(1));
        print(() -> Duration.ofMinutes(1));
        print(() -> Duration.ofSeconds(1));
        print(() -> Duration.ofMillis(1));
        print(() -> Duration.ofNanos(1));
        print(() -> Duration.ZERO);
        print(() -> "");

        print(() -> "Increase / Decrease with Durations");
        print(() -> LocalTime.now().plus(Duration.ofHours(10)));
        print(() -> LocalTime.now().plus(Duration.ofDays(2)));
        print(() -> "");

        print(() -> "Others");
        print(() -> Duration.between(LocalTime.now(), LocalTime.MAX));
        print(() -> "");
    }
}
