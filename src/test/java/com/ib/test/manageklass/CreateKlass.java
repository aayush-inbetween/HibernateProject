package com.ib.test.manageklass;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.testng.annotations.Test;

import com.ib.connector.StoreConnector;
import com.ib.entity.Attribute;
import com.ib.entity.Klass;
import com.ib.entity.KlassAttribute;
import com.ib.entity.KlassRelationship;
import com.ib.entity.Relationship;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class CreateKlass extends AbstractTestNGSpringContextTests {
  
  @Autowired
  StoreConnector storeConnector;
  
  @Autowired
  JpaTransactionManager transactionManager;
  
  @Test
  public void execute()
  {

    TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
    
    //create attributes processor, memory , laptop charger and RAM
    Attribute attribute1 = new Attribute();
    attribute1.setName("processor");

    Attribute attribute2  = new Attribute();
    attribute2.setName("laptop charger");
    
    Attribute attribute3 = new Attribute();
    attribute3.setName("memory");
    
    Attribute attribute4 = new Attribute();
    attribute4.setName("RAM");
    
    List<Attribute> attributes = new ArrayList<Attribute>();
    attributes.add(attribute1);
    attributes.add(attribute3);
    attributes.add(attribute2);
    attributes.add(attribute4);

    //save attributes
    attributes = storeConnector.saveAttribute(attributes);
    
    
    //create class Electronics with attribute laptop charger and processor
    Klass klass1 = new Klass();
    klass1.setName("Electronics");
    
/*    KlassAttribute klassAttribute1 = new KlassAttribute();
    klassAttribute1.setExtendedAttributeName("Processor");
    klassAttribute1.setAttribute(attribute1);
    klassAttribute1.setKlass(klass1);
    
    KlassAttribute klassAttribute2 = new KlassAttribute();
    klassAttribute2.setExtendedAttributeName("laptop charger");
    klassAttribute2.setAttribute(attribute2);
    klassAttribute2.setKlass(klass1);
    
    klass1.getKlassAttributes().add(klassAttribute1);
    klass1.getKlassAttributes().add(klassAttribute2);*/
    
    klass1 = storeConnector.saveKlass(klass1);
    
    //create class mobile with attribute memory and RAM
    Klass klass2 = new Klass();
    klass2.setName("mobile");
    
/*    KlassAttribute klassAttribute3 = new KlassAttribute();
    klassAttribute3.setExtendedAttributeName("Memory");
    klassAttribute3.setAttribute(attribute3);
    klassAttribute3.setKlass(klass2);

    KlassAttribute klassAttribute4 = new KlassAttribute();
    klassAttribute4.setExtendedAttributeName("RAM");
    klassAttribute4.setAttribute(attribute4);
    klassAttribute4.setKlass(klass2);
    
    klass2.getKlassAttributes().add(klassAttribute3);
    klass2.getKlassAttributes().add(klassAttribute4);*/

    klass2 = storeConnector.saveKlass(klass2);
    
    //create relationship between electronics and mobile
/*    Relationship relationship = new Relationship();
    relationship.setName("Electronics-Mobile");
    
    KlassRelationship klassRelationship1 = new KlassRelationship();
    klassRelationship1.setCardinality("many");
    klassRelationship1.setKlass(klass1);
    klassRelationship1.setRelationship(relationship);
    
    KlassRelationship klassRelationship2 = new KlassRelationship();
    klassRelationship2.setCardinality("many");
    klassRelationship2.setKlass(klass2);
    klassRelationship2.setRelationship(relationship);
    
    relationship = storeConnector.saveRelationShip(relationship);*/
    
    //create class laptop as child of electronics
    Klass klass3 = new Klass();
    klass3.setName("laptop");
    klass3.setParent(klass1);
    klass1.getChildren().add(klass3);
    
/*    KlassAttribute klassAttribute5 = new KlassAttribute();
    klassAttribute5.setExtendedAttributeName("Memory");
    klassAttribute5.setAttribute(attribute3);
    klassAttribute5.setKlass(klass3);

    KlassAttribute klassAttribute6 = new KlassAttribute();
    klassAttribute6.setExtendedAttributeName("RAM");
    klassAttribute6.setAttribute(attribute4);
    klassAttribute6.setKlass(klass3);
    
    klass3.getKlassAttributes().add(klassAttribute5);
    klass3.getKlassAttributes().add(klassAttribute6);*/

    //create relationship between laptop and mobile
/*    Relationship relationship2 = new Relationship();
    relationship2.setName("Laptop-Mobile");
    
    KlassRelationship klassRelationship3 = new KlassRelationship();
    klassRelationship3.setCardinality("many");
    klassRelationship3.setKlass(klass2);
    klassRelationship3.setRelationship(relationship2);
    
    KlassRelationship klassRelationship4 = new KlassRelationship();
    klassRelationship4.setCardinality("many");
    klassRelationship4.setKlass(klass3);
    klassRelationship4.setRelationship(relationship2);*/

    klass3 = storeConnector.saveKlass(klass3);
    
    transactionManager.commit(status);

    status = transactionManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
    storeConnector.deleteKlass(klass3.getId());
    transactionManager.commit(status);
  }
}
