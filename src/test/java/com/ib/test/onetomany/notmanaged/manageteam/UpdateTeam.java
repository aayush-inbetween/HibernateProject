package com.ib.test.onetomany.notmanaged.manageteam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.ib.onetomany.notmanaged.eager.connector.TeamConnector;
import com.ib.onetomany.notmanaged.eager.entity.Player;
import com.ib.onetomany.notmanaged.eager.entity.Team;
import com.ib.test.configuration.ApplicationContextConfiguration;


@ContextConfiguration(classes = ApplicationContextConfiguration.class)
class UpdateTeam
{
	@Autowired
	TeamConnector teamconnector;
	
	
	

	@Resource(name = "createdTeamsIds")
	List<Long> createdTeamsIds;


	@Test(priority = 1)
	public void createTeam() {

		Team team = new Team();
		team.setName("New-Zealand");
		
		team = teamconnector.saveTeam(team);
		createdTeamsIds.add(team.getId());
	}


	@Test(priority = 2)
	public void execute() {

		Team team = teamconnector.getTeam(createdTeamsIds.get(0));
		team.setName("Bangladesh");
		
		teamconnector.saveTeam(team);
		
	}
}