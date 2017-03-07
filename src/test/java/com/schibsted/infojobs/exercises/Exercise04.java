package com.schibsted.infojobs.exercises;

import org.junit.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        return null;
    }

    @Test
    public void exercise04() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
