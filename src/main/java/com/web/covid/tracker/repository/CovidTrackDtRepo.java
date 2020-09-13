package com.web.covid.tracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.web.covid.tracker.entity.CovidTrackDt;

@Repository
public interface CovidTrackDtRepo extends MongoRepository<CovidTrackDt, String> {
	
	public List<CovidTrackDt> findByStateCode(String stateCode);
	public void deleteByCaseDt(String caseDt);

}
