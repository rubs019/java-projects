package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Replique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepliqueRepository extends CrudRepository<Replique, Integer> {
}
