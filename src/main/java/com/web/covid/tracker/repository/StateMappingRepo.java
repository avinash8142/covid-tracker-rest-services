package com.web.covid.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.web.covid.tracker.entity.StateMapping;

@Repository
public interface StateMappingRepo extends MongoRepository<StateMapping, String> {

}
