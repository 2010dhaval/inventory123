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
import com.untitle.inventory.dto.UnitMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.IUnitMasterService;
import com.untitle.inventory.service.IUOMMasterService;



public class UnitGridDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	IUnitMasterService unitMasterService;
	
	public IUnitMasterService getUnitMasterService() {
		return unitMasterService;
	}

	public void setUnitMasterService(IUnitMasterService unitMasterService) {
		this.unitMasterService = unitMasterService;
	}

	
	CallBackStatus callBackStatus;
	List<UnitMasterDTO> unitMasterDTOs;
		public List<UnitMasterDTO> getUnitMasterDTOs() {
		return unitMasterDTOs;
	}

	public void setUnitMasterDTOs(List<UnitMasterDTO> unitMasterDTOs) {
		this.unitMasterDTOs = unitMasterDTOs;
	}

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
			searchCond.put("unitCode", request.getParameter("unitCode"));
			searchCond.put("unitName", request.getParameter("unitName"));
			searchCond.put("unitAddress", request.getParameter("unitAddress"));
			searchCond.put("unitResPerName", request.getParameter("resPerName"));
			searchCond.put("unitResPerContactNo", request.getParameter("resPerContactNo"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<UnitMasterDTO> unitMasterDTOs=new ArrayList<UnitMasterDTO>();
		gridData=unitMasterService.getUnitDetails(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<UnitMasterDTO> unitGridData = new ArrayList<UnitMasterDTO>();
		unitGridData = (List<UnitMasterDTO>) gridData.getListData();
		for(UnitMasterDTO objUnit:unitGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(objUnit.getUnitCode()+"");
			cells.add(objUnit.getUnitName());
			cells.add(objUnit.getUnitAddress());
			cells.add(objUnit.getResPerName());
			cells.add(objUnit.getResPerContactNo());
			row.setId(objUnit.getUnitCode()+"");
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
		String unitCode=request.getParameter("unitCode");
		String unitName=request.getParameter("unitName");
		String unitAddress=request.getParameter("unitAddress");
		String resPerName=request.getParameter("resPerName");
		String resPerContactNo=request.getParameter("resPerContactNo");
		
		UnitMasterDTO unitMasterDTO=new UnitMasterDTO();
		if(unitCode!=null && !unitCode.equalsIgnoreCase(""))
		unitMasterDTO.setUnitCode(Long.parseLong(unitCode));
		unitMasterDTO.setUnitAddress(unitAddress);
		unitMasterDTO.setUnitName(unitName);
		unitMasterDTO.setResPerName(resPerName);
		unitMasterDTO.setResPerContactNo(resPerContactNo);
		unitMasterDTO.setIsDeleted(0);
		unitMasterService.save(unitMasterDTO);
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
	public String deleteUnit()
	{
		callBackStatus=new CallBackStatus();
		try
		{
		String unitCode=request.getParameter("id");
		unitMasterService.delete(Long.parseLong(unitCode));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			callBackStatus.setStatus("failed");
			callBackStatus.setErrorMessage(e.getMessage());
		}
		return Action.SUCCESS;
	}

}
