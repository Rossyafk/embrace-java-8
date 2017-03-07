package com.schibsted.infojobs.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise01 {

    private static final String ONE = "One";
    private static final String TWO = "Two";
    private static final String THREE = "Three";

    public static List<String> beforeJava8() {
        return Arrays.asList(ONE, TWO, THREE);
    }

    public static List<String> withJava8() {
        return Stream.of(ONE, TWO, THREE)
                .collect(Collectors.toList());
    }
}
