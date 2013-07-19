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
import com.untitle.inventory.model.RangeMaster;
import com.untitle.inventory.service.IRangeMasterService;
@Service("IRangeMasterService")
@Transactional
public class RangeMasterService implements IRangeMasterService{

	@Autowired
	ICommonDAO<RangeMaster> commonDAO;
	
		
	
	public ICommonDAO<RangeMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<RangeMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Override
	public GridData getRangeDetails(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		List<RangeMasterDTO> rangeMasterDTOList = new ArrayList<RangeMasterDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(RangeMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<RangeMaster> rangeMasterList = commonDAO.getAll(start,Integer.parseInt( filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),RangeMaster.class);
		if (rangeMasterList.size() > 0) {
		for (RangeMaster rangeMaster: rangeMasterList)
		{
			RangeMasterDTO rangeMasterDTO = new RangeMasterDTO();
			rangeMasterDTO.setRangeCode(rangeMaster.getRangeCode());
			rangeMasterDTO.setRangeDesc(rangeMaster.getRangeDesc());
			rangeMasterDTOList.add(rangeMasterDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(rangeMasterDTOList);
		return gridData;
	}

	@Override
	public RangeMasterDTO getRangeDetailsById(String rangeCode) {
		
		// TODO Auto-generated method stub
		RangeMaster rangeMaster=(RangeMaster) commonDAO.getById(RangeMaster.class,rangeCode);
		RangeMasterDTO rangeMasterDTO=getDTOFromMaster(rangeMaster);
		return rangeMasterDTO;
	}

	@Override
	public void save(RangeMasterDTO rangeMasterDTO) {
		// TODO Auto-generated method stub
		RangeMaster rangeMaster=new RangeMaster();
		rangeMaster.setRangeCode(rangeMasterDTO.getRangeCode());
		rangeMaster.setRangeDesc(rangeMasterDTO.getRangeDesc());
		rangeMaster.setIsDeleted(0);
		commonDAO.saveOrUpdate(rangeMaster);
	}
	
	public static RangeMasterDTO getDTOFromMaster(RangeMaster rangeMaster)
	{
		RangeMasterDTO rangeMasterDTO=null;
		if(rangeMaster!=null)
		{
			rangeMasterDTO=new RangeMasterDTO();
			rangeMasterDTO.setRangeCode(rangeMaster.getRangeCode());
			rangeMasterDTO.setRangeDesc(rangeMaster.getRangeDesc());
		}
		return rangeMasterDTO;
		
	}

	@Override
	public void delete(String rangeCode) {
		// TODO Auto-generated method stub
		RangeMaster rangeMaster=commonDAO.getById(RangeMaster.class,rangeCode);		
		rangeMaster.setIsDeleted(1);
		commonDAO.saveOrUpdate(rangeMaster);
	}

	@Override
	public List<RangeMasterDTO> getRangeDetails() {
		// TODO Auto-generated method stub
		
		List<RangeMasterDTO> rangeMasterDTOs=new ArrayList<RangeMasterDTO>();
		List<RangeMaster> rangeMasterList = commonDAO.getAll(RangeMaster.class);
		if (rangeMasterList.size() > 0) {
		for (RangeMaster rangeMaster: rangeMasterList)
		{
			rangeMasterDTOs.add(getDTOFromMaster(rangeMaster));
		}
		}
		return rangeMasterDTOs;
	}
}