package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise06 {

    private static final List<Candidate> CANDIDATE_LIST;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static List<String> beforeJava8() {
        List<String> candidateNameList = new ArrayList<>();

        for (Candidate candidate : CANDIDATE_LIST) {
            candidateNameList.add(candidate.getName());
        }

        return candidateNameList;
    }

    public static List<String> withJava8() {
        return CANDIDATE_LIST.stream()
                .map(candidate -> candidate.getName())
                .collect(Collectors.toList());
    }

    @Test
    public void exercise06() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
