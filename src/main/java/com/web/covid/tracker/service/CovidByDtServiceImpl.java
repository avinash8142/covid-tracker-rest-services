package com.web.covid.tracker.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.covid.tracker.entity.CovidByDt;
import com.web.covid.tracker.entity.CovidTrackDt;
import com.web.covid.tracker.entity.StateMapping;
import com.web.covid.tracker.model.CovidByDtCaseDt;
import com.web.covid.tracker.model.CovidByDtWrap;
import com.web.covid.tracker.model.CovidByDtWrapNew;
import com.web.covid.tracker.model.CovidByDtWrapper;
import com.web.covid.tracker.model.CovidTrackDtCaseDt;
import com.web.covid.tracker.model.CovidTrackDto;
import com.web.covid.tracker.model.CovidTrackDtoWrapper;
import com.web.covid.tracker.model.State;
import com.web.covid.tracker.repository.CovidByDtRepo;
import com.web.covid.tracker.repository.CovidRepository;
import com.web.covid.tracker.repository.CovidTrackDtRepo;
import com.web.covid.tracker.repository.StateMappingRepo;

@Service
public class CovidByDtServiceImpl implements CovidByDtService {

	@Autowired
	private CovidByDtRepo covidByDtRepo;

	@Autowired
	private CovidTrackDtRepo covidTrackDtRepo;

	@Autowired
	private CovidRepository covidRepository;

	@Autowired
	private StateMappingRepo stateMapping;

	@Override
	public CovidByDtWrapper getCovidByDt() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		List<CovidByDt> covids = covidByDtRepo.findAll();
		List<CovidByDtCaseDt> covidsDt=new ArrayList<>();
		CovidByDtCaseDt cDt=null;
		for(CovidByDt c:covids)
		{
			cDt=new CovidByDtCaseDt();
			Date caseDt=null;
			try {
				caseDt = format.parse(c.getCaseDt());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cDt.setCaseDt(caseDt);
			cDt.setActiveCase(c.getActiveCase());
			cDt.setConfirmedCase(c.getConfirmedCase());
			cDt.setFatalCase(c.getFatalCase());
			cDt.setRecoveredCase(c.getRecoveredCase());
			covidsDt.add(cDt);
		}
		Comparator<CovidByDtCaseDt> compDt=(c1,c2)->c1.getCaseDt().compareTo(c2.getCaseDt());
		covidsDt.sort(compDt.reversed());
		
		CovidByDtCaseDt c1 = covidsDt.get(0);
		c1.setActiveCase(c1.getConfirmedCase()-c1.getRecoveredCase()-c1.getFatalCase());
		List<CovidByDtWrap> covidWrap = new ArrayList<>();
		CovidByDtWrap wrap = null;
		for (int i = 1; i < covidsDt.size(); i++) {
			CovidByDtCaseDt c2 = covidsDt.get(i);
			c2.setActiveCase(c2.getConfirmedCase()-c2.getRecoveredCase()-c2.getFatalCase());
			wrap = new CovidByDtWrap();
			wrap.setCaseDt(c1.getCaseDt());
			wrap.setConfirmedCase(c1.getConfirmedCase());
			wrap.setRecoveredCase(c1.getRecoveredCase());
			wrap.setFatalCase(c1.getFatalCase());
			wrap.setActiveCase(c1.getActiveCase());
			wrap.setConfirmedDiff(c1.getConfirmedCase() - c2.getConfirmedCase());
			wrap.setRecoverDiff(c1.getRecoveredCase() - c2.getRecoveredCase());
			wrap.setFatalDiff(c1.getFatalCase() - c2.getFatalCase());
			wrap.setActiveDiff(c1.getActiveCase()-c2.getActiveCase());
			covidWrap.add(wrap);
			c1 = c2;

		}

		Comparator<CovidByDtWrap> compByDtWrap = (a, b) -> a.getCaseDt().compareTo(b.getCaseDt());
		List<CovidByDtWrap> wraps = covidWrap.stream().sorted(compByDtWrap).collect(Collectors.toList());
		List<CovidByDtWrapNew> wrapsNewList=new ArrayList<>();
		CovidByDtWrapNew w=null;
		for(CovidByDtWrap n:wraps)
		{
			w=new CovidByDtWrapNew();
			String casedt = format.format(n.getCaseDt());
			w.setCaseDt(casedt);
			w.setActiveCase(n.getActiveCase());
			w.setActiveDiff(n.getActiveDiff());
			w.setConfirmedCase(n.getConfirmedCase());
			w.setConfirmedDiff(n.getConfirmedDiff());
			w.setFatalCase(n.getFatalCase());
			w.setFatalDiff(n.getFatalDiff());
			w.setRecoverDiff(n.getRecoverDiff());
			w.setRecoveredCase(n.getRecoveredCase());
			wrapsNewList.add(w);
		}
		CovidByDtWrapper wrapper = new CovidByDtWrapper();
		wrapper.setCovidWraper(wrapsNewList);
		return wrapper;

	}

