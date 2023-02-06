package com.spring.studentmarks.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.studentmarks.dto.SchoolDTO;
import com.spring.studentmarks.dto.SubjectwiseDTO;
import com.spring.studentmarks.entity.StudentEntity;
import com.spring.studentmarks.repository.StudentRepository;
import com.spring.studentmarks.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService userService;
	@Autowired
	private StudentRepository userRepository;
	@PostMapping(value = "/create")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {

		userService.savestudent(student);
		return ResponseEntity.ok(student);
	}

	@GetMapping(value = "/getperformance")
	private List<SchoolDTO> getSampleResponseFormat() {
		List<StudentEntity> subjectWiseRecords = new ArrayList<StudentEntity>();
		StudentEntity subjectWisePerformanceDTO = new StudentEntity();
		subjectWisePerformanceDTO.getCreatedBy();
		subjectWisePerformanceDTO.getStuClass();
		subjectWisePerformanceDTO.getTamil();
		subjectWisePerformanceDTO.getEnglish();
		subjectWisePerformanceDTO.getMaths();
		subjectWisePerformanceDTO.getScience();
		subjectWisePerformanceDTO.getSocialScience();
		//subjectWisePerformanceDTO.getFailPercentage();
		//subjectWiseRecords.addAll((Collection<? extends StudentEntity>) userRepository.findAll());
		subjectWiseRecords.add(subjectWisePerformanceDTO);
		return userService.schoolperformance(subjectWiseRecords);
		
	}
@GetMapping(value = "/get")
	private Iterable<StudentEntity> getAll(StudentEntity student){
		return userService.getAll(student);
		
	}
}
