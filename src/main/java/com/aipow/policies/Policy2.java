package com.aipow.policies;

import javax.validation.constraints.NotBlank;
import java.util.Random;

public class Policy2 {
    @NotBlank
    private double reputation; //Scale 0-10
    @NotBlank
    private int difficulty;
    @NotBlank
    private final double epsilon = (double) 0.2; //DaBR epsilon ~20%

    private final Random random = new Random();


    public Policy2(double reputation) {
        this.reputation = reputation;
        this.difficulty = policySpecification(reputation);
    }

    private int policySpecification(double reputation) {

        int maxRep = (int) Math.ceil(reputation + (reputation * epsilon));
        int minRep = (int) Math.floor(reputation - (reputation * epsilon));
        return random.nextInt(maxRep - minRep + 1) + minRep;
    }

    public double getReputation() {
        return reputation;
    }

    public void setReputation(double reputation) {
        this.reputation = reputation;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}