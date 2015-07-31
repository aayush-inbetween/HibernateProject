package com.ib.onetomany.notmanaged.eager.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ib.onetomany.notmanaged.eager.entity.Team;
import com.ib.onetomany.notmanaged.eager.repository.ITeamRepository;

@Component
public class TeamConnector 
{
	@Autowired
	ITeamRepository iTeamRepository;
	
	
	public Team saveTeam(Team team)
	{
		return iTeamRepository.save(team);
	}
	
	
	public void deleteTeam(Team team)
	{
		
		 iTeamRepository.delete(team);
	}
	
	
	
	public List<Team> getAllTeams()
	{
		return (List<Team>) iTeamRepository.findAll();
	}
	
	public Team getTeam(Team team)
	{
		
		return iTeamRepository.findOne(team.getId());
	}
	
	
	
	
}
