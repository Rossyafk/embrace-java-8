package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise15 {

    private static final List<Candidate> CANDIDATE_LIST;
    public static final int MAX_AGE_NOT_FOUND = -1;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static int beforeJava8() {
        int maxAge = MAX_AGE_NOT_FOUND;

        for (Candidate candidate : CANDIDATE_LIST) {
            int age = candidate.getAge();
            if (age > maxAge) {
                maxAge = age;
            }
        }

        return maxAge;
    }

    public static int withJava8() {
        return CANDIDATE_LIST.stream()
                .mapToInt(Candidate::getAge)
                .max()
                .orElse(MAX_AGE_NOT_FOUND);
    }

    @Test
    public void exercise15() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
