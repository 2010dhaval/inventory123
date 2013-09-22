/**
 * File Name : AccessMenuAction.java
 * Author  : Rupangi Dave
 * Created On : 6-Aug-2011
 * Purpose  : ActionClass to assign Menu Access for respective Designation
 */
package com.untitle.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.untitle.inventory.dto.MenuAccessDTO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.service.IMenuAccessService;
import com.untitle.inventory.service.IMenuService;

public class AccessMenuAction implements ServletRequestAware{
	public HttpServletRequest request;
	@Autowired
	private IMenuAccessService menuAccessService;
	@Autowired
	private IMenuService menuService;
	private List<MenuMasterDTO> menuMasterDTO;
	private List<MenuAccessDTO> accessDTOs;
	public Map<String, Object> menu= new HashMap();
	
	public String getAccessDetails()
	{
		long designationId = Long.parseLong(request.getParameter("designationId"));
		try
		{
		// to modify access details
		if ((request.getParameter("save")).equals("true"))
		{
		String designationName = request.getParameter("designation");
		String[] ids = request.getParameterValues("menuIds");		
		List<Long> accessIds = new ArrayList<Long>();
		if (ids != null)
		{
			for(String id:ids)
			{
				accessIds.add(Long.parseLong(id));
			}
		}
		else
		{
			accessIds.add(-1l);
		}
		menuAccessService.modifyAccessDetails(designationId, accessIds);
		menu.put("success", "Data Saved Successfully");
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			menu.put("errorMsg", e.toString());
		}
		// to display tree data
		menuMasterDTO = menuService.getMenuData();
		accessDTOs = menuAccessService.getMenuId(designationId);
		menu.put("menuList", menuMasterDTO);
		menu.put("accessList", accessDTOs);
		return Action.SUCCESS;
	}
	
	public IMenuAccessService getMenuAccessService() {
		return menuAccessService;
	}

	public void setMenuAccessService(IMenuAccessService menuAccessService) {
		this.menuAccessService = menuAccessService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<MenuMasterDTO> getMenuMasterDTO() {
		return menuMasterDTO;
	}

	public void setMenuMasterDTO(List<MenuMasterDTO> menuMasterDTO) {
		this.menuMasterDTO = menuMasterDTO;
	}

	public void setAccessDTOs(List<MenuAccessDTO> accessDTOs) {
		this.accessDTOs = accessDTOs;
	}

	public List<MenuAccessDTO> getAccessDTOs() {
		return accessDTOs;
	}

	
}