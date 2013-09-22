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
import com.untitle.inventory.dto.ItemHeaderDTO;
import com.untitle.inventory.dto.OpeningStockDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.service.IIngredientMasterService;
import com.untitle.inventory.service.IOpeningStockService;
import com.untitle.inventory.service.IUOMMasterService;
import com.untitle.inventory.service.IUnitMasterService;



public class OpeningStockDataAction extends CommonAction {

	HttpServletRequest request;
	@Autowired
	IOpeningStockService openingStockService;
	@Autowired
	IIngredientMasterService ingredientMasterService;
	@Autowired
	IUOMMasterService uomMasterService;
	@Autowired
	IUnitMasterService unitMasterService;
	public IIngredientMasterService getIngredientMasterService() {
		return ingredientMasterService;
	}

	public void setIngredientMasterService(
			IIngredientMasterService ingredientMasterService) {
		this.ingredientMasterService = ingredientMasterService;
	}

	public IOpeningStockService getOpeningStockService() {
		return openingStockService;
	}

	public void setOpeningStockService(IOpeningStockService openingStockService) {
		this.openingStockService = openingStockService;
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

	
	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}

	public String saveData()
	{
		callBackStatus=new CallBackStatus();
		OpeningStockDTO openingStockDTO=new OpeningStockDTO();
		try
		{
		String voucherCode=request.getParameter("voucherCode");
		
		if(voucherCode!=null && !voucherCode.equalsIgnoreCase(""))
		openingStockDTO.setVoucherCode(Long.parseLong(voucherCode));
		
		String type=request.getParameter("type");
		String itemCode=request.getParameter("itemCode");
		String uomCode=request.getParameter("baseUOM");
		String damageduomCode=request.getParameter("damagedQtyUOM");
		String unit=request.getParameter("unit");
		String openingDate=request.getParameter("openingDate");
		String openingQty=request.getParameter("openingQty");		
		String damagedQty=request.getParameter("damagedQty");	
		String price=request.getParameter("price");	
		
		if(type.equalsIgnoreCase("1"))
		{
			openingStockDTO.setType(Integer.parseInt(type));
			openingStockDTO.setIngredientMasterDTO(ingredientMasterService.getIngredientDetailsById(Long.parseLong(itemCode)));
		}
		else
		{
			openingStockDTO.setType(Integer.parseInt(type));
			ItemHeaderDTO itemHeaderDTO=new ItemHeaderDTO();
			itemHeaderDTO.setId(Long.parseLong(itemCode));
			openingStockDTO.setItemHeaderDTO(itemHeaderDTO);
		}
		
		
		openingStockDTO.setOpeningDate(openingDate);
		openingStockDTO.setOpeningQty(Double.parseDouble(openingQty));
		openingStockDTO.setDamagedQty(Double.parseDouble(damagedQty));
		openingStockDTO.setPrice(Double.parseDouble(price));
		
		openingStockDTO.setUnitMasterDTO(unitMasterService.getUnitDetailsById(Long.parseLong(unit)));
		openingStockDTO.setUomMasterDTO(uomMasterService.getUOMDetailsById(uomCode));
		openingStockDTO.setUomMasterDamagedDTO((uomMasterService.getUOMDetailsById(damageduomCode)));
		
		openingStockService.save(openingStockDTO);
		
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

	public IUOMMasterService getUomMasterService() {
		return uomMasterService;
	}

	public void setUomMasterService(IUOMMasterService uomMasterService) {
		this.uomMasterService = uomMasterService;
	}

	public IUnitMasterService getUnitMasterService() {
		return unitMasterService;
	}

	public void setUnitMasterService(IUnitMasterService unitMasterService) {
		this.unitMasterService = unitMasterService;
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
			//searchCond.put("rangeCode", request.getParameter("rangeCode"));
			//searchCond.put("rangeDesc", request.getParameter("rangeDesc"));
			filterCriteria.setSearchCriteria(searchCond);
		}		
		int count;
		List<OpeningStockDTO> openingStockDTOs=new ArrayList<OpeningStockDTO>();
		gridData=openingStockService.getData(filterCriteria);
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<OpeningStockDTO> openingStockGridData = new ArrayList<OpeningStockDTO>();
		openingStockGridData = (List<OpeningStockDTO>) gridData.getListData();
		for(OpeningStockDTO openingStockDTO:openingStockGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add(openingStockDTO.getVoucherCode()+"");
			cells.add(openingStockDTO.getType()==1?"Ingredient":"Fininshed Goods");
			cells.add(openingStockDTO.getType()==1?openingStockDTO.getIngredientMasterDTO().getIngDesc():openingStockDTO.getItemHeaderDTO().getItemDesc());
			row.setId(openingStockDTO.getVoucherCode()+"");
			row.setCell(cells); 
			rows.add(row);
		}
		jsonData.setRows(rows);
		
		
		return Action.SUCCESS;
		
	}

	
}















