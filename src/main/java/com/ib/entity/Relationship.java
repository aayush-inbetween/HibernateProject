package com.ib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Relationship {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;
  
  private String                 name;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationship", fetch = FetchType.EAGER,
      orphanRemoval = true)
  private Set<KlassRelationship> klasses = new HashSet<KlassRelationship>();
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public Set<KlassRelationship> getKlasses()
  {
    return klasses;
  }
  
  public void setKlasses(Set<KlassRelationship> klasses)
  {
    this.klasses = klasses;
  }
  
}
