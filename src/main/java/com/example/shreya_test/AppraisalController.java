package com.example.shreya_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppraisalController {

	 @Autowired
	    private AppraisalService appraisalService;

	    @GetMapping("/calculateAppraisals")
	    public String calculateAppraisals(Model model) {
	        appraisalService.calculateAppraisals();
	        model.addAttribute("appraisals", appraisalService.getAppraisalDetails());
	        return "appraisal-view";
	    }
}
