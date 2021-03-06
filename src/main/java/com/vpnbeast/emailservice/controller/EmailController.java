package com.vpnbeast.emailservice.controller;

import com.vpnbeast.emailservice.model.enums.EmailConstants;
import com.vpnbeast.emailservice.model.response.BaseResponse;
import com.vpnbeast.emailservice.model.request.EmailRequest;
import com.vpnbeast.emailservice.service.EmailService;
import com.vpnbeast.emailservice.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/email-controller")
public class EmailController {

    private final ResponseService responseService;
    private final EmailService emailService;

    @PostMapping(value = "/send-email")
    public ResponseEntity<BaseResponse> sendEmail(@Valid @RequestBody EmailRequest request) {
        if (emailService.sendEmail(request))
            return new ResponseEntity<>(responseService.buildSuccessResponse(EmailConstants.TAG.getContent()),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(responseService.buildFailureResponse(EmailConstants.TAG.getContent(),
                    "An error occured!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}