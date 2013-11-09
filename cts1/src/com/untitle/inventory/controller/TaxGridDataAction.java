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
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.ITaxMasterService;
import com.untitle.inventory.service.IUOMMasterService;



public class TaxGridDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	ITaxMasterService taxMasterService;
	
	public ITaxMasterService getTaxMasterService() {
		return taxMasterService;
	}

	public void setTaxMasterService(ITaxMasterService taxMasterService) {
		this.taxMasterService = taxMasterService;
	}

	
	CallBackStatus callBackStatus;
	List<TaxMasterDTO> taxMasterDTOs;
		public List<TaxMasterDTO> getTaxMasterDTOs() {
		return taxMasterDTOs;
	}

	public void setTaxMasterDTOs(List<TaxMasterDTO> taxMasterDTOs) {
		this.taxMasterDTOs = taxMasterDTOs;
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
			searchCond.put("taxCode", request.getParameter("taxCode"));
			searchCond.put("taxDesc", request.getParameter("taxDesc"));
			searchCond.put("taxPercentage",request.getParameter("taxPer"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<TaxMasterDTO> taxMasterDTOs=new ArrayList<TaxMasterDTO>();
		gridData=taxMasterService.getTaxDetails(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<TaxMasterDTO> taxGridData = new ArrayList<TaxMasterDTO>();
		taxGridData = (List<TaxMasterDTO>) gridData.getListData();
		for(TaxMasterDTO objTax:taxGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(objTax.getTaxCode());
			cells.add(objTax.getTaxDesc());
			cells.add(""+objTax.getTaxPercentage());
			row.setId(objTax.getTaxCode());
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
		String taxCode=request.getParameter("taxCode");
		String taxDesc=request.getParameter("taxDesc");
		String taxPer=request.getParameter("taxPer");
		
		TaxMasterDTO taxMasterDTO=new TaxMasterDTO();
		taxMasterDTO.setTaxCode(taxCode);
		taxMasterDTO.setTaxDesc(taxDesc);
		taxMasterDTO.setTaxPercentage(Double.parseDouble(taxPer));
		taxMasterDTO.setIsDeleted(0);
		taxMasterService.save(taxMasterDTO);
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
	public String deleteTax()
	{
		callBackStatus=new CallBackStatus();
		try
		{
		String taxCode=request.getParameter("id");
		taxMasterService.delete(taxCode);
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
