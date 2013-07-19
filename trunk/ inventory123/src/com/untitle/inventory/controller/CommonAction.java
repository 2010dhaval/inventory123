package com.untitle.inventory.controller;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.untitle.inventory.commons.CallBackStatus;
import com.untitle.inventory.commons.JQGridJSON;



public abstract class CommonAction implements ParameterAware,ServletRequestAware
{
	private static Logger logger = LoggerFactory.getLogger("name");
	protected JQGridJSON jsonData;
	protected CallBackStatus callBackStatus;
	protected Map<String,String[]> parameters;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	static String[] months = { "January", "February", "March", "April", "May",
		"June", "July", "August", "September", "October", "November",
		"December" };

	protected Map<String,String> result;

	public JQGridJSON getJsonData() {
		return jsonData;
	}

	/**
	 * @return the callBackStatus
	 */
	public CallBackStatus getCallBackStatus() {
		return callBackStatus;
	}

	/**
	 * @param callBackStatus the callBackStatus to set
	 */
	public void setCallBackStatus(CallBackStatus callBackStatus) {
		this.callBackStatus = callBackStatus;
	}

	public void setSampleList(JQGridJSON jsonData) {
		this.jsonData= jsonData;
	}

	public Map<String,String[]>  getParameters() {
		return parameters;
	}

	public void setParameters(Map<String,String[]> parameters) {
		this.parameters = parameters;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	public Map<String,String> getResult()
	{
		return result;
	}
	
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public String getParameterValue(String param) 
	{
		Object varr = getParameters().get(param);
		if (varr == null) return null;
		return ((String[]) varr)[0];
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request =request;
	}

	
	protected Long getLongFromRequest(String paramName)
	{
		try
		{
			return Long.parseLong(getParameterValue(paramName));
		}catch(NumberFormatException exp)
		{
			logger.error("Error occured while retreiving Long "+paramName+" from reqeuest" , exp);
			return null;
		}
	}
	
	
	/*public static String getWorkspaceLocation()
	{
		Location instanceLoc=	Platform.getInstanceLocation();
		return instanceLoc.getURL().getPath();
	}*/
    
	public static String getStringFromDate(Date date)
	{
		return new SimpleDateFormat("MM/dd/yyyy").format(date, new StringBuffer(), new FieldPosition(0)).toString();
	}
	
	
	public static String getMonthInString(int month)
	{
		return months[month];
	}
	
}
