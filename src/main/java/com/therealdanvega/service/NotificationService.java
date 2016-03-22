package com.therealdanvega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.therealdanvega.domain.User;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotificaitoin(User user) throws MailException {
		// send email
		System.out.println(1);
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("testing.sogeti1991@gmail.com");
		mail.setSubject("Pak slaag");
		mail.setText("Curve fever at the end of the day! Wanna lose again..??");
		
		System.out.println(mail);
		System.out.println("before sending");
		javaMailSender.send(mail); //HIER GAAT HET FOUT, VIA TELEFOON: unrecognised ssl message, via sogeti netwerk connection refused
		System.out.println("after sending");
	}
}