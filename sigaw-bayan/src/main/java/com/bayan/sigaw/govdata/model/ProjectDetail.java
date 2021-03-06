package com.bayan.sigaw.govdata.model;

public class ProjectDetail extends ProjectOverview{
	private String purpose;
	private String program_description;
	private String issueDate;
	private String agency_code;
	private String operating_unit;
	private String object_description;
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getProgram_description() {
		return program_description;
	}
	public void setProgram_description(String program_description) {
		this.program_description = program_description;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getAgency_code() {
		return agency_code;
	}
	public void setAgency_code(String agency_code) {
		this.agency_code = agency_code;
	}
	public String getOperating_unit() {
		return operating_unit;
	}
	public void setOperating_unit(String operating_unit) {
		this.operating_unit = operating_unit;
	}
	public String getObject_description() {
		return object_description;
	}
	public void setObject_description(String object_description) {
		this.object_description = object_description;
	}
	
	public ProjectOverview extractProjectOverview() {
		ProjectOverview overview = new ProjectOverview();		
		overview.setAmount(this.getAmount());
		overview.setDescription(this.getDescription());
		overview.setDepartment_code(this.getDepartment_code());
		overview.setId(this.getId());
		overview.setRegion(this.getRegion());
		overview.setSaro_no(this.getSaro_no());
		return overview;
	}
}
