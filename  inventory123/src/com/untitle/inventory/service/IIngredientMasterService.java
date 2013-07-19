package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.IngredientMasterDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.MenuMasterDTO;

public interface IIngredientMasterService {
	GridData getIngredientDetails(FilterCriteria filterCriteria);
	//List<RangeMasterDTO> getRangeDetails();
	//RangeMasterDTO getRangeDetailsById(String rangeCode);
	void save(IngredientMasterDTO ingredientMasterDTO);
	//void delete(String rangeCode);
}
