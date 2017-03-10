package com.schibsted.infojobs.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise01 {

    private static final String ONE = "One";
    private static final String TWO = "Two";
    private static final String THREE = "Three";

    public static List<String> beforeJava8() {
        return Arrays.asList(ONE, TWO, THREE);
    }

    public static List<String> withJava8() {
        return null;
    }

    @Test
    public void exercise01() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
