package com.ovrtravels.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ovrtravels.service.IPassengerServiceMail;

@Service
public class PassengerServiceMailImpl  implements IPassengerServiceMail{

	@Autowired
	private  JavaMailSender   javaMailSender;
	
	public void sendEmail(String toAddress, String subject, String message) /* throws MessagingException */ {
		try {
			MimeMessage  mimeMessage=javaMailSender.createMimeMessage();
			MimeMessageHelper  helper=new  MimeMessageHelper(mimeMessage,true);
			
		    helper.setTo(toAddress);
			helper.setSubject(subject);  
			helper.setSentDate(new java.util.Date());
			helper.setText(message);
			//Add path of some file zip ,rar,war,pdf,word etc 
			FileSystemResource  resource=new FileSystemResource("F:\\Nagagiridhar\\Springboot2.x-26-02-2020\\PassengerManagement\\BookingisSuccessfulTicket-Status.txt");
			
			helper.addAttachment(resource.getFilename(), resource); //"Fb_IMG.JPG"
			javaMailSender.send(mimeMessage);
			System.out.println("Mail has sent successfully!...");
			
			
			
			
			
			
		 } catch (MessagingException e) {  
				// TODO Auto-generated catch block
				e.printStackTrace();   
			 }
	}
	

}
