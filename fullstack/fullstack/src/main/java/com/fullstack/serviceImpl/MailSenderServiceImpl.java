package com.fullstack.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fullstack.dto.EmailRequest;
import com.fullstack.entity.MailSender;
import com.fullstack.exception.MaxResendLimitException;
import com.fullstack.repository.MailSenderRepository;
import com.fullstack.service.MailSenderService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.Random;


@Service
public class MailSenderServiceImpl implements MailSenderService {

	@Autowired
    MailSenderRepository mailSenderRepository;

	@Autowired
    JavaMailSender javaMailSender;
    
	
	// ...

	public MailSender sendOtp(EmailRequest emailRequest) throws MaxResendLimitException {
	    System.out.println("Received request to send OTP to: " + emailRequest.getTo());

	    // Check if the max resend limit has been reached within an hour
	    Date oneHourAgo = new Date(System.currentTimeMillis() - 3600 * 1000);
	    List<MailSender> recentEntries = mailSenderRepository.findRecentEntries(emailRequest.getTo(), oneHourAgo);
	    System.out.println("Number of recent entries for " + emailRequest.getTo() + " within the last hour: " + recentEntries.size());

	    if (recentEntries.size() >= 3) {
	        System.out.println("Maximum resend limit reached for this email within an hour.");
	        throw new MaxResendLimitException("Maximum resend limit reached for this email within an hour.");
	    }

	    // Generate a random 6-digit OTP
	    String otp = generateRandomOtp();

	    MailSender mailSender = new MailSender();
	    mailSender.setOtp(otp);

	    // Set other fields like time, expiredTime, and email subject
	    mailSender.setSubject("Prince OTP");
	    mailSender.setTime(new Date());
	    mailSender.setExpiredTime(new Date(System.currentTimeMillis() + 10 * 60 * 1000)); // OTP expires in 10 minutes

	    mailSender = mailSenderRepository.save(mailSender);
	    System.out.println("Generated and saved OTP entry with ID: " + mailSender.getId());

	    try {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        helper.setTo(emailRequest.getTo());
	        helper.setSubject("Prince OTP");
	        helper.setText("Your OTP for login is: " + otp, true);

	        javaMailSender.send(message);
	        System.out.println("Sent OTP successfully to: " + emailRequest.getTo());
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }

	    return mailSender;
	}

	private String generateRandomOtp() {
	    Random random = new Random();
	    int otp = 100000 + random.nextInt(900000); // Random 6-digit OTP
	    return String.valueOf(otp);
	}

    @Override
    public boolean verifyOtp(String to, String otp) {
        // Find the MailSender entry for the specified 'to' email
        Optional<MailSender> mailSenderOptional = mailSenderRepository.findByTo(to);
        
        if (mailSenderOptional.isPresent()) {
            MailSender mailSender = mailSenderOptional.get();
            
            // Check if the OTP has expired
            Date currentTime = new Date();
            if (currentTime.after(mailSender.getExpiredTime())) {
                // OTP has expired
                return false;
            }
            
            // Check if the provided OTP matches the stored OTP
            if (otp.equals(mailSender.getOtp())) {
                // OTP is valid; you can delete the entry to prevent further verification attempts
                mailSenderRepository.delete(mailSender);
                return true;
            }
        }
        
        // If no valid MailSender entry or OTP mismatch, return false
        return false;
    }

}
