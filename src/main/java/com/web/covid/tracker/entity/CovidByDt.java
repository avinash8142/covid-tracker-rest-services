package com.web.covid.tracker.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "covid_cases_dt")
public class CovidByDt {
	
	@Id
	private String id;
	private String caseDt;
	private Integer confirmedCase;
	private Integer activeCase;
	private Integer recoveredCase;
	private Integer fatalCase;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaseDt() {
		return caseDt;
	}
	public void setCaseDt(String caseDt) {
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
		return "CovidByDt [id=" + id + ", caseDt=" + caseDt + ", confirmedCase=" + confirmedCase + ", activeCase="
				+ activeCase + ", recoveredCase=" + recoveredCase + ", fatalCase=" + fatalCase + "]";
	}
	
	
	
	
 
	
	
}
