package com.ib.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KlassRelationship {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long         id;
  
  private String       cardinality;
  
  @ManyToOne(cascade = CascadeType.ALL)
  private Relationship relationship;
  
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH }, fetch = FetchType.LAZY)
  private Klass        klass;
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getCardinality()
  {
    return cardinality;
  }
  
  public void setCardinality(String cardinality)
  {
    this.cardinality = cardinality;
  }
  
  public Relationship getRelationship()
  {
    return relationship;
  }
  
  public void setRelationship(Relationship relationship)
  {
    this.relationship = relationship;
    relationship.getKlasses().add(this);
  }
  
  public Klass getKlass()
  {
    return klass;
  }
  
  public void setKlass(Klass klass)
  {
    this.klass = klass;
    if(klass != null){
      klass.getKlassRelationships().add(this);      
    }
  }
  
}
