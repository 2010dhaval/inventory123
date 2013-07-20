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
import com.untitle.inventory.dto.IngredientMasterDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.model.IngredientMaster;
import com.untitle.inventory.model.RangeMaster;
import com.untitle.inventory.model.UOMMaster;
import com.untitle.inventory.service.IIngredientMasterService;
import com.untitle.inventory.service.IRangeMasterService;
@Service("IIngredientMasterService")
@Transactional
public class IngredientMasterService implements IIngredientMasterService{

	@Autowired
	ICommonDAO<IngredientMaster> commonDAO;
	
		
	
	public ICommonDAO<IngredientMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<IngredientMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}

	
	@Override
	public void save(IngredientMasterDTO ingredientMasterDTO) {
		// TODO Auto-generated method stub
		IngredientMaster ingredientMaster=new IngredientMaster();
		ingredientMaster.setIngCode(ingredientMasterDTO.getIngCode());
		ingredientMaster.setIngDesc(ingredientMasterDTO.getIngDesc());
		ingredientMaster.setIngRange(ingredientMasterDTO.getIngRange());
		ingredientMaster.setPurPrice(ingredientMasterDTO.getPurPrice());
		ingredientMaster.setWarQry(ingredientMasterDTO.getWarQry());
		
		UOMMaster uomMaster=new UOMMaster();
		uomMaster.setId(ingredientMasterDTO.getUomMasterDTO().getId());
		ingredientMaster.setUomMaster(uomMaster);
		
		ingredientMaster.setIsDeleted(0);
		commonDAO.saveOrUpdate(ingredientMaster);
	}
	
	public static IngredientMasterDTO getDTOFromMaster(IngredientMaster ingredientMaster)
	{
		IngredientMasterDTO ingredientMasterDTO=null;
		if(ingredientMaster!=null)
		{
			ingredientMasterDTO=new IngredientMasterDTO();
			ingredientMasterDTO.setIngCode(ingredientMaster.getIngCode());
			ingredientMasterDTO.setIngDesc(ingredientMaster.getIngDesc());
			ingredientMasterDTO.setIngRange(ingredientMaster.getIngRange());
			ingredientMasterDTO.setPurPrice(ingredientMaster.getPurPrice());
			ingredientMasterDTO.setWarQry(ingredientMaster.getWarQry());
			
			ingredientMasterDTO.setUomMasterDTO(UOMMasterService.getDTOFromMaster(ingredientMaster.getUomMaster()));
			
			
		}
		return ingredientMasterDTO;
		
	}

	@Override
	public GridData getIngredientDetails(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<IngredientMasterDTO> ingredientMasterDTOs = new ArrayList<IngredientMasterDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(IngredientMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<IngredientMaster> ingredientMasters = commonDAO.getAll(start,Integer.parseInt( filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),IngredientMaster.class);
		if (ingredientMasters.size() > 0) {
		for (IngredientMaster ingredientMaster: ingredientMasters)
		{
			IngredientMasterDTO ingredientMasterDTO = new IngredientMasterDTO();
			ingredientMasterDTO.setIngCode(ingredientMaster.getIngCode());
			ingredientMasterDTO.setIngDesc(ingredientMaster.getIngDesc());
			ingredientMasterDTO.setIngRange(ingredientMaster.getIngRange());
			ingredientMasterDTO.setUomMasterDTO(UOMMasterService.getDTOFromMaster(ingredientMaster.getUomMaster()));
			ingredientMasterDTO.setPurPrice(ingredientMaster.getPurPrice());
			ingredientMasterDTO.setWarQry(ingredientMaster.getWarQry());			
			
			ingredientMasterDTOs.add(ingredientMasterDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(ingredientMasterDTOs);
		return gridData;

	}

	@Override
	public IngredientMasterDTO getIngredientDetailsById(Long ingCode) {
		// TODO Auto-generated method stub
		
		IngredientMaster ingredientMaster=commonDAO.getById(IngredientMaster.class, ingCode);
		return getDTOFromMaster(ingredientMaster);
	}

	@Override
	public void delete(Long ingCode) {
		// TODO Auto-generated method stub
		IngredientMaster ingredientMaster=commonDAO.getById(IngredientMaster.class, ingCode);
		ingredientMaster.setIsDeleted(1);
		commonDAO.saveOrUpdate(ingredientMaster);
	}

	}