package com.untitle.inventory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.untitle.inventory.commons.FilterCriteria;
import com.untitle.inventory.commons.GridActionHelper;
import com.untitle.inventory.commons.GridData;
import com.untitle.inventory.constants.*;
import com.untitle.inventory.dao.ICommonDAO;
import com.untitle.inventory.dto.ItemHeaderDTO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.dto.OpeningStockDTO;
import com.untitle.inventory.dto.RangeMasterDTO;
import com.untitle.inventory.model.ItemHeader;
import com.untitle.inventory.model.MenuMaster;
import com.untitle.inventory.model.OpeningStock;
import com.untitle.inventory.model.RangeMaster;
import com.untitle.inventory.service.IItemService;
import com.untitle.inventory.service.IMenuService;
import com.untitle.inventory.service.IOpeningStockService;

@Service("IOpeningStockService")
@Transactional
public class OpeningStockService implements IOpeningStockService {

	@Autowired
	ICommonDAO<OpeningStock> commonDAO;
	
	public ICommonDAO<OpeningStock> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<OpeningStock> commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Override
	public void save(OpeningStockDTO openingStockDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String voucherCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GridData getData(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		List<OpeningStockDTO> openingStockDTOs = new ArrayList<OpeningStockDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(OpeningStock.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<OpeningStock> openingStocks = commonDAO.getAll(start,Integer.parseInt( filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),OpeningStock.class);
		if (openingStocks.size() > 0) {
		for (OpeningStock openingStock: openingStocks)
		{
			OpeningStockDTO openingStockDTO = new OpeningStockDTO();
			openingStockDTO.setVoucherCode(openingStock.getVoucherCode());
			openingStockDTO.setType(openingStock.getType());
			if(openingStock.getType()==1)
				openingStockDTO.setIngredientMasterDTO(IngredientMasterService.getDTOFromMaster(openingStock.getIngredientMaster()));
			else
				openingStockDTO.setItemHeaderDTO(new ItemHeaderDTO());
			
			openingStockDTOs.add(openingStockDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(openingStockDTOs);
		return gridData;

	}

	
}
