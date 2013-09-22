package com.untitle.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.model.MaterialGroupMaster;
import com.untitle.inventory.model.PurchaseGroupMaster;
import com.untitle.inventory.model.REQMaster;
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

	@Override
	public GridData getREQDetails(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		List<REQDTO> rangeMasterDTOList = new ArrayList<REQDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(REQMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<REQMaster> rangeMasterList = commonDAO.getAll(start,Integer.parseInt(filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),REQMaster.class);
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
}