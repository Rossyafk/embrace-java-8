package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise08 {

    private static final List<Candidate> CANDIDATE_LIST;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania")),
                new Candidate("3", "Alberto", 99, null)
        );
    }

    public static List<String> beforeJava8() {
        List<String> nationalities = new ArrayList<>();

        for (Candidate candidate : CANDIDATE_LIST) {
            List<String> nationalityList = candidate.getNationalities();
            if (nationalityList != null) {
                for (String nationality : nationalityList) {
                    nationalities.add(nationality);
                }
            }
        }

        return nationalities;
    }

    public static List<String> withJava8() {
        return null;
    }

    @Test
    public void exercise08() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
