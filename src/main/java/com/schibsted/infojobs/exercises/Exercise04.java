package com.schibsted.infojobs.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise04 {

    public static List<String> beforeJava8() {
        return Arrays.asList("One", "Two", "Three");
    }

    public static List<String> withJava8() {
        return Stream.of("One", "Two", "Three")
                .collect(Collectors.toList());
    }
}
