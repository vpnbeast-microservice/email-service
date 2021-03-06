package com.vpnbeast.emailservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ResetPasswordContent {

    TITLE("Reset Password Mail By VPN Beast"),
    MESSAGE("<p>This is a reset password email. Use the below verification code to reset your password!<br><br><b>%d</b></p>");

    @Getter
    @Setter
    private String content;

}