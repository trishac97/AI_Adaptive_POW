package com.aipow.controller;

import com.aipow.payload.request.AiPowRequest;
import com.aipow.payload.response.AiPowResponse;
import com.aipow.service.AiPowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private AiPowService aiPowService;

    @PostMapping("executePow")
    public ResponseEntity<AiPowResponse> executePow(@Valid @RequestBody AiPowRequest aiPowRequest) throws Exception {
        AiPowResponse aiPowResponse = aiPowService.getAiPowResponse(aiPowRequest);
        return new ResponseEntity<>(aiPowResponse, HttpStatus.OK);
    }
}
