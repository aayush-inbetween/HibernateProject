package com.ib.test.onetomany.notmanaged.manageplayer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.PlayerConnector;
import com.ib.onetomany.notmanaged.eager.entity.Player;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class ListAll extends AbstractTestNGSpringContextTests{

	@Autowired
	PlayerConnector playerConnector;
	
	@Resource(name = "createdPlayerIds")
	List<Long> createdPlayerIds;
	

	@Test(priority = 1)
	public void createPlayer(){
		Player player = new Player();
		player.setName("Rahul Dravid");
		player.setAge(35);
		player = playerConnector.savePlayer(player);
		
		Player player2 = new Player();
		player2.setName("Sourav Ganguly");
		player2.setAge(35);
		playerConnector.savePlayer(player2);
	}
	
	@Test(priority = 2)
	public void execute(){
		playerConnector.getAllPlayers();
	}
}
