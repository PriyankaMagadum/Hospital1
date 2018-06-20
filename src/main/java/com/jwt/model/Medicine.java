package com.jwt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int medicineId;
	String medicineFromHospital;
	String medicineFromMedical;
	
	
	
	/**
	 * 
	 */
	public Medicine() {
		super();
	}



	
	
	
	@ManyToOne
	@JoinColumn(name="registration_no",referencedColumnName="registration_no")
	private Patients patients;



	/**
	 * @param medicineId
	 * @param medicineFromHospital
	 * @param medicineFromMedical
	 * @param patients
	 */
	public Medicine(int medicineId, String medicineFromHospital, String medicineFromMedical, Patients patients) {
		super();
		this.medicineId = medicineId;
		this.medicineFromHospital = medicineFromHospital;
		this.medicineFromMedical = medicineFromMedical;
		this.patients = patients;
	}



	/**
	 * @return the medicineId
	 */
	public int getMedicineId() {
		return medicineId;
	}



	/**
	 * @param medicineId the medicineId to set
	 */
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}



	/**
	 * @return the medicineFromHospital
	 */
	public String getMedicineFromHospital() {
		return medicineFromHospital;
	}



	/**
	 * @param medicineFromHospital the medicineFromHospital to set
	 */
	public void setMedicineFromHospital(String medicineFromHospital) {
		this.medicineFromHospital = medicineFromHospital;
	}



	/**
	 * @return the medicineFromMedical
	 */
	public String getMedicineFromMedical() {
		return medicineFromMedical;
	}



	/**
	 * @param medicineFromMedical the medicineFromMedical to set
	 */
	public void setMedicineFromMedical(String medicineFromMedical) {
		this.medicineFromMedical = medicineFromMedical;
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

	
	
}
