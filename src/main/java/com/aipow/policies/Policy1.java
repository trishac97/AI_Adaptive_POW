package com.aipow.policies;

import javax.validation.constraints.NotBlank;

public class Policy1 {

    @NotBlank double reputation; //Scale 0-10
    @NotBlank
    private int difficulty;

    public Policy1(double reputation) {
        this.reputation = reputation;
        this.difficulty = policySpecification(reputation);
    }

    private int policySpecification(double reputation) {
        return (int) Math.round(reputation);
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
