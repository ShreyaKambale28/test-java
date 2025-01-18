package com.example.shreya_test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AppraisalDetails")
public class AppraisalDetails {

	@Id
	@Column(name = "employee_id")
    private int employeeId;
	@Column(name = "category")
    private char category;
	@Column(name = "actual_percentage")
    private double actualPercentage;
	@Column(name = "deviation")
    private double deviation;
    private String employeeName; 
    // Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public double getActualPercentage() {
		return actualPercentage;
	}
	public void setActualPercentage(double actualPercentage) {
		this.actualPercentage = actualPercentage;
	}
	public double getDeviation() {
		return deviation;
	}
	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
