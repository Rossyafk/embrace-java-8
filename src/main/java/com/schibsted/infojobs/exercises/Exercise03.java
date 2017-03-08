package com.schibsted.infojobs.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Exercise03 {

    private static final String ONE = "One";
    private static final String TWO = "Two";
    private static final String THREE = "Three";

    public static List<String> beforeJava8() {
        List<String> stringList = Arrays.asList(ONE, TWO, THREE);
        return Collections.unmodifiableList(stringList);
    }

    public static List<String> withJava8() {
        return Stream.of(ONE, TWO, THREE)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }
}
