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
import com.untitle.inventory.dto.ItemDetailsDTO;
import com.untitle.inventory.dto.ItemHeaderDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.IItemService;



public class ItemGridDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	IItemService itemService;
	
	public IItemService getItemService() {
		return itemService;
	}

	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	CallBackStatus callBackStatus;
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

	ItemHeaderDTO itemHeaderDTO=null;
	
	public ItemHeaderDTO getItemHeaderDTO() {
		return itemHeaderDTO;
	}

	public void setItemHeaderDTO(ItemHeaderDTO itemHeaderDTO) {
		this.itemHeaderDTO = itemHeaderDTO;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
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
			searchCond.put("ingCode", request.getParameter("itemCode"));
			searchCond.put("ingDesc", request.getParameter("itemCode"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;		
		List<ItemHeaderDTO> itemHeaderDTOs=new ArrayList<ItemHeaderDTO>();
		gridData=ingredientMasterService.getIngredientDetails(filterCriteria);
		ItemHeaderDTO itemHeaderDTO=null;
		UOMMasterDTO uomMasterDTO=null;
		RangeMasterDTO rangeMasterDTO=null;
		List<ItemDetailsDTO> itemDetailsDTOs=new ArrayList<ItemDetailsDTO>();
		
	/*	itemHeaderDTO=new ItemHeaderDTO();
		itemHeaderDTO.setId(1l);
		itemHeaderDTO.setItemDesc("KK");
		itemHeaderDTO.setSellingPrice(123d);
		itemHeaderDTO.setWarningQty(12d);
		
		itemHeaderDTOs.add(itemHeaderDTO);
		
		itemHeaderDTO=new ItemHeaderDTO();
		itemHeaderDTO.setId(2l);
		itemHeaderDTO.setItemDesc("HH");
		itemHeaderDTO.setSellingPrice(153d);
		itemHeaderDTO.setWarningQty(18d);
		
		itemHeaderDTOs.add(itemHeaderDTO);
		
		gridData=new GridData();
		gridData.setCount(23);
		gridData.setListData(itemHeaderDTOs);
		
		// end of testing code-----------------------------
*/		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<ItemHeaderDTO> itemGridData = new ArrayList<ItemHeaderDTO>();
		itemGridData = (List<ItemHeaderDTO>) gridData.getListData();
		for(ItemHeaderDTO item:itemGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(item.getId()+"");
			cells.add(item.getItemDesc());				
			
			cells.add(item.getRangeMasterDTO().getRangeCode());
			cells.add(item.getUomMasterDTO().getUomName());
			cells.add(item.getSellingPrice()+"");
			cells.add(item.getWarningQty()+"");
			
			row.setId(item.getId()+"");
			row.setCell(cells); 
			rows.add(row);
		}
		jsonData.setRows(rows);
		
		
		return Action.SUCCESS;
		
	}

		
	public String getItemByCode()
	{
		String itemCode="1";
		
		itemHeaderDTO=new ItemHeaderDTO();
		itemHeaderDTO.setId(1l);
		itemHeaderDTO.setItemDesc("KK");
		itemHeaderDTO.setSellingPrice(123d);
		
		return Action.SUCCESS;
	}
	
	public String delete()
	{
		callBackStatus=new CallBackStatus();
		try
		{
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
	
}
