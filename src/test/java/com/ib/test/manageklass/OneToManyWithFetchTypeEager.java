package com.ib.test.manageklass;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.connector.StoreConnector;
import com.ib.entity.Klass;
import com.ib.entity.KlassRelationship;
import com.ib.entity.Relationship;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class OneToManyWithFetchTypeEager extends AbstractTestNGSpringContextTests {
  
  @Autowired
  StoreConnector storeConnector;
  
  @Autowired
  EntityManager  entityManager;
  
  @Test(priority = 1)
  public void execute()
  {
    // create class electronics
    Klass klass1 = new Klass();
    klass1.setName("Electronics");
    klass1 = storeConnector.saveKlass(klass1);
    
    // create class mobile
    Klass klass2 = new Klass();
    klass2.setName("mobile");
    klass2 = storeConnector.saveKlass(klass2);
    
    // create relationship between class electronics and mobile
    Relationship relationship = new Relationship();
    relationship.setName("Electronics-Mobile");
    
    KlassRelationship klassRelationship1 = new KlassRelationship();
    klassRelationship1.setCardinality("many");
    klassRelationship1.setKlass(klass1);
    klassRelationship1.setRelationship(relationship);
    
    KlassRelationship klassRelationship2 = new KlassRelationship();
    klassRelationship2.setCardinality("many");
    klassRelationship2.setKlass(klass2);
    klassRelationship2.setRelationship(relationship);
    
    // save relationship
    relationship = storeConnector.saveRelationShip(relationship);
    
    // Note : For Deleting the class
    // 1.get relationship and remove class references from relationship
    // 2.save relationship
    // 3.delete relationship
    
    for (KlassRelationship klassRelationship : relationship.getKlasses()) {
      Klass klass = klassRelationship.getKlass();
      klass.getKlassRelationships().remove(klassRelationship);
      klassRelationship.setKlass(null);
    }
    
    storeConnector.saveRelationShip(relationship);
    
    storeConnector.deleteRelationship(relationship);
    
  }
  
}
