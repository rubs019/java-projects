package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer> {
}
