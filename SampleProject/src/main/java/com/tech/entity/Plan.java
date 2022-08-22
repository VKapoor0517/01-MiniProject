package com.tech.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "plan")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int planId;
	private String name;
	@Column(updatable = false)
	@CreatedDate
	private Date planStartDate;
	private Date planEndDate;
	private int planCategoryId;
	private String activeSw;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	public Date getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	public int getPlanCategoryId() {
		return planCategoryId;
	}
	public void setPlanCategoryId(int planCategoryId) {
		this.planCategoryId = planCategoryId;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public Plan() {
		// TODO Auto-generated constructor stub
	}
	public Plan(int planId, String name, Date planStartDate, Date planEndDate, int planCategoryId, String activeSw,
			LocalDate createDate, LocalDate updateDate, String createdBy, String updatedBy) {
		super();
		this.planId = planId;
		this.name = name;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.planCategoryId = planCategoryId;
		this.activeSw = activeSw;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
}
