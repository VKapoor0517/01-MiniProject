package com.tech.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tech.entity.Plan;
import com.tech.entity.PlanCategory;

public interface PlanService {
	
	public Map<Integer, String> getPlanCategory();
	
	public boolean addNewPlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(int planId);
	
	public boolean deletePlanById(int planId);
	
	public boolean softDelete(int planId, String activeSw);

}
