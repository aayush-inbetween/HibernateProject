package com.ib.test.onetomany.notmanaged.manageteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.ib.onetomany.notmanaged.eager.connector.TeamConnector;
import com.ib.test.configuration.ApplicationContextConfiguration;


@ContextConfiguration(classes = ApplicationContextConfiguration.class)
class UpdateTeam
{
	@Autowired
	TeamConnector teamconnector;
}