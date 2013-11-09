package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.MenuMasterDTO;

public interface IUOMMasterService {
	GridData getUOMDetails(FilterCriteria filterCriteria);
	UOMMasterDTO getUOMDetailsById(String courseId);
	void save(UOMMasterDTO uomMasterDTO);
	void delete(String id);
	List<UOMMasterDTO> getUOMDetails();
}
