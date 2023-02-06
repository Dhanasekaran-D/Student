package com.spring.studentmarks.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.studentmarks.dto.SchoolDTO;
import com.spring.studentmarks.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, UUID> {

	List<StudentEntity> findAllBycreatedBy(String createdBy);

	//List<SchoolDTO> findAll(List<SchoolDTO> schoolList);

	// List<StudentEntity> findAll(List<SchoolDTO> schoolList);

}
