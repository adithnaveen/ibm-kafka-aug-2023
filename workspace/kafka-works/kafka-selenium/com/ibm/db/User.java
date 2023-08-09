package com.ibm.db;

public class User {
	private String fullName; 
	private String email; 
	private String eventDate; 
	private String additionalDetails;
	
	public User() {}
	public User(String fullName, String email, String eventDate, String additionalDetails) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.eventDate = eventDate;
		this.additionalDetails = additionalDetails;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", eventDate=" + eventDate + ", additionalDetails="
				+ additionalDetails + "]";
	} 
	
	
}
