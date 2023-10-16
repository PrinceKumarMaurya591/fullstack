package com.fullstack.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class MailSender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "recipient_email") 
    private String to;
    private Date time;
    private Date expiredTime;
    private String otp;
    private String subject;
    private int resendOtpMax;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public int getResendOtpMax() {
		return resendOtpMax;
	}
	public void setResendOtpMax(int resendOtpMax) {
		this.resendOtpMax = resendOtpMax;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MailSender(Long id, String to, Date time, Date expiredTime, String otp, String subject, int resendOtpMax) {
		super();
		this.id = id;
		this.to = to;
		this.time = time;
		this.expiredTime = expiredTime;
		this.otp = otp;
		this.subject = subject;
		this.resendOtpMax = resendOtpMax;
	}
	public MailSender() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MailSender [id=" + id + ", to=" + to + ", time=" + time + ", expiredTime=" + expiredTime + ", otp="
				+ otp + ", subject=" + subject + ", resendOtpMax=" + resendOtpMax + "]";
	}
	
	
    
    
}