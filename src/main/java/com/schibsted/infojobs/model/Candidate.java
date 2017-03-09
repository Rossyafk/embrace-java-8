package com.schibsted.infojobs.model;

import java.util.ArrayList;
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

    private Candidate(Builder builder) {
        this(builder.id, builder.name, builder.age, builder.nationalities);
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

    public static Builder builder(String id, String name, int age) {
        return new Builder(id, name, age);
    }

    public static class Builder {

        private final String id;
        private final String name;
        private final int age;
        private final List<String> nationalities;

        public Builder(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.nationalities = new ArrayList<>();
        }

        public Builder addNationality(String name) {
            nationalities.add(name);
            return this;
        }

        public Candidate build() {
            return new Candidate(this);
        }
    }
}
