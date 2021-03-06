package com.vpnbeast.emailservice.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BaseResponse {

    private String tag;
    private Boolean status;
    private LocalDateTime timestamp;

}