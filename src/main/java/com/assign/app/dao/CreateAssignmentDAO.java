package com.assign.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.CreateAssignmentDTO;

@Repository
public class CreateAssignmentDAO {

	@Autowired
	private SessionFactory factory;

	public void createAssignment(CreateAssignmentDTO assignmentDTO) {

		System.out.println("invoked CreateAssignmentDAO ");
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(assignmentDTO);
		transaction.commit();

	}
}
