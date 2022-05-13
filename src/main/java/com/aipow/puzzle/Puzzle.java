package com.aipow.puzzle;

import com.aipow.model.ClientSide;
import com.aipow.utils.StringUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


public class Puzzle {

    public String hash;
    public String reqID;
    public String rnd;
    public int nonce;
    public int difficulty;

    public Puzzle(String reqID, String rnd, int difficulty) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.reqID = reqID;
        this.rnd = rnd;
        this.difficulty = difficulty;
        this.hash = calculateHash();
    }

    static String hexToBin(String hex) {
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("a", "1010");
        hex = hex.replaceAll("b", "1011");
        hex = hex.replaceAll("c", "1100");
        hex = hex.replaceAll("d", "1101");
        hex = hex.replaceAll("e", "1110");
        hex = hex.replaceAll("f", "1111");
        return hex;
    }

    public String calculateHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //Picking random nonce from (2^32 - 1)/2 (divided by 2 to discard negative values)
        nonce = (int) (2147483647 * (Math.random()) + 1);
        //System.out.println("Trying with nonce value: "+nonce);
        String calculatedHash = StringUtil.SHA256(nonce + reqID + rnd);
        return calculatedHash;
    }


    public ClientSide POW(int difficulty) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String target = StringUtil.getDificultyString(difficulty);

        String binaryResult = hexToBin(hash);

        while (!binaryResult.substring(0, difficulty).equals(target)) {
            binaryResult = hexToBin(hash);
            //System.out.println(binaryResult);
            hash = calculateHash();
        }
//        System.out.println("POW Successful : " + binaryResult);
        ClientSide clientobj = new ClientSide();
        clientobj.setNonce(Integer.toString(nonce));
        clientobj.setHash_solution(hash);
        clientobj.setBinaryResult(binaryResult);
        return clientobj;
    }
}
