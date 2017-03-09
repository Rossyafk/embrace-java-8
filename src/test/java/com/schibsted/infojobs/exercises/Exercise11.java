package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise11 {

    private static final List<Candidate> CANDIDATE_LIST;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static String beforeJava8() {
        StringBuilder comaSeparatedListOfNames = new StringBuilder();

        for (Candidate candidate : CANDIDATE_LIST) {
            if (comaSeparatedListOfNames.length() != 0) {
                comaSeparatedListOfNames.append(',');
            }
            comaSeparatedListOfNames.append(candidate.getName());
        }

        return String.format("[%s]", comaSeparatedListOfNames.toString());
    }

    public static String withJava8() {
        return CANDIDATE_LIST.stream()
                .map(Candidate::getName)
                .collect(Collectors.joining(",", "[", "]"));
    }

    @Test
    public void exercise11() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
