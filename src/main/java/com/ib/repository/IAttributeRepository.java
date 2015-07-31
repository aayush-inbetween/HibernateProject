package com.ib.repository;

import org.springframework.data.repository.CrudRepository;

import com.ib.entity.Attribute;

public interface IAttributeRepository extends CrudRepository<Attribute, Long> {
  
}
