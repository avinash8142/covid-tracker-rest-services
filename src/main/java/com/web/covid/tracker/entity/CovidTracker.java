package com.web.covid.tracker.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "covid_tracker")
public class CovidTracker {
	@Id
	private String id;
	private String state;
	private String stateCode;
	private Integer confirmedCase;
	private Integer curedCase;
	private Integer death;
	
	
	public CovidTracker() {
	}
	public CovidTracker(String id,String state, Integer confirmedCase, Integer curedCase, Integer death) {
		this.id=id;
		this.state = state;
		this.confirmedCase = confirmedCase;
		this.curedCase = curedCase;
		this.death = death;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getConfirmedCase() {
		return confirmedCase;
	}
	public void setConfirmedCase(Integer confirmedCase) {
		this.confirmedCase = confirmedCase;
	}
	public Integer getCuredCase() {
		return curedCase;
	}
	public void setCuredCase(Integer curedCase) {
		this.curedCase = curedCase;
	}
	public Integer getDeath() {
		return death;
	}
	public void setDeath(Integer death) {
		this.death = death;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	
	

}
