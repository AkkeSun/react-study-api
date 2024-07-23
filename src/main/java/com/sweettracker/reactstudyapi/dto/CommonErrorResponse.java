package com.sweettracker.reactstudyapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonErrorResponse {
    private int errorCode;
    private String errorMessage;

    @Builder
    public CommonErrorResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
