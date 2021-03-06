package com.vpnbeast.emailservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ValidateEmailContent {

    TITLE("Verification Mail By VPN Beast"),
    MESSAGE("<p>This is a verification email. Use the below verification code to verify that this email is owned by you!<br><br><b>%d</b></p>");

    @Getter
    @Setter
    private String content;

}