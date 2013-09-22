package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.dto.OpeningStockDTO;


public interface IOpeningStockService {
	void save(OpeningStockDTO openingStockDTO);
	void delete(String voucherCode);
	GridData getData(FilterCriteria filterCriteria);
}
