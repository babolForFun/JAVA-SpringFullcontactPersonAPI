package com.babolforfun.models;



public class Photo {

	private String type;
	private String typeId;
	private String typeName;
	private String url;
	private String isPrimary;
	
	
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Photo(String type, String typeId, String typeName, String url, String isPrimary) {
		super();
		this.type = type;
		this.typeId = typeId;
		this.typeName = typeName;
		this.url = url;
		this.isPrimary = isPrimary;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsPrimary() {
		return isPrimary;
	}
	
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	
}
