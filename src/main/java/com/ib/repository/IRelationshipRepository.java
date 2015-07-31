package com.ib.repository;

import org.springframework.data.repository.CrudRepository;

import com.ib.entity.Relationship;

public interface IRelationshipRepository extends CrudRepository<Relationship, Long> {
  
}
