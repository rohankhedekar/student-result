package com.project.result.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.result.model.Marks;
import com.project.result.model.Student;
import com.project.result.service.ResultService;

@RestController
@RequestMapping("/students")
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@RequestMapping(value="/{studID}",method=RequestMethod.GET)
	public List<Student> getAllStudents(@PathVariable String studID){
		return resultService.getAllStudents(studID);
	}
}
