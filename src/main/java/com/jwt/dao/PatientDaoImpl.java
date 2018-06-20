package com.jwt.dao;

import java.util.List;

import org.hibernate.AssertionFailure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
import com.jwt.model.Patients;
@Repository
public class PatientDaoImpl implements PatientsDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addPatients(Patients patients)throws ConstraintViolationException,AssertionFailure{
	/*sessionFactory=new Configuration().configure().buildSessionFactory();
	 Session session = sessionFactory.openSession();
	 Transaction tx = null;
	 tx = session.beginTransaction();
	 
	 session.saveOrUpdate(patients);*/
	
	
	
		sessionFactory.getCurrentSession().saveOrUpdate(patients);
	 
	/* tx.commit();
	 session.close();*/
	}
	@Override
	public List<Patients> getAllPatients() {
	
		return sessionFactory.getCurrentSession().createQuery(" from Patients").list();
	}
	
	@Override
	public Patients getByRegistrationNo(String registrationNo) {
		System.out.println("getbyregino....="+registrationNo);
		Patients p=(Patients) sessionFactory.getCurrentSession().createQuery("from Patients p where p.registrationNo=:registrationNo").setString("registrationNo", "as1 ").uniqueResult();
	System.out.println("pname="+p.getPatientName());
		return p;
				
		
	}

}
