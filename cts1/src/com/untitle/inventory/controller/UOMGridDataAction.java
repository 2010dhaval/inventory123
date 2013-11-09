package com.untitle.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.untitle.inventory.commons.CallBackStatus;
import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.commons.JQGridJSON;
import com.untitle.inventory.commons.JQGridRow;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.IUOMMasterService;



public class UOMGridDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	IUOMMasterService uomMasterService;
	public IUOMMasterService getUomMasterService() {
		return uomMasterService;
	}

	public void setUomMasterService(IUOMMasterService uomMasterService) {
		this.uomMasterService = uomMasterService;
	}

	public List<UOMMasterDTO> getUomMasterDTOs() {
		return uomMasterDTOs;
	}

	public void setUomMasterDTOs(List<UOMMasterDTO> uomMasterDTOs) {
		this.uomMasterDTOs = uomMasterDTOs;
	}

	CallBackStatus callBackStatus;
	List<UOMMasterDTO> uomMasterDTOs;
		public CallBackStatus getCallBackStatus() {
		return callBackStatus;
	}

	public void setCallBackStatus(CallBackStatus callBackStatus) {
		this.callBackStatus = callBackStatus;
	}

	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	
	JQGridJSON jsonData;
	
	public JQGridJSON getJsonData() {
		return jsonData;
	}

	public void setJsonData(JQGridJSON jsonData) {
		this.jsonData = jsonData;
	}

	public String getData()
	{
		FilterCriteria filterCriteria = new FilterCriteria();
		GridData gridData;
		filterCriteria.setSidx(request.getParameter("sidx")==null?"id":request.getParameter("sidx"));
		filterCriteria.setSord(request.getParameter("sord")==null?"ASC":request.getParameter("sord"));
		filterCriteria.setCurrentPage(request.getParameter("page")==null?"1":request.getParameter("page"));
		filterCriteria.setLimit(request.getParameter("rows")==null?"10":request.getParameter("rows"));
		if(request.getParameter("_search")!=null && request.getParameter("_search").equalsIgnoreCase("true"))
		{
			Map<String,String> searchCond = new HashMap<String, String>();
			searchCond.put("id", request.getParameter("id"));
			searchCond.put("uomName", request.getParameter("uomName"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<UOMMasterDTO> uomMasterDTOs=new ArrayList<UOMMasterDTO>();
		gridData=uomMasterService.getUOMDetails(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<UOMMasterDTO> userGridData = new ArrayList<UOMMasterDTO>();
		userGridData = (List<UOMMasterDTO>) gridData.getListData();
		for(UOMMasterDTO objUser:userGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(objUser.getId()+"");
			cells.add(objUser.getUomName()); 
			row.setId(objUser.getId());
			row.setCell(cells); 
			rows.add(row);
		}
		jsonData.setRows(rows);
		
		
		return Action.SUCCESS;
		
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}

	public String saveData()
	{
		callBackStatus=new CallBackStatus();
		try
		{
		System.out.println(request.getParameter("id"));
		String id=request.getParameter("id");
		String uomName=request.getParameter("uomName");
		UOMMasterDTO uomMasterDTO=new UOMMasterDTO();
		uomMasterDTO.setId(id);
		uomMasterDTO.setUomName(uomName);
		uomMasterService.save(uomMasterDTO);
		callBackStatus.setStatus("success");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			callBackStatus.setStatus("failed");
			callBackStatus.setErrorMessage(e.getMessage());
		}
		return Action.SUCCESS;
	}
	public String deleteUOM() 	
	{
		callBackStatus=new CallBackStatus();
		try
		{
		System.out.println(request.getParameter("id"));
		String id=request.getParameter("id");
		uomMasterService.delete(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			callBackStatus.setStatus("failed");
			callBackStatus.setErrorMessage(e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	public String getAllUOM()
	{
		uomMasterDTOs=uomMasterService.getUOMDetails();
		return Action.SUCCESS;
	}

}
