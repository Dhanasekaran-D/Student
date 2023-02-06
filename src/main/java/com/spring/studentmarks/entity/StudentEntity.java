package com.spring.studentmarks.entity;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "student")
//@JsonFilter("Details")
public class StudentEntity {

	@Id

	@GeneratedValue(generator = "UUID")

	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

	@Type(type = "uuid-char")

	@Column(name = "id", updatable = false, nullable = false)

	private UUID id;

	@Column(name = "stud_name")
     private String name;

	@Column(name = "stud_roll_num")
     private int rollNo;

	@Column(name = "stud_class")
     private String stuClass;

	@Column(name = "sub_tamil_mark")
    private int tamil;

	@Column(name = "sub_eng_mark")
    private int english;

	@Column(name = "sub_math_mark")
     private int maths;

	@Column(name = "sub_science_mark")
     private int science;

	@Column(name = "sub_social_mark")
     private int socialScience;

	@Column(name = "stud_total_mark")
      private double totalMarks;

	@Column(name = "percentage")
    private double percentage;
	
	@Column(name = "created_by")

	private String createdBy;
////	private List<SchoolDTO> schoolDTO;
////	public List<SchoolDTO> getSchoolDTO() {
////		return schoolDTO;
////	}
////
////	public void setSchoolDTO(List<SchoolDTO> schoolDTO) {
////		this.schoolDTO = schoolDTO;
////	}
//
//	public void setTotalMarks(double totalMarks) {
//		this.totalMarks = totalMarks;
//	}
//
//	public void setPercentage(double percentage) {
//		this.percentage = percentage;
//	}
//	
//	public String getCreatedBy() {
//
//		return createdBy;
//
//	}
//
//	public void setCreatedBy(String createdBy) {
//
//		this.createdBy = createdBy;
//
//	}
//
//	public UUID getId() {
//
//		return id;
//
//	}
//
//	public void setId(UUID id) {
//
//		this.id = id;
//
//	}
//
//	public String getName() {
//
//		return name;
//
//	}
//
//	public void setName(String name) {
//
//		this.name = name;
//
//	}
//
//	public int getRollNo() {
//
//		return rollNo;
//
//	}
//
//	public void setRollNo(int rollNo) {
//
//		this.rollNo = rollNo;
//
//	}
//
//	public String getStuClass() {
//
//		return stuClass;
//
//	}
//
//	public void setStuClass(String stuClass) {
//
//		this.stuClass = stuClass;
//
//	}
//
//	public int getTamil() {
//
//		return tamil;
//
//	}
//
//	public void setTamil(int tamil) {
//
//		this.tamil = tamil;
//
//	}
//
//	public int getEnglish() {
//
//		return english;
//
//	}
//
//	public void setEnglish(int english) {
//
//		this.english = english;
//
//	}
//
//	public int getMaths() {
//
//		return maths;
//
//	}
//
//	public void setMaths(int maths) {
//
//		this.maths = maths;
//
//	}
//
//	public int getScience() {
//
//		return science;
//
//	}
//
//	public void setScience(int science) {
//
//		this.science = science;
//
//	}
//
//	public int getSocialScience() {
//
//		return socialScience;
//
//	}
//
//	public void setSocialScience(int socialScience) {
//
//		this.socialScience = socialScience;
//
//	}
//
//	public Double getTotalMarks() {
//
//		return totalMarks =  tamil + english + maths + science + socialScience;
//
//	}
//
//	public void setTotalMarks(int totalMarks) {
//
//		this.totalMarks = totalMarks;
//
//	}
//
//	public Double getPercentage() {
//
//		return percentage = totalMarks / 500 * 100;
//
//	}
//
//	public void setPercentage(Double percentage) {
//
//		this.percentage = percentage;
//
//	}
// public double getAvg() {
// return totalMarks/5;
//}
// public String getGrade() {
//	 String grade;
//	 double avg=totalMarks/5;
//	 if(avg>50)
//	 {
//	grade="Pass";
//	 }
//	 else {
//		 grade="fail";
//	 }
//return grade;
//
// }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocialScience() {
		return socialScience;
	}

	public void setSocialScience(int socialScience) {
		this.socialScience = socialScience;
	}

	public double getTotalMarks() {
		return totalMarks= tamil + english + maths + science + socialScience;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getPercentage() {
		return percentage=totalMarks / 500 * 100;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
 
