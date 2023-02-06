package com.spring.studentmarks.dto;

public class SubjectwiseDTO {
	private String subjectName;
	
	private Integer noOfStudentAttempted;
	
	private Integer noOfPass;
	
	private Integer noOfFail;
	
	private Double passPercentage;
	
	private Double failPercentage;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getNoOfStudentAttempted() {
		return noOfStudentAttempted;
	}

	public void setNoOfStudentAttempted(Integer noOfStudentAttempted) {
		this.noOfStudentAttempted = noOfStudentAttempted;
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
}
