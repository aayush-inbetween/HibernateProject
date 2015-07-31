package com.ib.test.onetomany.notmanaged.manageteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.TeamConnector;
import com.ib.onetomany.notmanaged.eager.entity.Team;
import com.ib.test.configuration.ApplicationContextConfiguration;


@ContextConfiguration(classes=ApplicationContextConfiguration.class)
class DeleteTeam extends AbstractTestNGSpringContextTests
{
	@Autowired
	TeamConnector teamconnector;
	
	@Test
	public void execute()
	{
		Team team = new Team();
		team.setId(1L);
		teamconnector.deleteTeam(team);
		
	}
}