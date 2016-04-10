package com.babolforfun.models;

public class SocialProfile {

	private String type;
	private String typeId;
	private String typeName;
	private String url;
	private String username;
	private String bio;
	private String id;
	private String followers;
	private String following;
	
	public SocialProfile() {
		super();
	}

	
	public SocialProfile(String type, String typeId, String typeName, String url, String username, String bio,
			String id, String followers, String following) {
		super();
		this.type = type;
		this.typeId = typeId;
		this.typeName = typeName;
		this.url = url;
		this.username = username;
		this.bio = bio;
		this.id = id;
		this.followers = followers;
		this.following = following;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFollowers() {
		return followers;
	}


	public void setFollowers(String followers) {
		this.followers = followers;
	}


	public String getFollowing() {
		return following;
	}


	public void setFollowing(String following) {
		this.following = following;
	}
	
	
	
}
