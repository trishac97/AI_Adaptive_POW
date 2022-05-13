package com.aipow.payload.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiPowResponse {

    @NotBlank
    private String status;
    @NotBlank
    private String ip;
    @NotBlank
    private double reputation;
    @NotBlank
    private String randomString;
    @NotBlank
    private String epsilon;
    @NotBlank
    private int appliedPolicy;
    @NotBlank
    private String requiredHashResult;
    @NotBlank
    private String requiredBinaryResult;
    @NotBlank
    private String startTime;
    @NotBlank
    private String endTime;
    @NotBlank
    private String elapsedTime;

}
