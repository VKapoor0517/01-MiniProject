package com.tech.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypeCategoryTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Plan;
import com.tech.entity.PlanCategory;
import com.tech.repository.PlanCategoryRepository;
import com.tech.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService{


	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private PlanCategoryRepository planCategoryRepository;

	@Override
	public Map<Integer, String> getPlanCategory() {
		// TODO Auto-generated method stub
		List<PlanCategory> categories = planCategoryRepository.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		
		for (PlanCategory planCategory : categories) {
			categoryMap.put(planCategory.getCategoryId(), planCategory.getCategoryName());
		}
		
//		categories.forEach(category -> {
//			categoryMap.put(category.getCategoryId(), category.getCategoryName())});
		
		return categoryMap;
	}

	@Override
	public boolean addNewPlan(Plan plan) {
		// TODO Auto-generated method stub
		
		Plan save = planRepository.save(plan);

		return (plan.getName() != null) ? true : false;
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		return planRepository.findAll();
	}

	@Override
	public Plan getPlanById(int planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepository.findById(planId);
		
		if(findById.isPresent())
		{
			return findById.get();
		}
		
		return null;
	}

	@Override
	public boolean deletePlanById(int planId) {
		// TODO Auto-generated method stub
		boolean status = false;
		Optional<Plan> findById = planRepository.findById(planId);
		if(findById.isPresent())
		{
			planRepository.deleteById(planId);
			status = true;
		}
		
		return status;
	}

	@Override
	public boolean softDelete(int planId, String activeSw) {
		// TODO Auto-generated method stub
		boolean status = false;
		Optional<Plan> findById = planRepository.findById(planId);
		if(findById.isPresent())
		{
			Plan plan = findById.get();
			plan.setActiveSw(activeSw);
			planRepository.save(plan);
			status = true;
		}

		return status;
	}
}
