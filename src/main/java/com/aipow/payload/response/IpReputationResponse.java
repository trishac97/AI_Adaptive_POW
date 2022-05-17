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
public class IpReputationResponse {

    @NotBlank
    private String ip;
    @NotBlank
    private String reputation;

}
