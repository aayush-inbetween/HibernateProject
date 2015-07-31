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
public class GetplayerById extends AbstractTestNGSpringContextTests {

	@Autowired
	PlayerConnector playerConnector;


	@Resource(name = "createdPlayerIds") 
	List<Long> createdPlayerIds;


	@Test(priority = 1)
	public void createPlayer() {
		Player player = new Player();
		player.setName("Rahul Dravid");
		player.setAge(35);
		createdPlayerIds.add(playerConnector.savePlayer(player).getId());

	}

	@Test(priority = 2)
	public void execute() {
		Player player = playerConnector.getPlayerById(createdPlayerIds.get(0));
		System.out.println("ID\tName\tAge\tTeam");
		System.out.println(player.getId()+"\t"+player.getName()+"\t"+player.getAge()+"\t"+player.getTeam());
		
	}
}
