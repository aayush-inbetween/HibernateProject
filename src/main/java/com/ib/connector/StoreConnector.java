package com.ib.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ib.entity.Attribute;
import com.ib.entity.Klass;
import com.ib.entity.Relationship;
import com.ib.repository.IAttributeRepository;
import com.ib.repository.IKlassRepository;
import com.ib.repository.IRelationshipRepository;

@Component
public class StoreConnector {
  
  @Autowired
  IKlassRepository        klassRepository;
  
  @Autowired
  IRelationshipRepository relationshipRepository;
  
  @Autowired
  IAttributeRepository    attributeRepository;
  
  public List<Attribute> saveAttribute(List<Attribute> attributes)
  {
    return (List<Attribute>) attributeRepository.save(attributes);
  }
  
  public Klass saveKlass(Klass klass)
  {
    return klassRepository.save(klass);
  }
  
  public void deleteKlass(Long id)
  {
    klassRepository.delete(id);
  }
  
  public Klass getKlass(Long id)
  {
    return klassRepository.findOne(id);
  }
  
  public Relationship saveRelationShip(Relationship relationship)
  {
    return relationshipRepository.save(relationship);
  }
  
  public void deleteRelationship(Long id)
  {
    relationshipRepository.delete(id);
  }
  
  public void deleteRelationship(Relationship relationship)
  {
    relationshipRepository.delete(relationship);
  }
  
  public Relationship getRelationship(Long id)
  {
    return relationshipRepository.findOne(id);
  }
}
