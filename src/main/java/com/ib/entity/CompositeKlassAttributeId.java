package com.ib.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CompositeKlassAttributeId implements Serializable {
  
  private static final long serialVersionUID = 896520510938991406L;
  
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
  private Klass             klass;
  
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
  private Attribute         attribute;
  
  public Klass getKlass()
  {
    return klass;
  }
  
  public void setKlass(Klass klass)
  {
    this.klass = klass;
  }
  
  public Attribute getAttribute()
  {
    return attribute;
  }
  
  public void setAttribute(Attribute attribute)
  {
    this.attribute = attribute;
  }
  
}
