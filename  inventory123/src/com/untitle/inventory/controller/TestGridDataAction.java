package com.untitle.inventory.controller;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
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
import com.untitle.inventory.dto.MaterialGroupMasterDTO;
import com.untitle.inventory.dto.PurchaseGroupMasterDTO;
import com.untitle.inventory.dto.REQDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.service.IREQMasterService;
import com.untitle.inventory.service.IRangeMasterService;

public class TestGridDataAction extends CommonAction{

	HttpServletRequest request;
	@Autowired
	IREQMasterService reqMasterService;
	
	List<MaterialGroupMasterDTO> materialGroupMasterDTOs;
	List<PurchaseGroupMasterDTO> purchaseGroupMasterDTOs;
	
	public List<PurchaseGroupMasterDTO> getPurchaseGroupMasterDTOs() {
		return purchaseGroupMasterDTOs;
	}

	public void setPurchaseGroupMasterDTOs(
			List<PurchaseGroupMasterDTO> purchaseGroupMasterDTOs) {
		this.purchaseGroupMasterDTOs = purchaseGroupMasterDTOs;
	}

	public List<MaterialGroupMasterDTO> getMaterialGroupMasterDTOs() {
		return materialGroupMasterDTOs;
	}

	public void setMaterialGroupMasterDTOs(
			List<MaterialGroupMasterDTO> materialGroupMasterDTOs) {
		this.materialGroupMasterDTOs = materialGroupMasterDTOs;
	}

	public IREQMasterService getReqMasterService() {
		return reqMasterService;
	}

	public void setReqMasterService(IREQMasterService reqMasterService) {
		this.reqMasterService = reqMasterService;
	}

	CallBackStatus callBackStatus;
	List<REQDTO> rangeMasterDTOs;
		public List<REQDTO> getRangeMasterDTOs() {
		return rangeMasterDTOs;
	}

	public void setRangeMasterDTOs(List<REQDTO> rangeMasterDTOs) {
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
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<RangeMasterDTO> rangeMasterDTOs=new ArrayList<RangeMasterDTO>();
		gridData=reqMasterService.getREQDetails(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<REQDTO> rangeGridData = new ArrayList<REQDTO>();
		rangeGridData = (List<REQDTO>) gridData.getListData();
		for(REQDTO objRange:rangeGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add("false");
			cells.add(objRange.getPreqNPO());
			cells.add(objRange.getPreqItem());
			cells.add(objRange.getPurGroup());
			cells.add(objRange.getMaterial());
			cells.add(objRange.getPlant());
			cells.add(objRange.getMaterialGroup());
			row.setId(""+objRange.getId());
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
	public String getAllMaterialGroup()
	{
		materialGroupMasterDTOs=reqMasterService.getMaterialGroupMasterDetails();
		return Action.SUCCESS;
	}
	public String getAllPurchaseGroup()
	{
		purchaseGroupMasterDTOs=reqMasterService.getPurchaseGroupMasterDetails();
		return Action.SUCCESS;
	}

		
}
