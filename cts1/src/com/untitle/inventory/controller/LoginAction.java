package com.untitle.inventory.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.dto.UserMasterDTO;
import com.untitle.inventory.service.IMenuService;
import com.untitle.inventory.service.IUserMasterService;



public class LoginAction implements ServletRequestAware,ParameterAware 
{
		
	HttpServletRequest request;
	
	@Autowired
	IUserMasterService userMasterService;
	@Autowired
	IMenuService menuService;
		public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

		public IUserMasterService getUserMasterService() {
		return userMasterService;
	}

	public void setUserMasterService(IUserMasterService userMasterService) {
		this.userMasterService = userMasterService;
	}
	
		public String authenticate()
	{	
			String result="";
		try
		{
		HttpSession session = request.getSession(true);
		String userName=request.getParameter("txtUserName");
		String password=request.getParameter("txtPassword");
		UserMasterDTO userMasterDTO=userMasterService.authenticate(userName, password);
		
		if(userMasterDTO!=null)
		{
			session.setAttribute("userDetails",userMasterDTO);
			List<MenuMasterDTO> MenuMasterDTO= menuService.getAccessMenu(userMasterDTO.getUserTypeMasterDTO().getId());
			System.out.println("after userMasterDTO");
			session.setAttribute("menuDetails", MenuMasterDTO);
			result="success";
		}
		else
		{
			result="failed";
			request.setAttribute("loginFailedMessage","Invalid Username Or Password");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="failed";
		}
	    return result;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String logout() throws Exception
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "loginPage";
	}
	
	public String changePasswordData() throws Exception
	{
				
		//callBackStatus = new CallBackStatus();
		try
			{
			
			    //String userName = (UserMasterDTO;
				String password = request.getParameter("oldPassword");
				//String encrPassword = PasswordEncrypt.encrypt(password);
					
				String newPassword = request.getParameter("newPassword");
				String confirmPassword = request.getParameter("confirmPassword");
			
				HttpSession session = request.getSession();
				//session.invalidate();
				System.out.println(session);
				
				UserMasterDTO userDetails = (UserMasterDTO) session.getAttribute("userDetails");
				
				  Long id = Long.parseLong(request.getParameter("id"));
		   		  if(id!=0)
		   		   {
		   			userDetails.setId(id);
		   		   }
				
				userDetails.setUserName(userDetails.getUserName());
			
					//userDetails.setPassword(encrPassword);
					//userDetails.setPassword(firstPass);
					//callBackStatus.setStatus("success");

					if(password.equalsIgnoreCase(userDetails.getPassword()))
					{
					
					 if(confirmPassword.equals(newPassword))
						{
							userDetails.setPassword(newPassword);
							//callBackStatus.setStatus("success");
						}
					 else
					 {
						// callBackStatus.setErrorMessage("U have enterd a wrong confirm password");
						// callBackStatus.setStatus("U have enterd a wrong confirm password");
					 }
					
				}
				else
				{
					 //callBackStatus.setErrorMessage("U have entered a wrong old password");
					// callBackStatus.setStatus("U have entered a wrong old password");
					
				}
		
		 userMasterService.changePassword(userDetails);
		 
		// callBackStatus.setStatus("failed");
		
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			 //callBackStatus.setErrorMessage(e.toString());
			// callBackStatus.setStatus("success");
				
		}
		return Action.SUCCESS;
	}
	
	public String register() {
		return Action.SUCCESS;
	}
	
		
}
