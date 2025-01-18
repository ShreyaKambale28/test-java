package com.example.shreya_test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails {

	@Id
	 @Column(name = "employee_id")
   private int employeeId;
	 @Column(name = "employee_name")
   private String employeeName;
	 @Column(name = "rating")
   private char rating;
   // Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public char getRating() {
		return rating;
	}
	public void setRating(char rating) {
		this.rating = rating;
	}
}
