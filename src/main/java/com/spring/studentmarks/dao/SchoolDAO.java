package com.spring.studentmarks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.studentmarks.dto.SchoolDTO;
import com.spring.studentmarks.entity.StudentEntity;

@Repository
public class SchoolDAO extends StudentEntity{
//Connection con = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj",
//	"mysql_demo_tnj", "Ebrain@20");
//return con;
	//public List<SchoolDTO> findAll(List<SchoolDTO> schoolList) {
		@Query("select * from student")public List<StudentEntity> findAll() {
		return  findAll();
	}
	//	return schoolList;
	}
	
	

//}
