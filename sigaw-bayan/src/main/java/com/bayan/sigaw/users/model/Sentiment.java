package com.bayan.sigaw.users.model;

import java.sql.Timestamp;

public class Sentiment {
	private String saroNo;
	private String sentiment;
	private Timestamp dateCreated;
	private float rating;
	private String type;
	public String getSaroNo() {
		return saroNo;
	}
	public void setSaroNo(String saroNo) {
		this.saroNo = saroNo;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