	@Override
	public CovidTrackDtoWrapper getCovidTrackDt() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Comparator<Date> compCaseDt = (d1, d2) -> d1.compareTo(d2);
		List<CovidTrackDt> cs = covidTrackDtRepo.findAll();
		List<CovidTrackDtCaseDt> listOfTrackDt=new ArrayList<>();
		CovidTrackDtCaseDt trackDt=null;
		for(CovidTrackDt t:cs)
		{
			trackDt = new CovidTrackDtCaseDt();
			Date caseDt=null;
			try {
				caseDt= format.parse(t.getCaseDt());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			trackDt.setCaseDt(caseDt);
			trackDt.setState(t.getState());
			trackDt.setStateCode(t.getStateCode());
			trackDt.setConfirmedCase(t.getConfirmedCase());
			trackDt.setCuredCase(t.getCuredCase());
			trackDt.setDeath(t.getDeath());
			trackDt.setActiveCase(t.getActiveCase());
			listOfTrackDt.add(trackDt);
		}
		
		TreeSet<Date> allCaseDts = listOfTrackDt.stream().map(cd -> cd.getCaseDt())
				.collect(Collectors.toCollection(() -> new TreeSet<Date>(compCaseDt.reversed())));

		List<Date> lastTwoDt = allCaseDts.stream().limit(2).collect(Collectors.toList());
		final String curDate = format.format(lastTwoDt.get(0));
		final String prevDate = format.format(lastTwoDt.get(1));
		
		List<CovidTrackDt> curData = cs.stream().filter(fil -> fil.getCaseDt().equalsIgnoreCase(curDate))
				.collect(Collectors.toList());
		List<CovidTrackDt> prevData = cs.stream().filter(fil -> fil.getCaseDt().equalsIgnoreCase(prevDate))
				.collect(Collectors.toList());
		List<CovidTrackDto> cts = new ArrayList<>();
		curData.forEach(cd -> {
			CovidTrackDto ct = new CovidTrackDto();
			if (cd!=null && cd.getStateCode()!=null && (cd.getStateCode().equals("MP") || cd.getStateCode().equals("AD") || cd.getStateCode().equals("OTH")
					|| cd.getStateCode().equals("JK") || cd.getStateCode().equals("HP")
					|| cd.getStateCode().equals("AN") || cd.getStateCode().equals("AR")
					|| cd.getStateCode().equals("DNH")))
				ct.setState(cd.getStateCode());
			else
				ct.setState(cd.getState());

			ct.setStateCode(cd.getStateCode());
			ct.setConfirmedCase(cd.getConfirmedCase());
			ct.setCuredCase(cd.getCuredCase());
			ct.setDeath(cd.getDeath());
			ct.setActiveCase(cd.getConfirmedCase()-cd.getCuredCase()-cd.getDeath());
			ct.setCaseDt(curDate);
			prevData.forEach(pd -> {
				if (pd!=null && cd!=null && pd.getStateCode()!=null && pd.getStateCode().equalsIgnoreCase(cd.getStateCode())) {
					ct.setConfirmedCaseDiff(cd.getConfirmedCase() - pd.getConfirmedCase());
					ct.setCuredCaseDiff(cd.getCuredCase() - pd.getCuredCase());
					ct.setDeathDiff(cd.getDeath() - pd.getDeath());
					ct.setActiveCaseDiff((cd.getConfirmedCase()-cd.getCuredCase()-cd.getDeath())
							-(pd.getConfirmedCase()-pd.getCuredCase()-pd.getDeath()));
				}
			});
			cts.add(ct);
		});
		Comparator<CovidTrackDto> CompConfirmed = (c1, c2) -> c1.getConfirmedCase() - c2.getConfirmedCase();
		Collections.sort(cts, CompConfirmed.reversed());
		CovidTrackDtoWrapper ctw = new CovidTrackDtoWrapper();
		ctw.setCovids(cts);
		return ctw;
	}

