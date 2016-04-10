package com.babolforfun.models;

public class Organization {

	private String isPrimary;
	private String name;
	private String startDate;
	private String title;
	private String current;
	
	
	public Organization() {
		super();
	}
	
	public Organization(String isPrimary, String name, String startDate, String title, String current) {
		super();
		this.isPrimary = isPrimary;
		this.name = name;
		this.startDate = startDate;
		this.title = title;
		this.current = current;
	}
	
	public String getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	
	
	
	
}
