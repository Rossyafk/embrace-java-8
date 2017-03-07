package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise18 {

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

    public static Map<Boolean, List<Candidate>> beforeJava8() {
        List<Candidate> youngCandidates = new ArrayList<>();
        List<Candidate> oldCandidates = new ArrayList<>();
        for (Candidate candidate : CANDIDATE_LIST) {
            if (candidate.getAge() < 40) {
                youngCandidates.add(candidate);
            } else {
                oldCandidates.add(candidate);
            }
        }

        Map<Boolean, List<Candidate>> partitionedCandidates = new HashMap<>();
        partitionedCandidates.put(true, youngCandidates);
        partitionedCandidates.put(false, oldCandidates);

        return Collections.unmodifiableMap(partitionedCandidates);
    }

    public static Map<Boolean, List<Candidate>> withJava8() {
        return null;
    }

    @Test
    public void exercise18() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }
}
