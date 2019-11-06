package com.bmdb.db;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Actor;

//T= type = Stuffy, ID = Integer
public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
