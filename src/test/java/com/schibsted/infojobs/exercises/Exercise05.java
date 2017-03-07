package com.schibsted.infojobs.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise05 {

    private static final String ONE = "One";
    private static final String TWO = "Two";
    private static final String THREE = "Three";

    public static Map<String, String> beforeJava8() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put(ONE, ONE);
        stringMap.put(TWO, TWO);
        stringMap.put(THREE, THREE);
        return stringMap;
    }

    public static Map<String, String> withJava8() {
        return null;
    }

    @Test
    public void exercise05() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
