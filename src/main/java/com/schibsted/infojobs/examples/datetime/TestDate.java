package com.schibsted.infojobs.examples.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static com.schibsted.infojobs.util.Utils.print;

public class TestDate {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JANUARY, 1, 0, 0, 0);

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        print(() -> calendar.getTime());
        print(() -> simpleDateFormat.format(calendar.getTime()));
    }
}
