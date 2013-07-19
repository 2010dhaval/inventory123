package com.untitle.inventory.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.untitle.inventory.constants.Constants;
import com.untitle.inventory.dao.ICommonDAO;
import com.untitle.inventory.dto.AbstractBaseEntity;
import com.untitle.inventory.model.UOMMaster;

@Repository
@Transactional
public class CommonDAO<T> extends HibernateDaoSupport implements ICommonDAO<T> {
	
	
	@Override
	public List<Map<String, Object>> findListByQueryForDynamicEntity(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByQuery(String hql, Object values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByQuery(String hql, Map properyMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery) {
		// TODO Auto-generated method stub
		
		try
		{
		Query query=getSession().getNamedQuery(namedQuery);
		return query.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery, Map properyMap) {
		// TODO Auto-generated method stub
		
		Query query=getSession().getNamedQuery(namedQuery);
		if(properyMap!=null)
			query.setProperties(properyMap);
		
		return query.list();
	}

	@Override
	public List<T> findAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mergeDynamicEntity(String entityName, Object entityMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> findByQueryForDynamicEntity(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByQueryForDynamicEntity(String hql,
			Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByQueryForDynamicEntity(String hql,
			Map propertyMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByQueryForDynamicEntityPaginated(
			String string, int rows, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findCountByQuery(String hql) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		try
		{
		getHibernateTemplate().saveOrUpdate(entity);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	@Override
	public T getById(Class<?> entity,Long id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(entity, id);
	}

	@Override
	public T getById(Class<?> entity,String id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(entity, id);
	}

	@Override
	public int getGridCount(Class<?> entityClass) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		
		try
		{
			Criteria criteria = getSession().createCriteria(entityClass);
			criteria.add(Restrictions.ne("isDeleted",1));	
			return criteria.list().size();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	
	@Override
	public List<T> getAll(int start, int limitInt, String sidx, String sord,
			Map<String, String> searchCond,Class<?> entityClass) {
		// TODO Auto-generated method stub
		Criteria criteria=getSession().createCriteria(entityClass);
		criteria.add(Restrictions.ne("isDeleted",1));
		if (searchCond != null)
		{
			for(String searchKey:searchCond.keySet())
			{
				String searchValue = searchCond.get(searchKey);
				if(searchValue!=null)
				{
					criteria.add(Restrictions.like(searchKey,searchValue+"%"));
				}
			}
		}
		if(sord.equalsIgnoreCase("DESC"))
		{
			criteria.addOrder(Order.desc(sidx));
		}
		else
		{
			criteria.addOrder(Order.asc(sidx));
		}
		criteria.setFirstResult(start);
		criteria.setMaxResults(limitInt);	
		return criteria.list();
	}

	@Override
	public List<T> getAll(Class<?> entityClass) {
		// TODO Auto-generated method stub
		Criteria criteria=getSession().createCriteria(entityClass);
		criteria.add(Restrictions.ne("isDeleted",1));
		return criteria.list();
	}


	
}
