package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise17 {

    private static final List<Candidate> CANDIDATE_LIST;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("4", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("1", "Luis", 31, Arrays.asList("Portugal", "Alemania")),
                new Candidate("5", "Jordi", 15, Arrays.asList("Francia", "China")),
                new Candidate("3", "Helena", 40, Arrays.asList("Rusia"))
        );
    }

    public static Candidate beforeJava8() {
        Candidate youngerCandidate = null;
        int minAge = Integer.MAX_VALUE;

        for (Candidate candidate : CANDIDATE_LIST) {
            if (candidate.getAge() < minAge) {
                minAge = candidate.getAge();
                youngerCandidate = candidate;
            }
        }

        if (youngerCandidate == null) {
            throw new RuntimeException();
        }

        return youngerCandidate;
    }

    public static Candidate withJava8() {
        return null;
    }

    @Test
    public void exercise17() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
