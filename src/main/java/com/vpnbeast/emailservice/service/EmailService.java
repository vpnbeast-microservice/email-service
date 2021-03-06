package com.vpnbeast.emailservice.service;

import com.vpnbeast.emailservice.model.request.EmailRequest;

public interface EmailService {

    Boolean sendEmail(EmailRequest emailRequest);

}