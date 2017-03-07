package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise10 {

    private static final List<Candidate> CANDIDATE_LIST;
    public static final int AGE_TO_CHECK = 50;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static boolean beforeJava8() {
        boolean allCandidatesWithAgeGreaterThan50 = true;

        for (Candidate candidate : CANDIDATE_LIST) {
            int age = candidate.getAge();
            allCandidatesWithAgeGreaterThan50 &= age > AGE_TO_CHECK;
        }

        return allCandidatesWithAgeGreaterThan50;
    }

    public static boolean withJava8() {
        return true;
    }

    @Test
    public void exercise10() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
