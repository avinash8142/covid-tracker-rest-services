package com.web.covid.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.covid.tracker.entity.CovidTracker;
import com.web.covid.tracker.model.CovidByDtWrapper;
import com.web.covid.tracker.model.CovidTrackDtoWrapper;
import com.web.covid.tracker.model.CovidTrackerWrapper;
import com.web.covid.tracker.model.State;
import com.web.covid.tracker.repository.CovidRepository;
import com.web.covid.tracker.service.CovidByDtService;

@RestController
@CrossOrigin
public class CovidController {
	
	@Autowired
	private CovidRepository covidRepository;
	
	@Autowired
	private CovidByDtService covidByDtService;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping()
	{
		return new ResponseEntity<String>("CovidController called",HttpStatus.OK);
	}
	
	@GetMapping("/covid")
	public ResponseEntity<CovidTrackerWrapper> getCovidInfo()
	{
		List<CovidTracker> covids = covidRepository.findAll();
		CovidTrackerWrapper wrapper = new CovidTrackerWrapper(covids);
		return new ResponseEntity<CovidTrackerWrapper>(wrapper,HttpStatus.OK);
	}
	
	@GetMapping("/covid/cases")
	public ResponseEntity<CovidByDtWrapper> getCovidsByDt()
	{
		CovidByDtWrapper wrapper = covidByDtService.getCovidByDt();
		return new ResponseEntity<CovidByDtWrapper>(wrapper,HttpStatus.OK);
		
	}
	
	@GetMapping("/covid/info")
	public ResponseEntity<CovidTrackDtoWrapper> getCovidInfoByState()
	{
		CovidTrackDtoWrapper covidTrackDt = covidByDtService.getCovidTrackDt();
		return new ResponseEntity<CovidTrackDtoWrapper>(covidTrackDt,HttpStatus.OK);
		
	}
	@GetMapping("/covid/state")
	public ResponseEntity<CovidTrackDtoWrapper> getCovidByState(@RequestParam("stateCode") String stateCode)
	{
		CovidTrackDtoWrapper stateCovidInfo = covidByDtService.getStateCovidInfo(stateCode);
		return new ResponseEntity<CovidTrackDtoWrapper>(stateCovidInfo,HttpStatus.OK);
		
	}
	@GetMapping("/covid/listofstate")
	public ResponseEntity<List<State>> getState()
	{
		List<State> states = covidByDtService.getStates();
		return new ResponseEntity<List<State>>(states,HttpStatus.OK);
		
	}
	@GetMapping("/covid/load")
	public ResponseEntity<String> loadCovidData()
	{
		covidByDtService.loadDataFromFile();
		return new ResponseEntity<String>("Success",HttpStatus.OK);
		
	}
}
