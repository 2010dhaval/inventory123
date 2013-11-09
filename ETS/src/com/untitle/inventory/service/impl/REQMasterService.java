package com.untitle.inventory.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridActionHelper;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dao.ICommonDAO;
import com.untitle.inventory.dto.MaterialGroupMasterDTO;
import com.untitle.inventory.dto.PurchaseGroupMasterDTO;
import com.untitle.inventory.dto.REQDTO;
import com.untitle.inventory.dto.RFQHeaderDTO;
import com.untitle.inventory.dto.RFQ_ITEMDTO;
import com.untitle.inventory.dto.RFQ_ITEM_REQ_DTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.model.MaterialGroupMaster;
import com.untitle.inventory.model.PurchaseGroupMaster;
import com.untitle.inventory.model.REQMaster;
import com.untitle.inventory.model.RFQHeader;
import com.untitle.inventory.model.RFQ_ITEM;
import com.untitle.inventory.model.RFQ_ITEM_REQ;
import com.untitle.inventory.model.RangeMaster;
import com.untitle.inventory.model.UOMMaster;
import com.untitle.inventory.service.IREQMasterService;
import com.untitle.inventory.service.IRangeMasterService;
@Service("IREQMasterService")
@Transactional
public class REQMasterService implements IREQMasterService{

	@Autowired
	ICommonDAO<REQMaster> commonDAO;
	
	@Autowired
	ICommonDAO<MaterialGroupMaster> commonDAO1;
	
	@Autowired
	ICommonDAO<RFQHeader> commonDAO3;
	
	@Autowired
	ICommonDAO<RFQ_ITEM> commonDAO4;
	
	@Autowired
	ICommonDAO<RFQ_ITEM_REQ> commonDAO5;
	
	public ICommonDAO<MaterialGroupMaster> getCommonDAO1() {
		return commonDAO1;
	}

	public void setCommonDAO1(ICommonDAO<MaterialGroupMaster> commonDAO1) {
		this.commonDAO1 = commonDAO1;
	}

	public ICommonDAO<PurchaseGroupMaster> getCommonDAO2() {
		return commonDAO2;
	}

	public void setCommonDAO2(ICommonDAO<PurchaseGroupMaster> commonDAO2) {
		this.commonDAO2 = commonDAO2;
	}

	@Autowired
	ICommonDAO<PurchaseGroupMaster> commonDAO2;
	
	
	public ICommonDAO<REQMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<REQMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	public ICommonDAO<RFQ_ITEM> getCommonDAO4() {
		return commonDAO4;
	}

	public void setCommonDAO4(ICommonDAO<RFQ_ITEM> commonDAO4) {
		this.commonDAO4 = commonDAO4;
	}

	
	
	

