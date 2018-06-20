package com.jwt.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class PatientDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int patientDetailsId;
	@Transient
	String registrationNo;
	String opd;
	String complaint;
	String treatement;
	Date createDate;
	
	
	
	/**
	 * 
	 */
	public PatientDetails() {
		super();
	}
	
	
	
	
	@ManyToOne
	@JoinColumn(name="registration_no",referencedColumnName="registration_no")
	private Patients patients;

	
	
	

	public PatientDetails(String registrationNo, String opd, String complaint, String treatement, Date createDate) {
		super();
		this.registrationNo = registrationNo;
		this.opd = opd;
		this.complaint = complaint;
		this.treatement = treatement;
		this.createDate = createDate;
	}



	/**
	 * @param patientDetailsId
	 * @param opd
	 * @param complaint
	 * @param treatement
	 * @param createDate
	 * @param patients
	 */
	public PatientDetails(int patientDetailsId, String opd, String complaint, String treatement, Date createDate,
			Patients patients) {
		super();
		this.patientDetailsId = patientDetailsId;
		this.opd = opd;
		this.complaint = complaint;
		this.treatement = treatement;
		this.createDate = createDate;
		this.patients = patients;
	}

	
	
	public PatientDetails(String opd, String complaint, String treatement, Date createDate, Patients patients) {
		super();
		this.opd = opd;
		this.complaint = complaint;
		this.treatement = treatement;
		this.createDate = createDate;
		this.patients = patients;
	}



	public PatientDetails(String registrationNo) {
		super();
		this.registrationNo = registrationNo;
	}



	/**
	 * @return the patientDetailsId
	 */
	public int getPatientDetailsId() {
		return patientDetailsId;
	}

	/**
	 * @param patientDetailsId the patientDetailsId to set
	 */
	public void setPatientDetailsId(int patientDetailsId) {
		this.patientDetailsId = patientDetailsId;
	}

	/**
	 * @return the opd
	 */
	public String getOpd() {
		return opd;
	}

	/**
	 * @param opd the opd to set
	 */
	public void setOpd(String opd) {
		this.opd = opd;
	}

	/**
	 * @return the complaint
	 */
	public String getComplaint() {
		return complaint;
	}

	/**
	 * @param complaint the complaint to set
	 */
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	/**
	 * @return the treatement
	 */
	public String getTreatement() {
		return treatement;
	}

	/**
	 * @param treatement the treatement to set
	 */
	public void setTreatement(String treatement) {
		this.treatement = treatement;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the patients
	 */
	public Patients getPatients() {
		return patients;
	}

	/**
	 * @param patients the patients to set
	 */
	public void setPatients(Patients patients) {
		this.patients = patients;
	}



	public String getRegistrationNo() {
		return registrationNo;
	}



	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	
	
	
	
	
	
	
	

}
