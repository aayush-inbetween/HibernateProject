package com.ib.test.onetomany.notmanaged.manageplayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.PlayerConnector;
import com.ib.onetomany.notmanaged.eager.entity.Player;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class ListAllPlayers extends AbstractTestNGSpringContextTests {

	@Autowired
	PlayerConnector playerConnector;

	/*
	 * @Resource(name = "createdPlayerIds") List<Long> createdPlayerIds;
	 */

	@Test(priority = 1)
	public void createPlayer() {
		Player player = new Player();
		player.setName("Rahul Dravid");
		player.setAge(35);
		playerConnector.savePlayer(player).getId();

		Player player2 = new Player();
		player2.setName("Sourav Ganguly");
		player2.setAge(35);
		playerConnector.savePlayer(player2);
	}

	@Test(priority = 2)
	public void execute() {
		List<Player> player = playerConnector.getAllPlayers();
		System.out.println("ID\tName\tAge\tTeam");
		for(int i=0;i<player.size();i++) {
			System.out.println(player.get(i).getId()+"\t"+player.get(i).getName()+"\t"+player.get(i).getAge()+"\t"+player.get(i).getTeam());
		}
	}
}
