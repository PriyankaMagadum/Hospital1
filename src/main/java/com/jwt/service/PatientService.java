package com.jwt.service;

import java.util.List;

import com.jwt.model.Patients;



public interface PatientService {

	public String addPatients(Patients patients);
	
	public List<Patients> getAllPatients();
	public Patients getByRegistartionNo(String registrationNo);
	
}
