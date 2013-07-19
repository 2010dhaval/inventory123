package com.untitle.inventory.dao;

import java.util.List;

import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.model.UOMMaster;

public interface ICourseMasterDAO {
	List<UOMMaster> getCourseDetails();
	UOMMaster getCourseDetailsById(String courseId);
	void save(UOMMaster courseMaster);
	List<UOMMaster> getCoursesByQual(String qual);
}

