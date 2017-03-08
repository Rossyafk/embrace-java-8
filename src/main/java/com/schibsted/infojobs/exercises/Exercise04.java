package com.schibsted.infojobs.exercises;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise04 {

    private static final String ONE = "One";
    private static final String TWO = "Two";
    private static final String THREE = "Three";

    public static HashSet<String> beforeJava8() {
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add(ONE);
        stringHashSet.add(TWO);
        stringHashSet.add(THREE);
        return stringHashSet;
    }

    public static HashSet<String> withJava8() {
        return Stream.of(ONE, TWO, THREE)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
