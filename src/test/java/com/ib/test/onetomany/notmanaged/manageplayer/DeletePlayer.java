package com.ib.test.onetomany.notmanaged.manageplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.PlayerConnector;
import com.ib.onetomany.notmanaged.eager.entity.Player;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class DeletePlayer extends AbstractTestNGSpringContextTests{

	@Autowired
	PlayerConnector playerConnector;
	@Test
	public void execute(){
		Player p = new Player();
		p.setId(1L);
		playerConnector.deletePlayer(p);
	}
}
