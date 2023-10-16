package com.fullstack.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstack.entity.MailSender;



public interface MailSenderRepository extends JpaRepository<MailSender, Long> {
	 @Query("SELECT m FROM MailSender m WHERE m.to = :to AND m.time >= :time")
	    List<MailSender> findRecentEntries(@Param("to") String to, @Param("time") Date time);
	

	 @Query("SELECT m FROM MailSender m WHERE m.to = :email")
	    Optional<MailSender> findByTo(@Param("email") String email);
}
