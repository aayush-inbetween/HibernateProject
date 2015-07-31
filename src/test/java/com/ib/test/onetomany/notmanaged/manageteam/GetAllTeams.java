package com.ib.test.onetomany.notmanaged.manageteam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.TeamConnector;
import com.ib.onetomany.notmanaged.eager.entity.Team;
import com.ib.test.configuration.ApplicationContextConfiguration;



@ContextConfiguration(classes = ApplicationContextConfiguration.class)
class GetAllTeams extends AbstractTestNGSpringContextTests
{
	@Autowired
	TeamConnector teamconnector;
	
	@Test(priority = 1)
	public void createTeam()
	{
		Team team = new Team();
		team.setName("West-Indies");
		teamconnector.saveTeam(team).getId();

		Team team2 = new Team();
		team2.setName("Bangladesh");
		teamconnector.saveTeam(team2).getId();
	}

	@Test(priority = 2)
	public void execute()
	{
		List<Team> team = teamconnector.getAllTeams();
		System.out.println("ID\tName");
		for(int i=0;i<team.size();i++) 
		{
			System.out.println(team.get(i).getId()+"\t"+team.get(i).getName());
		}
	
	}
}