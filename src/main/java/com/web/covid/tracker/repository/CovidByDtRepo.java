package com.web.covid.tracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.web.covid.tracker.entity.CovidByDt;

@Repository
public interface CovidByDtRepo extends MongoRepository<CovidByDt, Long> {

	public void deleteByCaseDt(String caseDt);
	public List<CovidByDt> findByCaseDt(String caseDt);
}
