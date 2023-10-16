package com.fullstack.service;

import com.fullstack.dto.EmailRequest;
import com.fullstack.entity.MailSender;
import com.fullstack.exception.MaxResendLimitException;

public interface MailSenderService {
    MailSender sendOtp(EmailRequest emailRequest) throws MaxResendLimitException;
    boolean verifyOtp(String to, String otp);
}