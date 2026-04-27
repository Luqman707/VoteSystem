package org.example;

public class Candidate {
    private static int candidate1Vote = 0;
    private static int candidate2Vote = 0;

    public Candidate() {
    }

    public static void setCandidate1Vote() {
        candidate1Vote++;
    }

    public static void setCandidate2Vote() {
        candidate2Vote++;
    }

}
