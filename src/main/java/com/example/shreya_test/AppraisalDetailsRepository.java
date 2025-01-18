package com.example.shreya_test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppraisalDetailsRepository extends JpaRepository <AppraisalDetails, Integer> {

	 List<AppraisalDetails> findByEmployeeId(Integer employeeId);
}