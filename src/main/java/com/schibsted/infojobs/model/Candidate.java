package com.schibsted.infojobs.model;

import java.util.List;

public class Candidate {

    private final String id;
    private final String name;
    private final int age;
    private final List<String> nationalities;

    public Candidate(String id, String name, int age, List<String> nationalities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationalities = nationalities;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getNationalities() {
        return nationalities;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Candidate) {
            Candidate candidate = (Candidate) obj;
            return id.equals(candidate.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nationalities=" + nationalities +
                '}';
    }
}
