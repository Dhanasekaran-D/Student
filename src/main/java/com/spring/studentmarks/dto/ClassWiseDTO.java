package com.spring.studentmarks.dto;

import java.util.List;

public class ClassWiseDTO {
	private String className;
	
	private Integer noOfStudents;
	
	private Integer noOfPass;
	
	private Integer noOfFail;
	
	private Double passPercentage;
	
	private Double failPercentage;
	private List<SubjectwiseDTO> subjectWiseRecords;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(Integer noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public Integer getNoOfPass() {
		return noOfPass;
	}
	public void setNoOfPass(Integer noOfPass) {
		this.noOfPass = noOfPass;
	}
	public Integer getNoOfFail() {
		return noOfFail;
	}
	public void setNoOfFail(Integer noOfFail) {
		this.noOfFail = noOfFail;
	}
	public Double getPassPercentage() {
		return passPercentage;
	}
	public void setPassPercentage(Double passPercentage) {
		this.passPercentage = passPercentage;
	}
	public Double getFailPercentage() {
		return failPercentage;
	}
	public void setFailPercentage(Double failPercentage) {
		this.failPercentage = failPercentage;
	}
	public List<SubjectwiseDTO> getSubjectWiseRecords() {
		return subjectWiseRecords;
	}
	public void setSubjectWiseRecords(List<SubjectwiseDTO> subjectWiseRecords) {
		this.subjectWiseRecords = subjectWiseRecords;
	}

}
