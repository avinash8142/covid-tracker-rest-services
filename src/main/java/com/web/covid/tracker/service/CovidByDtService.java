package com.web.covid.tracker.service;

import java.util.List;

import com.web.covid.tracker.model.CovidByDtWrapper;
import com.web.covid.tracker.model.CovidTrackDtoWrapper;
import com.web.covid.tracker.model.State;

public interface CovidByDtService {

	public CovidByDtWrapper getCovidByDt();
	public CovidTrackDtoWrapper getCovidTrackDt();
	public CovidTrackDtoWrapper getStateCovidInfo(String state);
	public List<State> getStates();
	public void loadDataFromFile();
	
	
}
