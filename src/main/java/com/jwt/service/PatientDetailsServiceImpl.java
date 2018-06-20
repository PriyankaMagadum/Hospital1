package com.jwt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dao.PatientDetailsDao;
import com.jwt.dao.PatientsDao;
import com.jwt.model.PatientDetails;
import com.jwt.model.Patients;

@Service
@Transactional
public class PatientDetailsServiceImpl implements PatientDetailsService {
@Autowired 
private PatientDetailsDao patientDetailsDao;

@Autowired
private PatientsDao patientsDao;
	@Override
	public String savePatirntDetails(PatientDetails patientDetails) {
		String abc="Ok";
		System.out.println("in service details");
		
		Patients patients=patientsDao.getByRegistrationNo(patientDetails.getRegistrationNo());
		//System.out.println("name in service="+patients.getPatientName());
		if(patients!=null)
		{
			System.out.println("not null...");
			PatientDetails patientDetails2=new PatientDetails();
			patientDetails.setPatients(patients);
			patientDetailsDao.SavePatientDetails(patientDetails);
		}
		
		
		
		
			System.out.println("add Patients service....");
		
		
	
		return abc;
		
	}

	
	
}
