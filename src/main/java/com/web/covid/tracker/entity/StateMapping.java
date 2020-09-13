package com.web.covid.tracker.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "state_mapping")
public class StateMapping {

	@Id
	private String id;
	private String state;
	private String stateCode;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	@Override
	public String toString() {
		return "StateMapping [state=" + state + ", stateCode=" + stateCode + "]";
	}
	
	
}
