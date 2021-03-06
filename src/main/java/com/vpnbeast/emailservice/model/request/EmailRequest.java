package com.vpnbeast.emailservice.model.request;

import com.vpnbeast.emailservice.model.enums.EmailType;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmailRequest {

    private EmailType emailType;
    private Integer verificationCode;

    @Email(message = "Not a valid email format!")
    @NotNull(message = "emailAddress field should not be null!")
    @Size(max = 40, message = "emailAddress field should be max 40 chars length!")
    private String emailAddress;

}