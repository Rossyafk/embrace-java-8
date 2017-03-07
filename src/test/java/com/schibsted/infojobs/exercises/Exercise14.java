package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise14 {

    private static final List<Candidate> CANDIDATE_LIST;
    private static final int NUM_OF_CANDIDATES = 2;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static List<String> beforeJava8() {
        List<String> names = new ArrayList<>();
        List<Candidate> subListOfCandidates = CANDIDATE_LIST.subList(0, NUM_OF_CANDIDATES);

        for (Candidate candidate : subListOfCandidates) {
            names.add(candidate.getName());
        }

        return names;
    }

    public static List<String> withJava8() {
        return null;
    }

    @Test
    public void exercise14() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