	@Override
	public GridData getREQDetails(FilterCriteria filterCriteria, String materialId, String purchaseId) {
		// TODO Auto-generated method stub
		List<REQDTO> rangeMasterDTOList = new ArrayList<REQDTO>();
		
		Map<String, String> param = new HashMap<String, String>();
		
		param.put("materialId", materialId);
		param.put("purchaseId", purchaseId);
		
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(REQMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<REQMaster> rangeMasterList = commonDAO.getAll(start,Integer.parseInt(filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), 
				filterCriteria.getSearchCriteria(),REQMaster.class, param);
		if (rangeMasterList.size() > 0) {
		for (REQMaster rangeMaster: rangeMasterList)
		{
			REQDTO rangeMasterDTO = new REQDTO();
			rangeMasterDTO.setId(rangeMaster.getId());
			rangeMasterDTO.setPreqNPO(rangeMaster.getPreqNO());
			rangeMasterDTO.setPreqItem(rangeMaster.getPreqItem());
			rangeMasterDTO.setPurGroup(rangeMaster.getPurGroup());
			rangeMasterDTO.setMaterial(rangeMaster.getMaterial());
			rangeMasterDTO.setPlant(rangeMaster.getPlant());
			rangeMasterDTO.setMaterialGroup(rangeMaster.getMaterialGroup());
			
			rangeMasterDTO.setQuantity(rangeMaster.getQuantity());
			rangeMasterDTO.setDelivDate(rangeMaster.getDelivDate());
			
			rangeMasterDTOList.add(rangeMasterDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(rangeMasterDTOList);
		return gridData;
	}

	
	public static REQDTO getDTOFromMaster(REQMaster rangeMaster)
	{
		REQDTO rangeMasterDTO=null;
		if(rangeMaster!=null)
		{
			rangeMasterDTO=new REQDTO();
			rangeMasterDTO.setPreqNPO(rangeMaster.getPreqNO());
			rangeMasterDTO.setPreqItem(rangeMaster.getPreqItem());
			rangeMasterDTO.setPurGroup(rangeMaster.getPurGroup());
			rangeMasterDTO.setMaterial(rangeMaster.getMaterial());
			rangeMasterDTO.setPlant(rangeMaster.getPlant());
			rangeMasterDTO.setMaterialGroup(rangeMaster.getMaterialGroup());
			
			rangeMasterDTO.setQuantity(rangeMaster.getQuantity());
			rangeMasterDTO.setDelivDate(rangeMaster.getDelivDate());
			
		}
		return rangeMasterDTO;
		
	}

	
	@Override
	public List<REQDTO> getREQDetails() {
		// TODO Auto-generated method stub
		
		List<REQDTO> rangeMasterDTOs=new ArrayList<REQDTO>();
		List<REQMaster> rangeMasterList = commonDAO.getAll(REQMaster.class);
		if (rangeMasterList.size() > 0) {
		for (REQMaster rangeMaster: rangeMasterList)
		{
			rangeMasterDTOs.add(getDTOFromMaster(rangeMaster));
		}
		}
		return rangeMasterDTOs;
	}

	@Override
	public List<MaterialGroupMasterDTO> getMaterialGroupMasterDetails() {
		// TODO Auto-generated method stub
		
		List<MaterialGroupMasterDTO> materialGroupMasterDTOs=new ArrayList<MaterialGroupMasterDTO>();
		List<MaterialGroupMaster> materialGroupMasters = commonDAO1.getAll(MaterialGroupMaster.class);
		MaterialGroupMasterDTO materialGroupMasterDTO=null;
		if (materialGroupMasters.size() > 0) {
		for (MaterialGroupMaster materialGroupMaster: materialGroupMasters)
		{
			materialGroupMasterDTO=new MaterialGroupMasterDTO();
			materialGroupMasterDTO.setMaterialGroupCode(materialGroupMaster.getMaterialGroupCode());
			materialGroupMasterDTO.setMaterialGroupDesc(materialGroupMaster.getMaterialGroupDesc());
			materialGroupMasterDTO.setClient(materialGroupMaster.getClient());
			materialGroupMasterDTOs.add(materialGroupMasterDTO);
		}
		}
		return materialGroupMasterDTOs;
		
	}

	@Override
	public List<PurchaseGroupMasterDTO> getPurchaseGroupMasterDetails() {
		// TODO Auto-generated method stub
		List<PurchaseGroupMasterDTO> purchaseGroupMasterDTOs=new ArrayList<PurchaseGroupMasterDTO>();
		List<PurchaseGroupMaster> purchaseGroupMasters = commonDAO2.getAll(PurchaseGroupMaster.class);
		PurchaseGroupMasterDTO purchaseGroupMasterDTO=null;
		if (purchaseGroupMasters.size() > 0) {
		for (PurchaseGroupMaster purchaseGroupMaster: purchaseGroupMasters)
		{
			purchaseGroupMasterDTO=new PurchaseGroupMasterDTO();
			purchaseGroupMasterDTO.setPurchaseGroupCode(purchaseGroupMaster.getPurchaseGroupCode());
			purchaseGroupMasterDTO.setPurchaseGroupDesc(purchaseGroupMaster.getPurchaseGroupDesc());
			purchaseGroupMasterDTO.setClient(purchaseGroupMaster.getClient());
			purchaseGroupMasterDTOs.add(purchaseGroupMasterDTO);
		}
		}
		return purchaseGroupMasterDTOs;
		
	}

	@Override
	public REQDTO getREQDetailsById(Long id) {
		// TODO Auto-generated method stub
		
		REQMaster reqMaster=commonDAO.getById(REQMaster.class, id);
		return getDTOFromMaster(reqMaster);
	}

	@Override
	public void saveRFQHeader(RFQHeaderDTO rfqHeaderDTO) {
		// TODO Auto-generated method stub
		
		RFQHeader rfqHeader=new RFQHeader();
		rfqHeader.setCompCode(rfqHeaderDTO.getCompCode());
		rfqHeader.setPurGroup(rfqHeaderDTO.getPurGroup());
		rfqHeader.setRfqVersion(rfqHeaderDTO.getRfqVersion());
		rfqHeader.setVperStart(rfqHeaderDTO.getVperStart());
		rfqHeader.setVperEnd(rfqHeaderDTO.getVperEnd());
		
		commonDAO3.saveOrUpdate(rfqHeader);
	}

	public ICommonDAO<RFQHeader> getCommonDAO3() {
		return commonDAO3;
	}

	public void setCommonDAO3(ICommonDAO<RFQHeader> commonDAO3) {
		this.commonDAO3 = commonDAO3;
	}

	@Override
	public void saveRFQItems(List<RFQ_ITEMDTO> rfq_ITEMDTOs) {
		// TODO Auto-generated method stub
		
		List<RFQ_ITEM> rfq_ITEMs=new ArrayList<RFQ_ITEM>();
		RFQ_ITEM rfq_ITEM=null;
		
		for(RFQ_ITEMDTO rfq_ITEMDTO:rfq_ITEMDTOs)
		{
			rfq_ITEM=new RFQ_ITEM();
			rfq_ITEM.setMaterial(rfq_ITEMDTO.getMaterial());
			rfq_ITEM.setMaterialGroup(rfq_ITEMDTO.getMaterialGroup());
			rfq_ITEM.setQuantity(rfq_ITEMDTO.getQuantity());
			rfq_ITEM.setRfqItem(rfq_ITEMDTO.getRfqItem());
			rfq_ITEM.setRfqVersion(rfq_ITEMDTO.getRfqVersion());
			
			rfq_ITEMs.add(rfq_ITEM);
		}
		
		commonDAO4.saveOrUpdateAll(rfq_ITEMs);
		
	}
	
	@Override
	public void saveRFQItemReq(List<RFQ_ITEM_REQ_DTO> rfq_ITEM_REQ_DTOs) {
		
		
		List<RFQ_ITEM_REQ> rfq_ITEM_reqs=new ArrayList<RFQ_ITEM_REQ>();
		
		RFQ_ITEM_REQ rfq_ITEM_req=null;
		
		for(RFQ_ITEM_REQ_DTO rfq_ITEM_REQ_DTO : rfq_ITEM_REQ_DTOs)
		{
			rfq_ITEM_req=new RFQ_ITEM_REQ();			
						
			rfq_ITEM_req.setRfqVersion(rfq_ITEM_REQ_DTO.getRfqVersion());
			rfq_ITEM_req.setRfqItem(rfq_ITEM_REQ_DTO.getRfqItem());
			rfq_ITEM_req.setRfqReqItem(rfq_ITEM_REQ_DTO.getRfqReqItem());
			rfq_ITEM_req.setPreqNo(rfq_ITEM_REQ_DTO.getPreqNo());
			rfq_ITEM_req.setPreqItem(rfq_ITEM_REQ_DTO.getPreqItem());
			rfq_ITEM_req.setMaterial(rfq_ITEM_REQ_DTO.getMaterial());
			rfq_ITEM_req.setPlant(rfq_ITEM_REQ_DTO.getPlant());
			rfq_ITEM_req.setMaterialGroup(rfq_ITEM_REQ_DTO.getMaterialGroup());
			rfq_ITEM_req.setQuantity(rfq_ITEM_REQ_DTO.getQuantity());
			
			rfq_ITEM_reqs.add(rfq_ITEM_req);
		}
		
		commonDAO5.saveOrUpdateAll(rfq_ITEM_reqs);
		
	}

	public ICommonDAO<RFQ_ITEM_REQ> getCommonDAO5() {
		return commonDAO5;
	}

	public void setCommonDAO5(ICommonDAO<RFQ_ITEM_REQ> commonDAO5) {
		this.commonDAO5 = commonDAO5;
	}
	
}