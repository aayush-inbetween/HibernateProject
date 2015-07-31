package com.ib.onetomany.notmanaged.eager.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Team {
	
	@Id
	@GeneratedValue
	Long id;
	
	String name;
	
	@OneToMany(mappedBy = "team")
	Set<Player> player = new HashSet<Player>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Player> getPlayer() {
		return player;
	}

	public void setPlayer(Set<Player> player) {
		this.player = player;
	}

}