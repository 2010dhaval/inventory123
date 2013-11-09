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
import com.untitle.inventory.dto.TaxMasterDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.model.TaxMaster;
import com.untitle.inventory.model.UOMMaster;
import com.untitle.inventory.service.ITaxMasterService;
import com.untitle.inventory.service.IUOMMasterService;
@Service("ITaxMasterService")
@Transactional
public class TaxMasterService implements ITaxMasterService{

	@Autowired
	ICommonDAO<TaxMaster> commonDAO;
	
		
	
	public ICommonDAO<TaxMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<TaxMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Override
	public GridData getTaxDetails(FilterCriteria filterCriteria) {
		// TODO Auto-generated method stub
		List<TaxMasterDTO> taxMasterDTOList = new ArrayList<TaxMasterDTO>();
		GridData gridData = new GridData();
		int count = commonDAO.getGridCount(TaxMaster.class);
		Map<String,Integer> values = GridActionHelper.calculate(count, filterCriteria.getCurrentPage(), filterCriteria.getLimit());
		int start = values.get("start");
		int totalPages = values.get("totalPages");
		List<TaxMaster> taxMasterList = commonDAO.getAll(start,Integer.parseInt( filterCriteria.getLimit()), filterCriteria.getSidx(), filterCriteria.getSord(), filterCriteria.getSearchCriteria(),TaxMaster.class);
		if (taxMasterList.size() > 0) {
		for (TaxMaster taxMaster: taxMasterList)
		{
			TaxMasterDTO taxMasterDTO = new TaxMasterDTO();
			taxMasterDTO.setTaxCode(taxMaster.getTaxCode());
			taxMasterDTO.setTaxDesc(taxMaster.getTaxDesc());
			taxMasterDTO.setTaxPercentage(taxMaster.getTaxPercentage());
			taxMasterDTOList.add(taxMasterDTO);
		}
		}
		gridData.setCount(count);
		gridData.setTotalPages(totalPages);
		gridData.setListData(taxMasterDTOList);
		return gridData;
	}

	@Override
	public TaxMasterDTO getTaxDetailsById(String taxCode) {
		
		// TODO Auto-generated method stub
		TaxMaster taxMaster=(TaxMaster) commonDAO.getById(TaxMaster.class,taxCode);
		TaxMasterDTO taxMasterDTO=getDTOFromMaster(taxMaster);
		return taxMasterDTO;
	}

	@Override
	public void save(TaxMasterDTO taxMasterDTO) {
		// TODO Auto-generated method stub
		TaxMaster taxMaster=new TaxMaster();
		taxMaster.setTaxCode(taxMasterDTO.getTaxCode());
		taxMaster.setTaxDesc(taxMasterDTO.getTaxDesc());
		taxMaster.setTaxPercentage(taxMasterDTO.getTaxPercentage());
		taxMaster.setIsDeleted(0);
		commonDAO.saveOrUpdate(taxMaster);
	}
	
	public static TaxMasterDTO getDTOFromMaster(TaxMaster taxMaster)
	{
		TaxMasterDTO taxMasterDTO=null;
		if(taxMaster!=null)
		{
			taxMasterDTO=new TaxMasterDTO();
			taxMasterDTO.setTaxCode(taxMaster.getTaxCode());
			taxMasterDTO.setTaxDesc(taxMaster.getTaxDesc());
			taxMasterDTO.setTaxPercentage(taxMaster.getTaxPercentage());
		}
		return taxMasterDTO;
		
	}

	@Override
	public void delete(String taxCode) {
		// TODO Auto-generated method stub
		TaxMaster taxMaster=commonDAO.getById(TaxMaster.class,taxCode);		
		taxMaster.setIsDeleted(1);
		commonDAO.saveOrUpdate(taxMaster);
	}

	}
