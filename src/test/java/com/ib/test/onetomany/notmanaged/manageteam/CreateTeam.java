package com.ib.test.onetomany.notmanaged.manageteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.TeamConnector;
import com.ib.onetomany.notmanaged.eager.entity.Team;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class CreateTeam extends AbstractTestNGSpringContextTests
{
	@Autowired
	TeamConnector teamconnector;
	
	@Test
	public void execute()
	{
		Team team1= new Team();
		team1.setName("India");
		teamconnector.saveTeam(team1);
		
		Team team2= new Team();
		team2.setName("Australia");
		teamconnector.saveTeam(team2);
		
		Team team3= new Team();
		team3.setName("England");
		teamconnector.saveTeam(team3);
		
		
	}
}