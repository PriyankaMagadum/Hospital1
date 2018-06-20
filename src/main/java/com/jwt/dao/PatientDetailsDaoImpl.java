package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.PatientDetails;

@Repository
public class PatientDetailsDaoImpl implements PatientDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void SavePatientDetails(PatientDetails patientDetails) {
		System.out.println("in patient details dao");
		sessionFactory.getCurrentSession().saveOrUpdate(patientDetails);
	}

}
