package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise13 {

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
        for (Candidate candidate : CANDIDATE_LIST) {
            if (candidate.getAge() > AGE_TO_CHECK) {
                return true;
            }
        }
        return false;
    }

    public static boolean withJava8() {
        return false;
    }

    @Test
    public void exercise13() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
