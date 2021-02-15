package com.ovrtravels.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="psg")
//@PropertySource("classpath:message.properties")
public class Passenger {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ticketId;
	@NotEmpty(message="first name is mandatory")
	private String firstName;
	@NotEmpty(message="last name is mandatory")
	private String lastName;
	@NotNull(message="age must be entered")

	private Integer age;
	@NotNull(message="mobile number is mandatory")
	private Long mobile;
	@NotEmpty(message="email id is mandatory")
	@Email(message="email should be in email format only")
	private String email;
	@NotEmpty(message="gender is mandatory")
	private String gender;
	@NotNull(message="journey date should not be empty")
	@JsonFormat(pattern="dd-MM-yyyy")
	@Future(message="date should be a future date")
	private Date journeyDate;
	@Id
	@NotNull(message="seat number should be entered")
	private Integer seatNo;
	
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	@Override
	public String toString() {
		return "Passenger [ticketId=" + ticketId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", mobile=" + mobile + ", email=" + email + ", gender=" + gender + ", journeyDate="
				+ journeyDate + ", seatNo=" + seatNo + "]";
	}

	


}
