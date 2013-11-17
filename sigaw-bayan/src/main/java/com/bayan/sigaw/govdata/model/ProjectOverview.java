package com.bayan.sigaw.govdata.model;

public class ProjectOverview {
		
	protected String description;
	protected String department_code;
	protected long amount;
	protected String saro_no;
	protected String region;
	protected String id;
	
	public String getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getSaro_no() {
		return saro_no;
	}
	public void setSaro_no(String saro_no) {
		this.saro_no = saro_no;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	

}
