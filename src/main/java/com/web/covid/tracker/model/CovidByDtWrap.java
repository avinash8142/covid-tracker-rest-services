package com.web.covid.tracker.model;

import java.util.Date;

public class CovidByDtWrap {

	private Date caseDt;
	private Integer confirmedCase;
	private Integer activeCase;
	private Integer recoveredCase;
	private Integer fatalCase;
	private Integer confirmedDiff;
	private Integer activeDiff;
	private Integer recoverDiff;
	private Integer fatalDiff;
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
	public Integer getConfirmedDiff() {
		return confirmedDiff;
	}
	public void setConfirmedDiff(Integer confirmedDiff) {
		this.confirmedDiff = confirmedDiff;
	}
	public Integer getActiveDiff() {
		return activeDiff;
	}
	public void setActiveDiff(Integer activeDiff) {
		this.activeDiff = activeDiff;
	}
	public Integer getRecoverDiff() {
		return recoverDiff;
	}
	public void setRecoverDiff(Integer recoverDiff) {
		this.recoverDiff = recoverDiff;
	}
	public Integer getFatalDiff() {
		return fatalDiff;
	}
	public void setFatalDiff(Integer fatalDiff) {
		this.fatalDiff = fatalDiff;
	}
	@Override
	public String toString() {
		return "CovidByDtWrap [caseDt=" + caseDt + ", confirmedCase=" + confirmedCase + ", activeCase=" + activeCase
				+ ", recoveredCase=" + recoveredCase + ", fatalCase=" + fatalCase + ", confirmedDiff=" + confirmedDiff
				+ ", activeDiff=" + activeDiff + ", recoverDiff=" + recoverDiff + ", fatalDiff=" + fatalDiff + "]";
	}
	
	
}
