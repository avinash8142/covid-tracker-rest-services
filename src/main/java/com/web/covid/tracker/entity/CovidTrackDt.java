package com.web.covid.tracker.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "covid_track")
public class CovidTrackDt {

	@Id
	private String id;
	private String state;
	private String stateCode;
	private Integer confirmedCase;
	private Integer curedCase;
	private Integer death;
	private String caseDt;
	private Integer activeCase;
	
	
	
	public Integer getActiveCase() {
		return activeCase;
	}

	public void setActiveCase(Integer activeCase) {
		this.activeCase = activeCase;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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

	public String getCaseDt() {
		return caseDt;
	}

	public void setCaseDt(String caseDt) {
		this.caseDt = caseDt;
	}

	@Override
	public String toString() {
		return "CovidTrackDt [state=" + state + ", stateCode=" + stateCode + ", confirmedCase=" + confirmedCase
				+ ", curedCase=" + curedCase + ", death=" + death + ", caseDt=" + caseDt + "]";
	}

}
