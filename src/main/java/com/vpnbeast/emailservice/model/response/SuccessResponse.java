package com.vpnbeast.emailservice.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SuccessResponse extends BaseResponse {

    @Builder(builderMethodName = "successResponseBuilder")
    public SuccessResponse(String tag, Boolean status, LocalDateTime timestamp) {
        super(tag, status, timestamp);
    }

}