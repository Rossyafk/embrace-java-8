package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class Exercise12 {

    private static final List<Candidate> CANDIDATE_LIST;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static void beforeJava8() {
        for (Candidate candidate : CANDIDATE_LIST) {
            System.out.println(candidate);
        }
    }

    public static void withJava8() {
    }

    @Test
    public void exercise12() throws Exception {
        beforeJava8();
        withJava8();
        fail("Fix me! :)");
    }
}
