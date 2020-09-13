package com.web.covid.tracker.model;

import java.util.List;

public class CovidTrackDtoWrapper {

	private List<CovidTrackDto> covids;

	public List<CovidTrackDto> getCovids() {
		return covids;
	}

	public void setCovids(List<CovidTrackDto> covids) {
		this.covids = covids;
	}

	@Override
	public String toString() {
		return "CovidTrackDtoWrapper [covids=" + covids + "]";
	}
	
	
}
