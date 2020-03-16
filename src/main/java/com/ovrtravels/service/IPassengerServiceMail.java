package com.ovrtravels.service;

public interface IPassengerServiceMail {

	public void sendEmail(String toAddress, String subject, String message); /* throws MessagingException */ 
}
  