package com.ib.test.manageattribute;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ib.connector.StoreConnector;
import com.ib.entity.Attribute;
import com.ib.test.configuration.ApplicationContextConfiguration;

@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class CreateAttribute extends AbstractTestNGSpringContextTests {
  
  @Autowired
  StoreConnector storeConnector;
  
  @Resource(name = "createdAttributeIds")
  List<Long>     createdAttributeIds;
  
  @Test
  public void execute()
  {
    
    Attribute attribute1 = new Attribute();
    attribute1.setName("price");
    
    Attribute attribute2 = new Attribute();
    attribute2.setName("title");
    
    Attribute attribute3 = new Attribute();
    attribute3.setName("description");
    
    Attribute attribute4 = new Attribute();
    attribute4.setName("display");
    
    Attribute attribute5 = new Attribute();
    attribute5.setName("processor");
    
    Attribute attribute6 = new Attribute();
    attribute6.setName("memory");
    
    List<Attribute> attributes = new ArrayList<Attribute>();
    attributes.add(attribute1);
    attributes.add(attribute2);
    attributes.add(attribute3);
    attributes.add(attribute4);
    attributes.add(attribute5);
    attributes.add(attribute6);
    
    attributes = storeConnector.saveAttribute(attributes);
    
    for (Attribute attribute : attributes) {
      createdAttributeIds.add(attribute.getId());
    }
  }
}
