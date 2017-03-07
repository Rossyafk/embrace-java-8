package com.schibsted.infojobs.exercises;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseTest {

    @Test
    public void exercise01() throws Exception {
        List<String> withJava8 = Exercise01.withJava8();
        List<String> beforeJava8 = Exercise01.beforeJava8();
        assertThat(withJava8).isEqualTo(beforeJava8);
    }

    @Test
    public void exercise02() throws Exception {
        String[] withJava8 = Exercise02.withJava8();
        String[] beforeJava8 = Exercise02.beforeJava8();
        assertThat(withJava8).isEqualTo(beforeJava8);
    }
}
