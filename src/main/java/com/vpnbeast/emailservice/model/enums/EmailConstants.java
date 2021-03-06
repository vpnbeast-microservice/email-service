package com.vpnbeast.emailservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum EmailConstants {

    TAG("sendEmail"),
    FROM("info@thevpnbeast.com");

    @Getter
    @Setter
    private String content;

}