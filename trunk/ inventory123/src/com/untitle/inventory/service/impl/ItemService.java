package com.untitle.inventory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.untitle.inventory.constants.*;
import com.untitle.inventory.dao.ICommonDAO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.model.ItemHeader;
import com.untitle.inventory.model.MenuMaster;
import com.untitle.inventory.service.IItemService;
import com.untitle.inventory.service.IMenuService;

@Service("IItemService")
@Transactional
public class ItemService implements IItemService {

	@Autowired
	ICommonDAO<ItemHeader> commonDAO;
	
	public ICommonDAO<ItemHeader> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<ItemHeader> commonDAO) {
		this.commonDAO = commonDAO;
	}

	
}
