package com.aipow.model;

public class ClientSide {
    private String nonce;
    private String reqID;
    private String r_string;
    private String hash_solution;
    private int difficulty;

    private String binaryResult;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getReqID() {
        return reqID;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    public String getR_string() {
        return r_string;
    }

    public void setR_string(String r_string) {
        this.r_string = r_string;
    }

    public String getHash_solution() {
        return hash_solution;
    }

    public void setHash_solution(String hash_solution) {
        this.hash_solution = hash_solution;
    }

    public void setBinaryResult(String binaryResult) { this.binaryResult = binaryResult;    }

    public String getBinaryResult() { return this.binaryResult;     }
}
