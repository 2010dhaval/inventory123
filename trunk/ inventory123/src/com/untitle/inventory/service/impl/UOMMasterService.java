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
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.model.RangeMaster;
import com.untitle.inventory.model.UOMMaster;
import com.untitle.inventory.service.IUOMMasterService;
@Service("IUOMMasterService")
@Transactional
public class UOMMasterService implements IUOMMasterService{

	@Autowired
	ICommonDAO<UOMMaster> commonDAO;
	
	public ICommonDAO<UOMMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<UOMMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	
	@Override
	public GridData getUOMDetails(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		List<UOMMasterDTO> uomMasterDTOList = new ArrayList<UOMMasterDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(UOMMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<UOMMaster> uomMasterList = commonDAO.getAll(start,Integer.parseInt( filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),UOMMaster.class);
		if (uomMasterList.size() > 0) {
		for (UOMMaster uomMaster: uomMasterList)
		{
			UOMMasterDTO uomMasterDTO = new UOMMasterDTO();
			uomMasterDTO.setId(uomMaster.getId());
			uomMasterDTO.setUomName(uomMaster.getUomName());
			uomMasterDTOList.add(uomMasterDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(uomMasterDTOList);
		return gridData;
	}

	@Override
	public UOMMasterDTO getUOMDetailsById(String uomId) {
		
		// TODO Auto-generated method stub
		UOMMaster uomMaster=(UOMMaster) commonDAO.getById(UOMMaster.class,Long.parseLong(uomId));
		UOMMasterDTO uomMasterDTO=getDTOFromMaster(uomMaster);
		return uomMasterDTO;
	}

	@Override
	public void save(UOMMasterDTO uomMasterDTO) {
		// TODO Auto-generated method stub
		UOMMaster uomMaster=new UOMMaster();
		uomMaster.setUomName(uomMasterDTO.getUomName());
		uomMaster.setId(uomMasterDTO.getId());
		uomMaster.setIsDeleted(0);
		commonDAO.saveOrUpdate(uomMaster);
	}
	
	public static UOMMasterDTO getDTOFromMaster(UOMMaster uomMaster)
	{
		UOMMasterDTO uomMasterDTO=null;
		if(uomMaster!=null)
		{
			uomMasterDTO=new UOMMasterDTO();
			uomMasterDTO.setId(uomMaster.getId());
			uomMasterDTO.setUomName(uomMaster.getUomName());
		}
		return uomMasterDTO;
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		UOMMaster uomMaster=commonDAO.getById(UOMMaster.class,id);		
		uomMaster.setIsDeleted(1);
		commonDAO.saveOrUpdate(uomMaster);
	}

	@Override
	public List<UOMMasterDTO> getUOMDetails() {
		// TODO Auto-generated method stub
		
		List<UOMMasterDTO> uomMasterDTOs=new ArrayList<UOMMasterDTO>();
		List<UOMMaster> uomMasterList = commonDAO.getAll(UOMMaster.class);
		if (uomMasterList.size() > 0) {
		for (UOMMaster uomMaster: uomMasterList)
		{
			uomMasterDTOs.add(getDTOFromMaster(uomMaster));
		}
		}
		return uomMasterDTOs;
	}

	/*@Override
	public List<CourseMasterDTO> getCoursesByQual(String qual) {
		// TODO Auto-generated method stub
		
		List<CourseMaster> courseMasters=courseMasterDAO.getCoursesByQual(qual);
		List<CourseMasterDTO> courseMasterDTOs=new ArrayList<CourseMasterDTO>();
		
		for(CourseMaster courseMaster:courseMasters)
		{
			courseMasterDTOs.add(getDTOFromMaster(courseMaster));
		}
		
		return courseMasterDTOs;
	}*/
}
