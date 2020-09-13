package com.web.covid.tracker.model;

import java.util.List;

import com.web.covid.tracker.entity.CovidTracker;

public class CovidTrackerWrapper {

	private List<CovidTracker> covids;
	
	

	public CovidTrackerWrapper(List<CovidTracker> covids) {
		this.covids = covids;
	}

	public List<CovidTracker> getCovids() {
		return covids;
	}

	public void setCovids(List<CovidTracker> covids) {
		this.covids = covids;
	}
	
	
	
	
}
