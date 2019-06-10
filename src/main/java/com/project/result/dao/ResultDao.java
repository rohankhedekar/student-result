package com.project.result.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.result.model.Marks;
import com.project.result.model.Student;

@Component
public class ResultDao {

	RestTemplate restTemplate = new RestTemplate();
	
	public List<Student> getAllStudents(String studID) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<List<Student>> studentResponse = restTemplate.exchange("http://localhost:8083/students/"+studID, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Student>>() {});
		List<Student> studentList = studentResponse.getBody();
		ResponseEntity<List<Marks>> marksResponse = restTemplate.exchange("http://localhost:8082/students/"+studID+"/marks", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Marks>>() {});
		List<Marks> marksList = marksResponse.getBody();
		
		studentList.get(0).setMarks(marksList);
		return studentList;
	}

	
	
}
