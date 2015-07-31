package com.ib.onetomany.notmanaged.eager.repository;

import org.springframework.data.repository.CrudRepository;

import com.ib.onetomany.notmanaged.eager.entity.Team;

public interface ITeam extends CrudRepository<Team, Long>{

	
}
