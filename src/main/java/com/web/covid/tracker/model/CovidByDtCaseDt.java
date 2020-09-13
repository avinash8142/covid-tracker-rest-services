package com.web.covid.tracker.model;

import java.util.Date;

public class CovidByDtCaseDt {

	private Date caseDt;
	private Integer confirmedCase;
	private Integer activeCase;
	private Integer recoveredCase;
	private Integer fatalCase;
	public Date getCaseDt() {
		return caseDt;
	}
	public void setCaseDt(Date caseDt) {
		this.caseDt = caseDt;
	}
	public Integer getConfirmedCase() {
		return confirmedCase;
	}
	public void setConfirmedCase(Integer confirmedCase) {
		this.confirmedCase = confirmedCase;
	}
	public Integer getActiveCase() {
		return activeCase;
	}
	public void setActiveCase(Integer activeCase) {
		this.activeCase = activeCase;
	}
	public Integer getRecoveredCase() {
		return recoveredCase;
	}
	public void setRecoveredCase(Integer recoveredCase) {
		this.recoveredCase = recoveredCase;
	}
	public Integer getFatalCase() {
		return fatalCase;
	}
	public void setFatalCase(Integer fatalCase) {
		this.fatalCase = fatalCase;
	}
	@Override
	public String toString() {
		return "CovidByDtCaseDt [caseDt=" + caseDt + ", confirmedCase=" + confirmedCase + ", activeCase=" + activeCase
				+ ", recoveredCase=" + recoveredCase + ", fatalCase=" + fatalCase + "]";
	}
	
	
}
