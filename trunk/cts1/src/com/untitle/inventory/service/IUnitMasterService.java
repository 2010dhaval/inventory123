package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.dto.UnitMasterDTO;

public interface IUnitMasterService {
	GridData getUnitDetails(FilterCriteria filterCriteria);
	UnitMasterDTO getUnitDetailsById(Long unitCode);
	void save(UnitMasterDTO unitMasterDTO);
	void delete(Long unitCode);
	List<UnitMasterDTO> getUnitDetails();
}
