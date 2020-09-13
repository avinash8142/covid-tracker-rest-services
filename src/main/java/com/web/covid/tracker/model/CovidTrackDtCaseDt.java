package com.web.covid.tracker.model;

import java.util.Date;

public class CovidTrackDtCaseDt {
	private String state;
	private String stateCode;
	private Integer confirmedCase;
	private Integer curedCase;
	private Integer death;
	private Date caseDt;
	private Integer activeCase;
	private Integer confirmedCaseDiff;
	private Integer curedCaseDiff;
	private Integer deathDiff;
	private Integer activeCaseDiff;
	
	

	public Integer getConfirmedCaseDiff() {
		return confirmedCaseDiff;
	}

	public void setConfirmedCaseDiff(Integer confirmedCaseDiff) {
		this.confirmedCaseDiff = confirmedCaseDiff;
	}

	public Integer getCuredCaseDiff() {
		return curedCaseDiff;
	}

	public void setCuredCaseDiff(Integer curedCaseDiff) {
		this.curedCaseDiff = curedCaseDiff;
	}

	public Integer getDeathDiff() {
		return deathDiff;
	}

	public void setDeathDiff(Integer deathDiff) {
		this.deathDiff = deathDiff;
	}

	public Integer getActiveCaseDiff() {
		return activeCaseDiff;
	}

	public void setActiveCaseDiff(Integer activeCaseDiff) {
		this.activeCaseDiff = activeCaseDiff;
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

	public Date getCaseDt() {
		return caseDt;
	}

	public void setCaseDt(Date caseDt) {
		this.caseDt = caseDt;
	}

	public Integer getActiveCase() {
		return activeCase;
	}

	public void setActiveCase(Integer activeCase) {
		this.activeCase = activeCase;
	}

	@Override
	public String toString() {
		return "CovidTrackDtCaseDt [state=" + state + ", stateCode=" + stateCode + ", confirmedCase=" + confirmedCase
				+ ", curedCase=" + curedCase + ", death=" + death + ", caseDt=" + caseDt + ", activeCase=" + activeCase
				+ "]";
	}

}
