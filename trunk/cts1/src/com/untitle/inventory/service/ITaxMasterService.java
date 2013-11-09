package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.MenuMasterDTO;

public interface ITaxMasterService {
	GridData getTaxDetails(FilterCriteria filterCriteria);
	TaxMasterDTO getTaxDetailsById(String taxCode);
	void save(TaxMasterDTO taxMasterDTO);
	void delete(String taxCode);
}
