package com.assign.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.CreateAssignmentDTO;

@Repository
public class AssignDAO {

	@Autowired
	private SessionFactory factory;

	public CreateAssignmentDTO getCreateAssignmentFromDb(String emailFromDb, Integer pin) {

		String hql = "from CreateAssignmentDTO dto where dto.emaiId=:em and dto.pin=:pn";

		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		query.setParameter("em", emailFromDb);
		query.setParameter("pn", pin);
		CreateAssignmentDTO createAssignmentDTO = (CreateAssignmentDTO) query.uniqueResult();

		return createAssignmentDTO;
	}

}
