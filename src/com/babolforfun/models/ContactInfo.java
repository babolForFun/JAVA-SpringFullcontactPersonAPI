package com.babolforfun.models;

public class ContactInfo {

	private String client;
	private String handle;
	
	
	public ContactInfo() {
		super();
	}
	
	public ContactInfo(String client, String handle) {
		super();
		this.client = client;
		this.handle = handle;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
	
}
