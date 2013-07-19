package com.untitle.inventory.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.untitle.inventory.dao.IMenuMasterDAO;
import com.untitle.inventory.model.MenuMaster;

public class MenuMasterDAO extends HibernateDaoSupport implements IMenuMasterDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuMaster> getMenuData(Long parentMenuId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByNamedQueryAndNamedParam("getMenu", "parentMenuId", parentMenuId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuMaster> getMenuData(Long parentMenuId, Long userTypeId) {
		// TODO Auto-generated method stub
		String names[] = new String[2];
		names[0] = "parentMenuId";
		names[1]= "userTypeId";
		Object values[] = new Object[2];
		values[0] = parentMenuId;
		values[1] = userTypeId;
		return getHibernateTemplate().findByNamedQueryAndNamedParam("getMenuAccessUsingUserTypeId", names, values);
	}

}
