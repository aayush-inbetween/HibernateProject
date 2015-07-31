package com.ib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Klass {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long                   id;
  
  private String                 name;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.klass", fetch = FetchType.EAGER,
      orphanRemoval = true)
  private Set<KlassAttribute>    klassAttributes    = new HashSet<KlassAttribute>();
  
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER,
      mappedBy = "klass")
  private Set<KlassRelationship> klassRelationships = new HashSet<KlassRelationship>();
  
  @ManyToOne
  private Klass                  parent;
  
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true,
      mappedBy = "parent")
  // @Fetch(FetchMode.SELECT)
  private Set<Klass>             children           = new HashSet<Klass>();
  
  public Long getId()
  {
    
    return this.id;
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
  
  public Set<KlassAttribute> getKlassAttributes()
  {
    return klassAttributes;
  }
  
  public void setKlassAttributes(Set<KlassAttribute> klassAttributes)
  {
    this.klassAttributes = klassAttributes;
  }
  
  public Set<KlassRelationship> getKlassRelationships()
  {
    return klassRelationships;
  }
  
  public void setKlassRelationships(Set<KlassRelationship> klassRelationships)
  {
    
    this.klassRelationships = klassRelationships;
  }
  
  public Klass getParent()
  {
    return parent;
  }
  
  public void setParent(Klass parent)
  {
    this.parent = parent;
  }
  
  public Set<Klass> getChildren()
  {
    return children;
  }
  
  public void setChildren(Set<Klass> children)
  {
    this.children = children;
  }
  
}
