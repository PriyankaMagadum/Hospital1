package com.jwt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Columns;


@Entity
public class Patients implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int patientId;
	@Column( name="registration_no",unique = true, nullable = true)
	String registrationNo;
	String patientName;
	
	
	
	
	/**
	 * 
	 */
	public Patients() {
		super();
	}




	public Patients(String registrationNo, String patientName) {
		super();
		this.registrationNo = registrationNo;
		this.patientName = patientName;
	}




	/**
	 * @param patientId
	 * @param registrationNo
	 * @param patientName
	 */
	public Patients(int patientId, String registrationNo, String patientName) {
		super();
		this.patientId = patientId;
		this.registrationNo = registrationNo;
		this.patientName = patientName;
	}


@OneToMany(mappedBy="patients")
private Set<PatientDetails> patientDetails;

@OneToMany(mappedBy="patients")
private Set<Medicine> medicine;




/**
 * @return the patientId
 */
public int getPatientId() {
	return patientId;
}




/**
 * @param patientId the patientId to set
 */
public void setPatientId(int patientId) {
	this.patientId = patientId;
}




/**
 * @return the registrationNo
 */
public String getRegistrationNo() {
	return registrationNo;
}




/**
 * @param registrationNo the registrationNo to set
 */
public void setRegistrationNo(String registrationNo) {
	this.registrationNo = registrationNo;
}




/**
 * @return the patientName
 */
public String getPatientName() {
	return patientName;
}




/**
 * @param patientName the patientName to set
 */
public void setPatientName(String patientName) {
	this.patientName = patientName;
}




/**
 * @return the patientDetails
 */
public Set<PatientDetails> getPatientDetails() {
	return patientDetails;
}




/**
 * @param patientDetails the patientDetails to set
 */
public void setPatientDetails(Set<PatientDetails> patientDetails) {
	this.patientDetails = patientDetails;
}




/**
 * @return the medicine
 */
public Set<Medicine> getMedicine() {
	return medicine;
}




/**
 * @param medicine the medicine to set
 */
public void setMedicine(Set<Medicine> medicine) {
	this.medicine = medicine;
}



}
