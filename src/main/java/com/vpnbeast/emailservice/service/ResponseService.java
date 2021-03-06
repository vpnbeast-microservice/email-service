package com.vpnbeast.emailservice.service;

import com.vpnbeast.emailservice.model.response.FailureResponse;
import com.vpnbeast.emailservice.model.response.SuccessResponse;

public interface ResponseService {

    SuccessResponse buildSuccessResponse(String tag);
    FailureResponse buildFailureResponse(String tag, String errorMessage);

}