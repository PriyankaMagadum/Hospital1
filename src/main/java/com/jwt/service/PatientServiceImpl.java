package com.jwt.service;



import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.EmployeeDAO;
import com.jwt.dao.PatientsDao;
import com.jwt.model.Patients;






@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientsDao patientsDao;

	@Override
	@Transactional
	public String addPatients(Patients patients) {
		String abc="Ok";
		try{
			patientsDao.addPatients(patients);
			System.out.println("add Patients service....");
		}
		catch(Exception e){
			abc="Patient name or registration no already exist";
		}
		
		System.out.println("in add patients service implemaentation"+abc);
		return abc;
	}

	@Override
	@Transactional
	public List<Patients> getAllPatients() {
		//System.out.println("patientsname in service="+patientsDao.getAllPatients().get(9).getPatientName());
		return patientsDao.getAllPatients();
	}

	@Override
	public Patients getByRegistartionNo(String registrationNo) {
		Patients p=patientsDao.getByRegistrationNo(registrationNo);
		return p;
	}



	
}
