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
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.IRangeMasterService;
import com.untitle.inventory.service.IUOMMasterService;



public class RangeGridDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	IRangeMasterService rangeMasterService;
	
	public IRangeMasterService getRangeMasterService() {
		return rangeMasterService;
	}

	public void setRangeMasterService(IRangeMasterService rangeMasterService) {
		this.rangeMasterService = rangeMasterService;
	}

	
	CallBackStatus callBackStatus;
	List<RangeMasterDTO> rangeMasterDTOs;
		public List<RangeMasterDTO> getRangeMasterDTOs() {
		return rangeMasterDTOs;
	}

	public void setRangeMasterDTOs(List<RangeMasterDTO> rangeMasterDTOs) {
		this.rangeMasterDTOs = rangeMasterDTOs;
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
			searchCond.put("rangeCode", request.getParameter("rangeCode"));
			searchCond.put("rangeDesc", request.getParameter("rangeDesc"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<RangeMasterDTO> rangeMasterDTOs=new ArrayList<RangeMasterDTO>();
		gridData=rangeMasterService.getRangeDetails(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<RangeMasterDTO> rangeGridData = new ArrayList<RangeMasterDTO>();
		rangeGridData = (List<RangeMasterDTO>) gridData.getListData();
		for(RangeMasterDTO objRange:rangeGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(objRange.getRangeCode());
			cells.add(objRange.getRangeDesc());
			row.setId(objRange.getRangeCode());
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
		String rangeCode=request.getParameter("rangeCode");
		String rangeDesc=request.getParameter("rangeDesc");
		String rangePer=request.getParameter("rangePer");
		
		RangeMasterDTO rangeMasterDTO=new RangeMasterDTO();
		rangeMasterDTO.setRangeCode(rangeCode);
		rangeMasterDTO.setRangeDesc(rangeDesc);
		rangeMasterDTO.setIsDeleted(0);
		rangeMasterService.save(rangeMasterDTO);
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
	public String deleteRange()
	{
		callBackStatus=new CallBackStatus();
		try
		{
		String rangeCode=request.getParameter("id");
		rangeMasterService.delete(rangeCode);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			callBackStatus.setStatus("failed");
			callBackStatus.setErrorMessage(e.getMessage());
		}
		return Action.SUCCESS;
	}
	
	public String getAllRange()
	{
		rangeMasterDTOs=rangeMasterService.getRangeDetails();
		return Action.SUCCESS;
	}

}
