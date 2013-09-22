package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.MaterialGroupMasterDTO;
import com.untitle.inventory.dto.PurchaseGroupMasterDTO;
import com.untitle.inventory.dto.REQDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.model.REQMaster;

public interface IREQMasterService {
	GridData getREQDetails(FilterCriteria filterCriteria);
	List<REQDTO> getREQDetails();
	
	List<MaterialGroupMasterDTO> getMaterialGroupMasterDetails();
	List<PurchaseGroupMasterDTO> getPurchaseGroupMasterDetails();
}
