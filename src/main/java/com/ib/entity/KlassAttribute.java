package com.ib.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class KlassAttribute implements Serializable {
  
  private static final long         serialVersionUID = -2595912739968751719L;

  @EmbeddedId
  private CompositeKlassAttributeId id               = new CompositeKlassAttributeId();
  
  private String                    extendedAttributeName;
  
  public CompositeKlassAttributeId getId()
  {
    return id;
  }
  
  public void setId(CompositeKlassAttributeId id)
  {
    this.id = id;
  }
  
  @Transient
  public Attribute getAttribute()
  {
    return getId().getAttribute();
  }
  
  public void setAttribute(Attribute attribute)
  {
    getId().setAttribute(attribute);
  }
  
  @Transient
  public Klass getKlass()
  {
    return getId().getKlass();
  }
  
  public void setKlass(Klass klass)
  {
    getId().setKlass(klass);
  }
  
  public String getExtendedAttributeName()
  {
    return extendedAttributeName;
  }
  
  public void setExtendedAttributeName(String extendedAttributeName)
  {
    this.extendedAttributeName = extendedAttributeName;
  }
  
}
