package com.untitle.inventory.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.untitle.inventory.dao.IMenuAccessDAO;
import com.untitle.inventory.model.MenuAccess;
import com.untitle.inventory.model.MenuMaster;

public class MenuAccessDAO extends HibernateDaoSupport implements IMenuAccessDAO {

		@Override
		public void saveOrUpdate(MenuAccess menuAccess) {
			// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(menuAccess);
	}

		@SuppressWarnings("unchecked")
		@Override
		public List<MenuAccess> getMenuAccess(Long userTypeId) {
			// TODO Auto-generated method stub
			return getHibernateTemplate().findByNamedQueryAndNamedParam("getMenuAccess", "userTypeId", userTypeId);
		}
		
		// To modify access Details
		@Override
		public void modifyMenuAccessData(Long userTypeId, List accessIds) {
			// TODO Auto-generated method stub
			String deleteQuery = "DELETE FROM MenuAccess WHERE userTypeId = :userTypeId AND menuId NOT IN (:accessIds)";
			Query delQuery = (Query) getSession().createQuery(deleteQuery);
			delQuery.setLong("userTypeId", userTypeId);
			delQuery.setParameterList("accessIds", accessIds);
			delQuery.executeUpdate();
			
			String selMenu = "FROM MenuMaster where id not in (SELECT ma.menuId FROM MenuAccess ma WHERE ma.userTypeId = :userTypeId ) and id in (:accessIds)";
			
			Query selMenuQuery = (Query) getSession().createQuery(selMenu);
			selMenuQuery.setLong("userTypeId",userTypeId);
			selMenuQuery.setParameterList("accessIds", accessIds);
			List<MenuMaster> menuList = selMenuQuery.list();	
			for(MenuMaster menu:menuList)
			{
				MenuAccess menuAccess = new MenuAccess();
				menuAccess.setMenuId(menu.getId());
				menuAccess.setUserTypeId(userTypeId);
				getHibernateTemplate().saveOrUpdate(menuAccess);
			}
		}

}
