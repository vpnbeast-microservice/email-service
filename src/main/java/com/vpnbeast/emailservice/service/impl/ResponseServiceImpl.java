package com.vpnbeast.emailservice.service.impl;

import com.vpnbeast.emailservice.model.response.FailureResponse;
import com.vpnbeast.emailservice.model.response.SuccessResponse;
import com.vpnbeast.emailservice.service.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
public class ResponseServiceImpl implements ResponseService {

    @Override
    public SuccessResponse buildSuccessResponse(String tag) {
        return SuccessResponse.successResponseBuilder()
                .tag(tag)
                .status(true)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public FailureResponse buildFailureResponse(String tag, String errorMessage) {
        return FailureResponse.failureResponseBuilder()
                .tag(tag)
                .errorMessage(errorMessage)
                .timestamp(LocalDateTime.now())
                .status(false)
                .build();
    }

}