package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise09 {

    private static final List<Candidate> CANDIDATE_LIST;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania"))
        );
    }

    public static String beforeJava8() {
        String candidateName = "NAME_NOT_FOUND";

        for (Candidate candidate : CANDIDATE_LIST) {
            if (candidate.getAge() > 75) {
                System.out.println("Candidate found: " + candidate);
                candidateName = candidate.getName();
                break;
            }
        }

        return candidateName;
    }

    public static String withJava8() {
        return null;
    }

    @Test
    public void exercise09() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
