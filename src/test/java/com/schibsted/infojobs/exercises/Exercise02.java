package com.schibsted.infojobs.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise02 {

    private static final String ONE = "One";
    private static final String TWO = "Two";
    private static final String THREE = "Three";

    public static String[] beforeJava8() {
        List<String> stringList = Arrays.asList(ONE, TWO, THREE);
        return stringList.toArray(new String[stringList.size()]);
    }

    public static String[] withJava8() {
        return Stream.of(ONE, TWO, THREE)
                .toArray(String[]::new);
    }

    @Test
    public void exercise02() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
