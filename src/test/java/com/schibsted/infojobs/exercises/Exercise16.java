package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise16 {

    private static final List<Candidate> CANDIDATE_LIST;
    public static final int MAX_AGE_NOT_FOUND = -1;

    static {
        CANDIDATE_LIST = Arrays.asList(
                new Candidate("1", "Alejandro", 25, Arrays.asList("España", "Francia")),
                new Candidate("2", "Jordi", 65, Arrays.asList("Italia")),
                new Candidate("3", "Luis", 31, Arrays.asList("Portugal", "Alemania")),
                new Candidate("4", "Jordi", 15, Arrays.asList("Francia", "China")),
                new Candidate("5", "Helena", 40, Arrays.asList("Rusia"))
        );
    }

    public static List<String> beforeJava8() {
        List<String> names = new ArrayList<>();

        for (Candidate candidate : CANDIDATE_LIST) {
            String name = candidate.getName();
            if (!names.contains(name)) {
                names.add(name);
            }
        }

        return names;
    }

    public static List<String> withJava8() {
        return null;
    }

    @Test
    public void exercise16() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
