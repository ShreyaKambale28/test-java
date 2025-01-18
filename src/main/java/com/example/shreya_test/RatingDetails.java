package com.example.shreya_test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "RatingDetails")
public class RatingDetails {

	@Id
	 @Column(name = "category")
   private char category;
	@Column(name = "standard_percentage")
   private double standardPercentage;
   // Getters and Setters
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public double getStandardPercentage() {
		return standardPercentage;
	}
	public void setStandardPercentage(double standardPercentage) {
		this.standardPercentage = standardPercentage;
	}
}
