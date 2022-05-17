package com.aipow.service;

import com.aipow.payload.request.AiPowRequest;
import com.aipow.payload.response.AiPowResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface AiPowService {

    AiPowResponse getAiPowResponse(AiPowRequest aiPowRequest) throws IOException, NoSuchAlgorithmException;
}
