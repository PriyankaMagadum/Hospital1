package com.jwt.dao;




import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.Patients;

public interface PatientsDao {
	
	public void addPatients(Patients patients);
	public List<Patients> getAllPatients();
	public Patients getByRegistrationNo(String registrationNo);

}
