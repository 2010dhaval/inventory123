package com.untitle.inventory.controller;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.untitle.inventory.dto.RFQHeaderDTO;
import com.untitle.inventory.dto.RFQ_ITEMDTO;
import com.untitle.inventory.dto.RFQ_ITEM_REQ_DTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.model.RFQ_ITEM;
import com.untitle.inventory.model.RFQ_ITEM_REQ;
import com.untitle.inventory.service.IREQMasterService;
import com.untitle.inventory.service.IRangeMasterService;

public class TestGridDataAction extends CommonAction{

	//HttpServletRequest request;// dhaval
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
		
		String materialId = request.getParameter("materialId");
		String purchaseId = request.getParameter("purchaseId");
		
		System.out.println(materialId);
		System.out.println(purchaseId);
		
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
		
		gridData=reqMasterService.getREQDetails(filterCriteria, materialId, purchaseId);
		
		count = gridData.getCount();
		jsonData = new JQGridJSON();
		jsonData.setPage(filterCriteria.getCurrentPage());//pageCount
		jsonData.setRecords(count);
		jsonData.setTotal(""+gridData.getTotalPages());
		List<JQGridRow> rows = new ArrayList<JQGridRow>();
		List<REQDTO> rangeGridData = new ArrayList<REQDTO>();
		rangeGridData = (List<REQDTO>) gridData.getListData();
		for(REQDTO objReq:rangeGridData)
		{
			JQGridRow row = new JQGridRow(); 
			List<String> cells = new ArrayList<String>();
			cells.add("false");
			cells.add(objReq.getPreqNPO());
			cells.add(objReq.getPreqItem());
			cells.add(objReq.getPurGroup());
			cells.add(objReq.getMaterial());
			cells.add(objReq.getPlant());
			cells.add(objReq.getMaterialGroup());
			
			cells.add(objReq.getQuantity()+"");
			cells.add(objReq.getDelivDate()+"");
			cells.add(objReq.getId()+"");
			row.setId(""+objReq.getId());
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
	
	public String save()
	{
		String ids=request.getParameter("ids");
		String quantity=request.getParameter("quan");
		
		String vStart=request.getParameter("startPeriod");
		String vend=request.getParameter("endPeriod");
		String purGroup=request.getParameter("purchaseGrp");
	    String compCode=request.getParameter("compCode");
				
		
		String idArr[]=ids.split(",");
		String idQuant[]=quantity.split(",");
		int i=0;
		
		RFQHeaderDTO rfqHeaderDTO=new RFQHeaderDTO();
		rfqHeaderDTO.setRfqVersion(1l);
		rfqHeaderDTO.setPurGroup(purGroup);
		rfqHeaderDTO.setVperEnd(new Date(vend));
		rfqHeaderDTO.setVperStart(new Date(vStart));
		rfqHeaderDTO.setCompCode(compCode);
		
		reqMasterService.saveRFQHeader(rfqHeaderDTO);
		
		List<RFQ_ITEMDTO> rfq_ITEMDTOs=new ArrayList<RFQ_ITEMDTO>();
		List<RFQ_ITEM_REQ_DTO> rfq_ITEM_REQ_DTOs = new ArrayList<RFQ_ITEM_REQ_DTO>();
		
		RFQ_ITEMDTO rfq_ITEMDTO=null;
		
		RFQ_ITEM_REQ_DTO rfqItemReqDto = null;
		
		Long j=10l;
		for(i=0;i<idArr.length;i++)
		{
			rfq_ITEMDTO=new RFQ_ITEMDTO();
			REQDTO reqdto=reqMasterService.getREQDetailsById(Long.parseLong(idArr[i]));
			rfq_ITEMDTO.setMaterial(reqdto.getMaterial());
			rfq_ITEMDTO.setMaterialGroup(reqdto.getMaterialGroup());
			rfq_ITEMDTO.setQuantity(Double.parseDouble(idQuant[i]));
			rfq_ITEMDTO.setRfqItem(j);
			rfq_ITEMDTO.setRfqVersion(1l);
			rfq_ITEMDTOs.add(rfq_ITEMDTO);
			
			//----------rfqItemReq------------
			
			rfqItemReqDto = new RFQ_ITEM_REQ_DTO();
			
			rfqItemReqDto.setRfqVersion(1l);
			rfqItemReqDto.setRfqItem(j);
			rfqItemReqDto.setRfqReqItem(j);
			rfqItemReqDto.setPreqNo(reqdto.getPreqNPO());
			rfqItemReqDto.setPreqItem(Double.parseDouble(reqdto.getPreqItem()));
			rfqItemReqDto.setMaterial(reqdto.getMaterial());
			rfqItemReqDto.setPlant(reqdto.getPlant());
			rfqItemReqDto.setMaterialGroup(reqdto.getMaterialGroup());
			rfqItemReqDto.setQuantity(Double.parseDouble(reqdto.getQuantity()));
			
			rfq_ITEM_REQ_DTOs.add(rfqItemReqDto);
		}
		
		reqMasterService.saveRFQItems(rfq_ITEMDTOs);
		
		
		reqMasterService.saveRFQItemReq(rfq_ITEM_REQ_DTOs);
		
		
		return Action.SUCCESS;
	}

		
}
