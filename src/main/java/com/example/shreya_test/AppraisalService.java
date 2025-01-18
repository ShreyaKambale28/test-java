package com.example.shreya_test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalService {

	@Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
	
	 
	public EmployeeDetails saveUser(EmployeeDetails employee) {
        return  employeeDetailsRepository.save(employee);
    }

    public List<EmployeeDetails> getAllEmployeeDetails() {
        return employeeDetailsRepository.findAll();
    }

    @Autowired
    private RatingDetailsRepository ratingDetailsRepository;
    public RatingDetails saveUser(RatingDetails rating) {
        return  ratingDetailsRepository.save(rating);
    }

    public List<RatingDetails> getAllRatingDetails() {
        return ratingDetailsRepository.findAll();
    }
    
    @Autowired
    private AppraisalDetailsRepository appraisalDetailsRepository;

    public AppraisalDetails saveUser(AppraisalDetails apprasial) {
        return  appraisalDetailsRepository.save(apprasial);
    }

    public List<AppraisalDetails> getAllApDetails() {
        return appraisalDetailsRepository.findAll();
    }
    public void calculateAppraisals() {
        List<EmployeeDetails> employees = employeeDetailsRepository.findAll();
        long totalEmployees = employees.size();
        
        // Group employees by category
        Map<Character, Long> categoryCounts = employees.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getRating, Collectors.counting()));

        for (Map.Entry<Character, Long> entry : categoryCounts.entrySet()) {
            char category = entry.getKey();
            long count = entry.getValue();

            RatingDetails rating = ratingDetailsRepository.findById(category).orElse(null);
            if (rating != null) {
                double actualPercentage = (count * 100.0) / totalEmployees;
                double deviation = actualPercentage - rating.getStandardPercentage();

                employees.stream()
                        .filter(emp -> emp.getRating() == category)
                        .forEach(emp -> saveAppraisalDetails(emp, rating, actualPercentage, deviation));
            }
        }
    }

    private void saveAppraisalDetails(EmployeeDetails employee, RatingDetails rating, double actualPercentage, double deviation) {
        AppraisalDetails appraisal = new AppraisalDetails();
        appraisal.setEmployeeId(employee.getEmployeeId());
        appraisal.setCategory(rating.getCategory());
        appraisal.setActualPercentage(actualPercentage);
        appraisal.setDeviation(deviation);
        appraisalDetailsRepository.save(appraisal);
    }

    public List<AppraisalDetails> getAppraisalDetails() {
        return appraisalDetailsRepository.findAll();
    }
}


