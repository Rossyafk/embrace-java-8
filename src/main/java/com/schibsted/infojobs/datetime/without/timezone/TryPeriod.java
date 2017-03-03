package com.schibsted.infojobs.datetime.without.timezone;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import static com.schibsted.infojobs.util.Utils.print;

/**
 * Date-based amount of time
 */
public class TryPeriod {

    public static void main(String[] args) {
        print(() -> "Creating Periods");
        print(() -> Period.ofYears(1));
        print(() -> Period.ofMonths(1));
        print(() -> Period.ofWeeks(1));
        print(() -> Period.ofDays(1));
        print(() -> Period.of(1, 2, 3));
        print(() -> Period.ZERO);
        print(() -> "");

        print(() -> "Increase / Decrease with Periods");
        print(() -> LocalDate.now().plus(Period.ofYears(10)));
        print(() -> LocalDateTime.now().plus(Period.ofMonths(6)));
        print(() -> "");

        print(() -> "Others");
        print(() -> Period.between(LocalDate.now(), LocalDate.MAX));
        print(() -> "");
    }
}
