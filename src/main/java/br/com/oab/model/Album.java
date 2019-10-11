package br.com.oab.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Album {
	
	private String userId;
	private Integer id;
	private String title;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
