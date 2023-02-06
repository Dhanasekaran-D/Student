package com.spring.studentmarks.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentmarks.dao.SchoolDAO;
import com.spring.studentmarks.dto.ClassWiseDTO;
import com.spring.studentmarks.dto.SchoolDTO;
import com.spring.studentmarks.dto.StudentMarkDTO;
import com.spring.studentmarks.dto.SubjectwiseDTO;
import com.spring.studentmarks.entity.StudentEntity;
import com.spring.studentmarks.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository userRepository;
	@Autowired
	private SchoolDAO schoolDAO;

	public void savestudent(StudentEntity student) {

		student.getTotalMarks();
		student.getPercentage();
		student.setCreatedBy("Dhanasekaran");

		userRepository.save(student);
	}

	private static final Integer PASS_MARK = 35;

	public List<SchoolDTO> schoolperformance(List<StudentEntity> subjectWiseRecords) {
	
		//Iterable<StudentEntity> find = userRepository.findAll();
		List<SchoolDTO> schoolList = new ArrayList<SchoolDTO>();
		
		List<StudentEntity> studentMarkList =new ArrayList<StudentEntity>(subjectWiseRecords);
		
		Map<String, Map<String, List<StudentEntity>>> schoolWiseClassWiseDataMap = new HashMap<String, Map<String,List<StudentEntity>>>();
		
		for (StudentEntity Mark : studentMarkList) {
			
			
			Map<String, List<StudentEntity>> classWiseDataMap = schoolWiseClassWiseDataMap.get(Mark.getCreatedBy());
			
			
			if(null == classWiseDataMap) {
				
				classWiseDataMap = new HashMap<String, List<StudentEntity>>();
				
				List<StudentEntity> studetMarkList = new ArrayList<StudentEntity>();
				
				studetMarkList.add(Mark);
				
				classWiseDataMap.put(Mark.getStuClass(), studentMarkList);
				
			}else {
				
				List<StudentEntity> studentMarkListTemp = classWiseDataMap.get(Mark.getStuClass());
				
				if(null == studentMarkListTemp || studentMarkListTemp.isEmpty()) {
					studentMarkListTemp =new ArrayList<StudentEntity>();
				}
				studentMarkListTemp.add(Mark);
				classWiseDataMap.put(Mark.getStuClass(), studentMarkList);
			}
			schoolWiseClassWiseDataMap.put(Mark.getCreatedBy(), classWiseDataMap);
		}

		Set<String> schoolNameList = schoolWiseClassWiseDataMap.keySet();
		
		
		for(String schoolName : schoolNameList) {
			
			Map<String, List<StudentEntity>> classWiseDataMap = schoolWiseClassWiseDataMap.get(schoolName);
			
			Integer schoolnoOfStudents = 0, schoolnoOfPass= 0, schoolnoOfFail = 0;
			List<ClassWiseDTO> classList = new ArrayList<ClassWiseDTO>();
			
			for (String className : classWiseDataMap.keySet()) {
				
				List<StudentEntity> studentMarksList =	classWiseDataMap.get(className);
				
				Map<String, List<StudentMarkDTO>> subjectWiseMarkMap = new HashMap<>();
				
				Integer classnoOfStudents = studentMarksList.size(), classnoOfPass= 0, classnoOfFail = 0;
				
				for (StudentEntity studentMarkObj : studentMarksList) {
					
					Boolean isCurrentStudentOverallPass = true;
					
					
					List<StudentMarkDTO> tamilMarkList = subjectWiseMarkMap.get("TAMIL");
					if(null == tamilMarkList)
						tamilMarkList = new ArrayList<StudentMarkDTO>();
					
					StudentMarkDTO subjectMarkDTO = new StudentMarkDTO();
					subjectMarkDTO.setIsPass(studentMarkObj.getTamil() >= PASS_MARK?true:false);
					subjectMarkDTO.setOptainedMark(studentMarkObj.getTamil());
					tamilMarkList.add(subjectMarkDTO);
					subjectWiseMarkMap.put("TAMIL", tamilMarkList);
					if(!subjectMarkDTO.getIsPass()) {
						isCurrentStudentOverallPass = false;
					}
					
					
					List<StudentMarkDTO> englishMarkList = subjectWiseMarkMap.get("ENGLISH");
					if(null == englishMarkList)
						englishMarkList = new ArrayList<StudentMarkDTO>();
					
					StudentMarkDTO englishSubjectDTO = new StudentMarkDTO();
					englishSubjectDTO.setIsPass(studentMarkObj.getEnglish() >= PASS_MARK?true:false);
					englishSubjectDTO.setOptainedMark(studentMarkObj.getEnglish());
					englishMarkList.add(englishSubjectDTO);
					subjectWiseMarkMap.put("ENGLISH", englishMarkList);
					if(!englishSubjectDTO.getIsPass()) {
						isCurrentStudentOverallPass = false;
					}
					
					
					List<StudentMarkDTO> mathsMarkList = subjectWiseMarkMap.get("MATHS");
					if(null == mathsMarkList)
						mathsMarkList = new ArrayList<StudentMarkDTO>();
					
					StudentMarkDTO mathsSubjectDTO = new StudentMarkDTO();
					mathsSubjectDTO.setIsPass(studentMarkObj.getMaths() >= PASS_MARK?true:false);
					mathsSubjectDTO.setOptainedMark(studentMarkObj.getMaths());
					mathsMarkList.add(mathsSubjectDTO);
					subjectWiseMarkMap.put("MATHS", mathsMarkList);
					if(!mathsSubjectDTO.getIsPass()) {
						isCurrentStudentOverallPass = false;
					}
					
					List<StudentMarkDTO> scienceMarkList = subjectWiseMarkMap.get("SCIENCE");
					if(null == scienceMarkList)
						scienceMarkList = new ArrayList<StudentMarkDTO>();
					
					StudentMarkDTO scienceSubjectDTO = new StudentMarkDTO();
					scienceSubjectDTO.setIsPass(studentMarkObj.getScience() >= PASS_MARK?true:false);
					scienceSubjectDTO.setOptainedMark(studentMarkObj.getScience());
					scienceMarkList.add(scienceSubjectDTO);
					subjectWiseMarkMap.put("SCIENCE", scienceMarkList);
					if(!scienceSubjectDTO.getIsPass()) {
						isCurrentStudentOverallPass = false;
					}
					
					List<StudentMarkDTO> socialMarkList = subjectWiseMarkMap.get("SOCIAL SCIENCE");
					if(null != socialMarkList)
						scienceMarkList = new ArrayList<StudentMarkDTO>();
					
					StudentMarkDTO socialSubjectDTO = new StudentMarkDTO();
					socialSubjectDTO.setIsPass(studentMarkObj.getSocialScience() >= PASS_MARK?true:false);
					socialSubjectDTO.setOptainedMark(studentMarkObj.getSocialScience());
					socialMarkList.add(socialSubjectDTO);
					subjectWiseMarkMap.put("SOCIAL SCIENCE", socialMarkList);
					if(!socialSubjectDTO.getIsPass()) {
						isCurrentStudentOverallPass = false;
					}
					
					
					if(isCurrentStudentOverallPass) {
						classnoOfPass++;
					}else {
						classnoOfFail++;
					}
				}
				 
				Double classpassPercentage = (double) ((classnoOfPass * 100 ) / classnoOfStudents);
				Double classfailPercentage = 100.00 - classpassPercentage;
				
				List<SubjectwiseDTO> studentsubjectWiseRecords = new ArrayList<SubjectwiseDTO>();
				
				for(String subjectName : subjectWiseMarkMap.keySet()) {
					
					List<StudentMarkDTO> subjectWiseMarkList = subjectWiseMarkMap.get(subjectName);
					
					Long totalNoOfPassStudents = subjectWiseMarkList.stream().filter(obj -> obj.getIsPass()).collect(Collectors.counting());
					SubjectwiseDTO subjectWisePerformanceDTO = new SubjectwiseDTO();
					subjectWisePerformanceDTO.setSubjectName(subjectName);
					subjectWisePerformanceDTO.setNoOfStudentAttempted(subjectWiseMarkList.size());
					subjectWisePerformanceDTO.setNoOfPass(totalNoOfPassStudents.intValue());
					subjectWisePerformanceDTO.setNoOfFail(subjectWiseMarkList.size() - totalNoOfPassStudents.intValue() );
					Double passPercentage = (double) ((subjectWisePerformanceDTO.getNoOfPass() * 100 ) / subjectWisePerformanceDTO.getNoOfStudentAttempted());
					subjectWisePerformanceDTO.setPassPercentage(passPercentage);
					subjectWisePerformanceDTO.setFailPercentage(100.00 - passPercentage);
					studentsubjectWiseRecords.add(subjectWisePerformanceDTO);
				}
				 
				ClassWiseDTO classWisePerformanceDTO = new ClassWiseDTO();
				classWisePerformanceDTO.setClassName(className);
				classWisePerformanceDTO.setNoOfStudents(classnoOfStudents);
				classWisePerformanceDTO.setNoOfPass(classnoOfPass);
				classWisePerformanceDTO.setNoOfFail(classnoOfFail);
				classWisePerformanceDTO.setPassPercentage(classpassPercentage);
				classWisePerformanceDTO.setFailPercentage(classfailPercentage);
				classWisePerformanceDTO.setSubjectWiseRecords(studentsubjectWiseRecords);
				classList.add(classWisePerformanceDTO);
				 
				schoolnoOfStudents = schoolnoOfStudents + classnoOfStudents;
				
				schoolnoOfPass = schoolnoOfPass + classnoOfPass;
				
				schoolnoOfFail = schoolnoOfFail + classnoOfFail;
			}
			
			
			Double schoolpassPercentage = (double) ((schoolnoOfPass * 100 ) / schoolnoOfStudents);
			Double schoolfailPercentage = 100.00 - schoolpassPercentage;
			
			 
			SchoolDTO schoolObj = new SchoolDTO();
			schoolObj.setSchool(schoolName);;
			schoolObj.setNoOfStudents(schoolnoOfStudents);
			schoolObj.setNoOfPass(schoolnoOfPass);
			schoolObj.setNoOfFail(schoolnoOfFail);
			schoolObj.setPassPercentage(schoolfailPercentage);
			schoolObj.setFailPercentage(schoolfailPercentage);
			schoolObj.setClasswiseList(classList);
			schoolList.add(schoolObj);
		}
		return schoolList ;
	}

	public Iterable<StudentEntity> getAll(StudentEntity student) {
		
		
		return userRepository.findAll();
	}

}
