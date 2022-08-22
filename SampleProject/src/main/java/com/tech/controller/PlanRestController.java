package com.tech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Plan;
import com.tech.entity.PlanCategory;
import com.tech.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans()
	{
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories()
	{
		Map<Integer, String> planCategory = planService.getPlanCategory();
		return new ResponseEntity<>(planCategory, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan)
	{
		String msg = "";
		boolean upsertPlan = planService.addNewPlan(plan);
		
		if(upsertPlan)
			msg = "Plan Saved";
		else
			msg = "Plan Not Saved";
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<Boolean> updatePlan(@RequestBody Plan plan)
	{
		boolean upsertPlan = planService.addNewPlan(plan);
		return new ResponseEntity<Boolean>(upsertPlan, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@RequestParam int planId)
	{
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(planById, HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<Boolean> deletePlan(@RequestParam("planId") int planId) {
		return new ResponseEntity<Boolean>(planService.deletePlanById(planId), HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@RequestParam int planId, @RequestParam String status)
	{
		String msg = "";
		
		Plan planById = planService.getPlanById(planId);
		
		if(planById == null) {
			msg = "No record found";
			return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		}
		
		if(planById.getClass() != null) {
			msg = "status changed";
			planById.setActiveSw(status);
			planService.addNewPlan(planById);
		}
		else
			msg = "status not changed";
			
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
