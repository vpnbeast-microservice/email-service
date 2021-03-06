package com.vpnbeast.emailservice.service.impl;

import com.vpnbeast.emailservice.model.enums.EmailConstants;
import com.vpnbeast.emailservice.model.enums.EmailType;
import com.vpnbeast.emailservice.model.enums.ResetPasswordContent;
import com.vpnbeast.emailservice.model.enums.ValidateEmailContent;
import com.vpnbeast.emailservice.model.request.EmailRequest;
import com.vpnbeast.emailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public Boolean sendEmail(EmailRequest emailRequest) {
        try {
            final JavaMailSenderImpl sender = new JavaMailSenderImpl();
            final MimeMessage message = sender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(emailRequest.getEmailAddress());
            helper.setFrom(EmailConstants.FROM.getContent());
            if (emailRequest.getEmailType().equals(EmailType.RESET_PASSWORD)) {
                helper.setSubject(ResetPasswordContent.TITLE.getContent());
                helper.setText(String.format(ResetPasswordContent.MESSAGE.getContent(), emailRequest.getVerificationCode()),
                        true);
            } else if (emailRequest.getEmailType().equals(EmailType.VALIDATE_EMAIL)) {
                helper.setSubject(ValidateEmailContent.TITLE.getContent());
                helper.setText(String.format(ValidateEmailContent.MESSAGE.getContent(), emailRequest.getVerificationCode()),
                        true);
            }
            javaMailSender.send(message);
            return true;
        } catch (Exception exception) {
            log.error("The email was not sent. Exception message: {}", exception.getMessage());
            return false;
        }

    }
}