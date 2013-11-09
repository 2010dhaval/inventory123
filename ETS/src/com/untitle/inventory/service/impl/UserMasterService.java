package com.untitle.inventory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.untitle.inventory.constants.Constants;
import com.untitle.inventory.dao.ICommonDAO;
import com.untitle.inventory.dao.IUserMasterDAO;
import com.untitle.inventory.dto.AbstractBaseEntity;
import com.untitle.inventory.dto.UserMasterDTO;
import com.untitle.inventory.dto.UserTypeMasterDTO;
import com.untitle.inventory.model.UserMaster;
import com.untitle.inventory.model.UserTypeMaster;
import com.untitle.inventory.service.IUserMasterService;
@Service("IUserMasterService")
@Transactional
public class UserMasterService implements IUserMasterService {

	@Autowired
	ICommonDAO<UserMaster> commonDAO;
	
	public ICommonDAO<UserMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<UserMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Override
	public UserMasterDTO authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		System.out.println("In UserMaster Service");
		UserMasterDTO userMasterDTO=null;
		
		Map<String,Object> properyMap=new HashMap<String,Object>();
		properyMap.put("username", userName);
		properyMap.put("password", password);
		List<UserMaster> userMasters=commonDAO.findByNamedQuery("getUserDetails", properyMap);
		System.out.println("1");
		if(userMasters!=null)
			userMasterDTO=getDTOFromMaster(userMasters.get(0));
		return userMasterDTO;
	}
	
	public static UserMasterDTO getDTOFromMaster(UserMaster userMaster)
	{
		UserMasterDTO userMasterDTO=new UserMasterDTO();
		userMasterDTO.setId(userMaster.getId());
		userMasterDTO.setFirstName(userMaster.getFirstName());
		userMasterDTO.setLastName(userMaster.getLastName());
		userMasterDTO.setEmailID(userMaster.getEmailID());
		userMasterDTO.setUserName(userMaster.getUserName());
		userMasterDTO.setPassword(userMaster.getPassword());
		UserTypeMasterDTO userTypeMasterDTO=null;
		if(userMaster.getUserTypeMaster()!=null)
		{
			userTypeMasterDTO=new UserTypeMasterDTO();
			userTypeMasterDTO.setId(userMaster.getUserTypeMaster().getId());
			userTypeMasterDTO.setUserType(userMaster.getUserTypeMaster().getUserType());
			userMasterDTO.setUserTypeMasterDTO(userTypeMasterDTO);
		}
		return userMasterDTO;
		
	}
	
	@Override
	public void changePassword(UserMasterDTO userMasterDTO) {
		// TODO Auto-generated method stub
		UserMaster userData = new UserMaster();
		
		UserTypeMaster userTypeMaster = new UserTypeMaster();
		userData.setUserName(userMasterDTO.getUserName());
		userData.setPassword(userMasterDTO.getPassword());
		userData.setFirstName(userMasterDTO.getFirstName());
		userData.setLastName(userMasterDTO.getLastName());
		userData.setDisable(0);
		
		userTypeMaster.setId(userMasterDTO.getUserTypeMasterDTO().getId());
		userTypeMaster.setUserType(userMasterDTO.getUserTypeMasterDTO().getUserType());
		//designationData = designationMasterDAO.getDesignationById(userMasterDTO.getDesignation().getId());
		userData.setUserTypeMaster(userTypeMaster);
		userData.setId(userMasterDTO.getId());
		userData.setUserName(userMasterDTO.getUserName());
		userData.setPassword(userMasterDTO.getPassword());
		commonDAO.saveOrUpdate(userData);
	}
	

}
