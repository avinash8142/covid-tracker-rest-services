package com.web.covid.tracker.model;

public class State {
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
		return "State [state=" + state + ", stateCode=" + stateCode + "]";
	}

}
