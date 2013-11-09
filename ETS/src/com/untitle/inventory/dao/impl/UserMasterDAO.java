package com.untitle.inventory.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.untitle.inventory.dao.IUserMasterDAO;
import com.untitle.inventory.model.UserMaster;

@Repository
public class UserMasterDAO implements IUserMasterDAO {

	private SessionFactory sessionFactory;

	 public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	@Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	
	private Session getSession()
	{
		try
		{
			return this.sessionFactory.getCurrentSession();
		}
		catch (Exception e) {
			// TODO: handle exception
			return this.sessionFactory.openSession();
		}
	}

	
	@Override
	public UserMaster authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		
		String[] names = new String[2];
		names[0] = "userName";
		names[1] = "password";
		Object[] values = new Object[2];
		values[0] = userName;
		values[1] = password;
		UserMaster userMaster=null;
		List<UserMaster> userMasters = null;//(List<UserMaster>) getSession().getNamed("getUserDetails", names, values);
		System.out.println("122");
		if (userMasters.size() != 0){
		userMaster=userMasters.get(0);
		}
		return userMaster;
	}

	@Override
	public void saveUserMaster(UserMaster userMaster) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(userMaster);
	}

}
