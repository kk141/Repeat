package com.psa.Repeat.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class Email {
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
			    
			    
			    MimeMessage message = emailSender.createMimeMessage();
			    try {
			     
			    MimeMessageHelper helper = new MimeMessageHelper(message, true);
			    
			    helper.setFrom("noreply@baeldung.com");
			    helper.setTo(to);
			    helper.setSubject(subject);
			    helper.setText(text);
			        
			    FileSystemResource file 
			      = new FileSystemResource(new File(pathToAttachment));
			    helper.addAttachment("ticket", file);

			    emailSender.send(message);
			    }catch(Exception e) {
			    	System.out.println(e);
			    }
			}

}
