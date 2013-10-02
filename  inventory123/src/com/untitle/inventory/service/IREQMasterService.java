package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.MaterialGroupMasterDTO;
import com.untitle.inventory.dto.PurchaseGroupMasterDTO;
import com.untitle.inventory.dto.REQDTO;
import com.untitle.inventory.dto.RFQHeaderDTO;
import com.untitle.inventory.dto.RFQ_ITEMDTO;
import com.untitle.inventory.dto.RFQ_ITEM_REQ_DTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.model.REQMaster;
import com.untitle.inventory.model.RFQ_ITEM;

public interface IREQMasterService {
	GridData getREQDetails(FilterCriteria filterCriteria, String materialId, String purchaseId);
	List<REQDTO> getREQDetails();
	REQDTO getREQDetailsById(Long id);
	
	void saveRFQHeader(RFQHeaderDTO rfqHeaderDTO);
	void saveRFQItems(List<RFQ_ITEMDTO> rfq_ITEMDTOs);
	List<MaterialGroupMasterDTO> getMaterialGroupMasterDetails();
	List<PurchaseGroupMasterDTO> getPurchaseGroupMasterDetails();
	void saveRFQItemReq(List<RFQ_ITEM_REQ_DTO> rfq_ITEM_REQ_DTOs);
}
