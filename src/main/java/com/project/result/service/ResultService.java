package com.project.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.result.dao.ResultDao;
import com.project.result.model.Student;

@Component
public class ResultService {

	@Autowired
	private ResultDao resultDao;
	
	
	public List<Student> getAllStudents(String studID) {
		return resultDao.getAllStudents(studID);
	}

}
