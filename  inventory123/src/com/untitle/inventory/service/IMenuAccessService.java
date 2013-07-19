package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.dto.MenuAccessDTO;

public interface IMenuAccessService {
	List<MenuAccessDTO> getMenuId(Long userTypeId);
	void modifyAccessDetails (Long userTypeId, List accessIds);
}