	@Override
	public CovidTrackDtoWrapper getStateCovidInfo(String state) {
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		List<CovidTrackDt> covids = covidTrackDtRepo.findByStateCode(state);
		Comparator<CovidTrackDtCaseDt> compDt = (d1, d2) -> d1.getCaseDt().compareTo(d2.getCaseDt());
		
		CovidTrackDtCaseDt trackDt =null;
		List<CovidTrackDtCaseDt> listOfTrackDt=new ArrayList<>();
		for(CovidTrackDt t:covids)
		{
			trackDt = new CovidTrackDtCaseDt();
			Date caseDt=null;
			try {
				caseDt=f.parse(t.getCaseDt());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			trackDt.setCaseDt(caseDt);
			trackDt.setActiveCase(t.getActiveCase());
			trackDt.setConfirmedCase(t.getConfirmedCase());
			trackDt.setCuredCase(t.getCuredCase());
			trackDt.setDeath(t.getDeath());
			trackDt.setState(t.getState());
			trackDt.setStateCode(t.getStateCode());
			listOfTrackDt.add(trackDt);
		}
		List<CovidTrackDtCaseDt> sortedByDt = listOfTrackDt.stream().sorted(compDt.reversed()).collect(Collectors.toList());
		
		List<CovidTrackDtCaseDt> formattedTrackRcd=new ArrayList<>();
		
		CovidTrackDtCaseDt curData = sortedByDt.get(0);
		curData.setActiveCase(curData.getConfirmedCase()-curData.getCuredCase()-curData.getDeath());
		
		for (int i = 1; i < sortedByDt.size(); i++) {
			CovidTrackDtCaseDt pData = sortedByDt.get(i);
			pData.setActiveCase(pData.getConfirmedCase()-pData.getCuredCase()-pData.getDeath());
			CovidTrackDtCaseDt cdc = new CovidTrackDtCaseDt();
			cdc.setState(curData.getState());
			cdc.setStateCode(curData.getStateCode());
			cdc.setConfirmedCase(curData.getConfirmedCase());
			cdc.setCuredCase(curData.getCuredCase());
			cdc.setDeath(curData.getDeath());
			cdc.setActiveCase(curData.getActiveCase());
			cdc.setCaseDt(curData.getCaseDt());
			cdc.setActiveCaseDiff(curData.getActiveCase()-pData.getActiveCase());
			cdc.setConfirmedCaseDiff(curData.getConfirmedCase()-pData.getConfirmedCase());
			cdc.setCuredCaseDiff(curData.getCuredCase()-pData.getCuredCase());
			cdc.setDeathDiff(curData.getDeath()-pData.getDeath());
			formattedTrackRcd.add(cdc);
			curData=pData;
//			CovidTrackDto ct = new CovidTrackDto();
//			ct.setState(curData.getState());
//			ct.setStateCode(curData.getStateCode());
//			ct.setCaseDt(curData.getCaseDt());
//			ct.setConfirmedCase(curData.getConfirmedCase());
//			ct.setCuredCase(curData.getCuredCase());
//			ct.setDeath(curData.getDeath());
//			ct.setActiveCase(curData.getActiveCase());
//			ct.setConfirmedCaseDiff(curData.getConfirmedCase() - pData.getConfirmedCase());
//			ct.setCuredCaseDiff(curData.getCuredCase() - pData.getCuredCase());
//			ct.setDeathDiff(curData.getDeath() - pData.getDeath());
//			ct.setActiveCaseDiff(curData.getActiveCase()-pData.getActiveCase());
//			listOfCovidsByState.add(ct);
//			curData = pData;
			
		}
		List<CovidTrackDtCaseDt> ctds = formattedTrackRcd.stream()
				.sorted((t1, t2) -> t1.getCaseDt().compareTo(t2.getCaseDt())).collect(Collectors.toList());
		List<CovidTrackDto> listOfCovidsByState = new ArrayList<>();
		for(CovidTrackDtCaseDt d:ctds)
		{
			CovidTrackDto c=new CovidTrackDto();
			String caseDt = f.format(d.getCaseDt());
			c.setCaseDt(caseDt);
			c.setState(d.getState());
			c.setStateCode(d.getStateCode());
			c.setConfirmedCase(d.getConfirmedCase());
			c.setConfirmedCaseDiff(d.getConfirmedCaseDiff());
			c.setActiveCase(d.getActiveCase());
			c.setActiveCaseDiff(d.getActiveCaseDiff());
			c.setCuredCase(d.getCuredCase());
			c.setCuredCaseDiff(d.getCuredCaseDiff());
			c.setDeath(d.getDeath());
			c.setDeathDiff(d.getDeathDiff());
			listOfCovidsByState.add(c);
			
		}
		CovidTrackDtoWrapper ctw = new CovidTrackDtoWrapper();
		ctw.setCovids(listOfCovidsByState);
		return ctw;
	}

	@Override
	public List<State> getStates() {
		List<State> states = new ArrayList<>();
		covidRepository.findAll().forEach(t -> {
			State s = new State();
			s.setState(t.getState());
			s.setStateCode(t.getStateCode());
			states.add(s);
		});
		return states;
	}

	@Override
	public void loadDataFromFile() {

		String fileName = "D:\\covid05022020\\covid-data\\covid-india.txt";
		List<String> allStates = null;
		Path path = Paths.get(fileName);
		try {
			allStates = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<StateMapping> states = stateMapping.findAll();
		Map<String, String> map = new HashMap<>();
		states.forEach(t -> {
			map.put(t.getState(), t.getStateCode());
		});
		String curDate = LocalDate.now().toString();
		String istFormat = curDate.substring(8, 10) + "-" + curDate.substring(5, 7) + "-" + curDate.substring(0, 4);
		CovidTrackDt ct = null;
		int totalConfirmed = 0;
		int totalRecovered = 0;
		int fatalCases = 0;
		int active = 0;
		covidTrackDtRepo.deleteByCaseDt(istFormat);
		for (String state : allStates) {
			ct = new CovidTrackDt();
			String[] st = state.split(",");
			try {
				ct.setState(st[1] != null ? st[1] : "");
				ct.setStateCode(st[1] != null ? map.get(st[1]) : "");
//				ct.setConfirmedCase(st[5] != null ? Integer.valueOf(st[5]) : 0);
				ct.setConfirmedCase(Integer.valueOf(st[2].trim())+Integer.valueOf(st[4].trim())+Integer.valueOf(st[6].trim()));
				ct.setCuredCase(st[4] != null ? Integer.valueOf(st[4]) : 0);
				ct.setDeath(st[6] != null ? Integer.valueOf(st[6]) : 0);
				ct.setCaseDt(istFormat);
				totalConfirmed += ct.getConfirmedCase();
				totalRecovered += st[4] != null ? Integer.valueOf(st[4].trim()) : 0;
				fatalCases += st[6] != null ? Integer.valueOf(st[6].trim()) : 0;
				covidTrackDtRepo.save(ct);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		active = totalConfirmed - totalRecovered - fatalCases;
		CovidByDt cb = new CovidByDt(); 
		cb.setCaseDt(istFormat);
		cb.setConfirmedCase(totalConfirmed);
		cb.setRecoveredCase(totalRecovered);
		cb.setFatalCase(fatalCases);
		cb.setActiveCase(active);
		List<CovidByDt> curData = covidByDtRepo.findByCaseDt(istFormat);
		if(curData!=null && !curData.isEmpty())
		{
			System.out.println("deleting existing records for "+istFormat);
			covidByDtRepo.deleteByCaseDt(istFormat);
		}
		
		covidByDtRepo.save(cb);

		System.out.println("confirmed " + totalConfirmed + " Active " + active + " Recover " + totalRecovered
				+ " fatal " + fatalCases);

	}

}
