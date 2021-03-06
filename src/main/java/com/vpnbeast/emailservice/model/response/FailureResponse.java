package com.vpnbeast.emailservice.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FailureResponse extends BaseResponse {

    private String errorMessage;

    @Builder(builderMethodName = "failureResponseBuilder")
    public FailureResponse(String tag, Boolean status, LocalDateTime timestamp, String errorMessage) {
        super(tag, status, timestamp);
        this.errorMessage = errorMessage;
    }

}