package com.ib.onetomany.notmanaged.eager.repository;

import org.springframework.data.repository.CrudRepository;

import com.ib.onetomany.notmanaged.eager.entity.Player;

public interface IPlayer extends CrudRepository<Player, Long>{

}
