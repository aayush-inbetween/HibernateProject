package com.ib.onetomany.notmanaged.eager.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ib.onetomany.notmanaged.eager.entity.Player;
import com.ib.onetomany.notmanaged.eager.repository.IPlayerRepository;

@Component
public class PlayerConnector {

	@Autowired
	IPlayerRepository iPlayerRepository;

	public Player savePlayer(Player player) {
		return iPlayerRepository.save(player);
	}

	public void deletePlayer(Player player) {
		iPlayerRepository.delete(player);
	}

	public List<Player> getAllPlayers() {
		return (List<Player>) iPlayerRepository.findAll();
	}

	public Player getPlayerById(Long Id) {
		return iPlayerRepository.findOne(Id);
	}

}
