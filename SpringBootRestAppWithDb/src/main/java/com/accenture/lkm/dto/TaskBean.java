package com.accenture.lkm.dto;

public class TaskBean {

	private Integer id;
	private String description;
	private String status;
	
	public TaskBean() {
		// TODO Auto-generated constructor stub
	}
	
	public TaskBean(Integer id, String description, String status) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
