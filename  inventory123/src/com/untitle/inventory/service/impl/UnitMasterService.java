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
import com.untitle.inventory.dto.UnitMasterDTO;
import com.untitle.inventory.model.UnitMaster;
import com.untitle.inventory.service.IUnitMasterService;
@Service("IUnitMasterService")
@Transactional
public class UnitMasterService implements IUnitMasterService{

	@Autowired
	ICommonDAO<UnitMaster> commonDAO;
	
		
	
	public ICommonDAO<UnitMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<UnitMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Override
	public GridData getUnitDetails(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		List<UnitMasterDTO> unitMasterDTOList = new ArrayList<UnitMasterDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(UnitMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<UnitMaster> unitMasterList = commonDAO.getAll(start,Integer.parseInt( filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),UnitMaster.class);
		if (unitMasterList.size() > 0) {
		for (UnitMaster unitMaster: unitMasterList)
		{
			UnitMasterDTO unitMasterDTO = new UnitMasterDTO();
			unitMasterDTO.setUnitCode(unitMaster.getUnitCode());
			unitMasterDTO.setUnitName(unitMaster.getUnitName());
			unitMasterDTO.setUnitAddress(unitMaster.getUnitAddress());
			unitMasterDTO.setResPerName(unitMaster.getResPerName());
			unitMasterDTO.setResPerContactNo(unitMaster.getResPerContactNo());
			unitMasterDTOList.add(unitMasterDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(unitMasterDTOList);
		return gridData;
	}

	@Override
	public UnitMasterDTO getUnitDetailsById(Long unitCode) {
		
		// TODO Auto-generated method stub
		UnitMaster unitMaster=(UnitMaster) commonDAO.getById(UnitMaster.class,unitCode);
		UnitMasterDTO unitMasterDTO=getDTOFromMaster(unitMaster);
		return unitMasterDTO;
	}

	@Override
	public void save(UnitMasterDTO unitMasterDTO) {
		// TODO Auto-generated method stub
		UnitMaster unitMaster=new UnitMaster();
		unitMaster.setUnitCode(unitMasterDTO.getUnitCode());
		unitMaster.setUnitName(unitMasterDTO.getUnitName());
		unitMaster.setUnitAddress(unitMasterDTO.getUnitAddress());
		unitMaster.setResPerName(unitMasterDTO.getResPerName());
		unitMaster.setResPerContactNo(unitMasterDTO.getResPerContactNo());
		unitMaster.setIsDeleted(0);
		commonDAO.saveOrUpdate(unitMaster);
	}
	
	public static UnitMasterDTO getDTOFromMaster(UnitMaster unitMaster)
	{
		UnitMasterDTO unitMasterDTO=null;
		if(unitMaster!=null)
		{
			unitMasterDTO=new UnitMasterDTO();
			unitMasterDTO.setUnitCode(unitMaster.getUnitCode());
			unitMasterDTO.setUnitName(unitMaster.getUnitName());
			unitMasterDTO.setUnitAddress(unitMaster.getUnitAddress());
			unitMasterDTO.setResPerName(unitMaster.getResPerName());
			unitMasterDTO.setResPerContactNo(unitMaster.getResPerContactNo());
		}
		return unitMasterDTO;
		
	}

	@Override
	public void delete(Long unitCode) {
		// TODO Auto-generated method stub
		UnitMaster unitMaster=commonDAO.getById(UnitMaster.class,unitCode);		
		unitMaster.setIsDeleted(1);
		commonDAO.saveOrUpdate(unitMaster);
	}

	}
