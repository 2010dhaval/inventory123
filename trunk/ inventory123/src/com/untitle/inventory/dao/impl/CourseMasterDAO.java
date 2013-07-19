package com.untitle.inventory.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.untitle.inventory.dao.ICourseMasterDAO;
import com.untitle.inventory.model.UOMMaster;

public class CourseMasterDAO extends HibernateDaoSupport implements ICourseMasterDAO {

	@Override
	public List<UOMMaster> getCourseDetails() {
		// TODO Auto-generated method stub
		try
		{
			return getHibernateTemplate().findByNamedQuery("getCourseDetails");	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public UOMMaster getCourseDetailsById(String courseId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(UOMMaster.class, courseId);
	}

	@Override
	public void save(UOMMaster courseMaster) {
		// TODO Auto-generated method stub
		try
		{
			if(getHibernateTemplate().get(UOMMaster.class, courseMaster.getId())==null)
			getHibernateTemplate().save(courseMaster);	
			else
			getHibernateTemplate().update(courseMaster);	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
		}

	}

	@Override
	public List<UOMMaster> getCoursesByQual(String qual) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from CourseMaster cm where cm.courseDesc like :qual");
		List<UOMMaster> courseMasters = query.setParameter("qual", "%" +qual + "%").list();
		return courseMasters;
		//return null;
	}

}
