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
import com.untitle.inventory.dto.IngredientMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.IIngredientMasterService;



public class IngredientGridDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	IIngredientMasterService ingredientMasterService;
	
	IngredientMasterDTO ingredientMasterDTO=null;
	
	public IngredientMasterDTO getIngredientMasterDTO() {
		return ingredientMasterDTO;
	}

	public void setIngredientMasterDTO(IngredientMasterDTO ingredientMasterDTO) {
		this.ingredientMasterDTO = ingredientMasterDTO;
	}

	public IIngredientMasterService getIngredientMasterService() {
		return ingredientMasterService;
	}

	public void setIngredientMasterService(
			IIngredientMasterService ingredientMasterService) {
		this.ingredientMasterService = ingredientMasterService;
	}

	CallBackStatus callBackStatus;
	List<IngredientMasterDTO> ingredientMasterDTOs;
	
		public List<IngredientMasterDTO> getIngredientMasterDTOs() {
		return ingredientMasterDTOs;
	}

	public void setIngredientMasterDTOs(
			List<IngredientMasterDTO> ingredientMasterDTOs) {
		this.ingredientMasterDTOs = ingredientMasterDTOs;
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
			searchCond.put("ingCode", request.getParameter("ingCode"));
			searchCond.put("ingDesc", request.getParameter("ingCode"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<IngredientMasterDTO> ingredientMasterDTOs=new ArrayList<IngredientMasterDTO>();
		gridData=ingredientMasterService.getIngredientDetails(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<IngredientMasterDTO> ingredientGridData = new ArrayList<IngredientMasterDTO>();
		ingredientGridData = (List<IngredientMasterDTO>) gridData.getListData();
		for(IngredientMasterDTO objIngredient:ingredientGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(objIngredient.getIngCode()+"");
			cells.add(objIngredient.getIngDesc());
			cells.add(objIngredient.getIngRange());
			cells.add(objIngredient.getUomMasterDTO().getUomName());
			cells.add(objIngredient.getPurPrice()+"");
			cells.add(objIngredient.getWarQry()+"");
			row.setId(objIngredient.getIngCode()+"");
			row.setCell(cells); 
			rows.add(row);
		}
		jsonData.setRows(rows);
		
		
		return Action.SUCCESS;
		
	}

	public String saveData()
	{
		callBackStatus=new CallBackStatus();
		try
		{
		String ingCode=request.getParameter("ingCode");
		String ingDesc=request.getParameter("ingDesc");
		String purPrice=request.getParameter("purPrice");
		String[] range=request.getParameterValues("range");
		String r="";
		int i=0;
		for(String ra:range)
		{
			if(i==0)
			r=r+ra;
			else
				r=r+","+ra;
			i++;
		}
		String baseUOM=request.getParameter("baseUOM");
		String warQty=request.getParameter("warQty");
		
		IngredientMasterDTO ingredientMasterDTO=new IngredientMasterDTO();
		if(ingCode!=null && !ingCode.equalsIgnoreCase(""))
		ingredientMasterDTO.setIngCode(Long.parseLong(ingCode));
		ingredientMasterDTO.setIngDesc(ingDesc);
		ingredientMasterDTO.setIngRange(r);
		ingredientMasterDTO.setPurPrice(Double.parseDouble(purPrice));
		ingredientMasterDTO.setWarQry(Double.parseDouble(warQty));
		
		UOMMasterDTO uomMasterDTO=new UOMMasterDTO();
		uomMasterDTO.setId(baseUOM);
		ingredientMasterDTO.setUomMasterDTO(uomMasterDTO);
		ingredientMasterService.save(ingredientMasterDTO);
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
	
	public String getIngredientByCode()
	{
		String ingCode=request.getParameter("ingCode");
		ingredientMasterDTO=ingredientMasterService.getIngredientDetailsById(Long.parseLong(ingCode));
		return Action.SUCCESS;
	}
	
	public String delete()
	{
		callBackStatus=new CallBackStatus();
		try
		{
			String ingCode=request.getParameter("id");
			ingredientMasterService.delete(Long.parseLong(ingCode));
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
