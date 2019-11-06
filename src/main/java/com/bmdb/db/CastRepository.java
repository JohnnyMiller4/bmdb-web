package com.bmdb.db;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Cast;

//T= type = Stuffy, ID = Integer
public interface CastRepository extends CrudRepository<Cast, Integer> {

}
