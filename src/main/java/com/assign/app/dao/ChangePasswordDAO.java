package com.assign.app.dao;



import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.UserDTO;

@Repository
public class ChangePasswordDAO {

	@Autowired
	private SessionFactory factory;
	
	public ChangePasswordDAO() {
		System.out.println("created \n"+this.getClass().getSimpleName());
	}


	public String changePasswordDAO(String newPassword, String email) {
		
		String hql ="update UserDTO set password=:np where email=:em";
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		int status=1;
		
		Query query = session.createQuery(hql);
		query.setParameter("np", newPassword);
		query.setParameter("em", email);
		
		UserDTO userDTO = new UserDTO();
		System.out.println("update UserDTO:"+userDTO);
		
		int i=(int) query.executeUpdate();
		
		System.out.println("update password row:"+i);
		transaction.commit();
		

	 return "System.out.println(\"successfull return userDTO.....\");";
	
		
	}

}
