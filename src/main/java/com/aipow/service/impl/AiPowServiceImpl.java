package com.aipow.service.impl;

import com.aipow.model.ClientSide;
import com.aipow.payload.request.AiPowRequest;
import com.aipow.payload.response.AiPowResponse;
import com.aipow.policies.Policy1;
import com.aipow.policies.Policy2;
import com.aipow.policies.Policy3;
import com.aipow.puzzle.Puzzle;
import com.aipow.service.AiPowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Date;

@Service
public class AiPowServiceImpl implements AiPowService {

//    @Autowired
//    HttpServletRequest httpServletRequest;

    @Override
    public AiPowResponse getAiPowResponse(AiPowRequest aiPowRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        double epsilon = (float) 0.2; //DaBR epsilon ~20%
        String ip = aiPowRequest.getIp(); // getIp(aiPowRequest); // "190.12.19.10";
        double reputation = getReputation(ip);
        long unixTime = Instant.now().getEpochSecond();
        String randomString = String.valueOf(unixTime / 3600); // "110110";

        ClientSide clientobj = new ClientSide();
        clientobj.setR_string(randomString); // Random string seed, changes every t seconds
        clientobj.setReqID(ip); //Source IP

        clientobj.setDifficulty(getPolicyDifficulty(aiPowRequest.getAppliedPolicy(), reputation));

        Puzzle puzzle = new Puzzle(clientobj.getReqID(), clientobj.getR_string(), clientobj.getDifficulty());
        ClientSide newClientObj = puzzle.POW(clientobj.getDifficulty());
        long endTime = (new Date()).getTime();
        elapsedTime = endTime - startTime;

        return AiPowResponse.builder()
                .startTime(String.valueOf(startTime))
                .ip(ip)
                .randomString(randomString)
                .epsilon(String.valueOf(epsilon))
                .endTime(String.valueOf(endTime))
                .elapsedTime(String.valueOf(elapsedTime))
                .appliedPolicy(getPolicyNumber(aiPowRequest.getAppliedPolicy()))
                .reputation(reputation)
                .requiredHashResult(newClientObj.getHash_solution())
                .requiredBinaryResult(newClientObj.getBinaryResult())
                .status("success")
                .build();
    }

    private int getPolicyDifficulty(int policyNumber, double reputation) {
        switch (policyNumber) {
            case 2:
                return new Policy2(reputation).getDifficulty();
            case 3:
                return new Policy3(reputation).getDifficulty();
            default:
                return new Policy1(reputation).getDifficulty();
        }
    }

    private int getPolicyNumber(int policyNumber) {
        return (policyNumber > 0 && policyNumber < 4) ? policyNumber : 1;
    }
//    The below code is commented as DabR is not designed to hande ipV6 addresses. Uncomment to allow ipv6
//    private String getIp(AiPowRequest aiPowRequest) {
//        return aiPowRequest.getIp() == null ?
//                httpServletRequest.getRemoteAddr() : aiPowRequest.getIp();
//    }

    private double getReputation(String ip){
        return 10.0;
    }
}
