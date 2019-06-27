package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Partie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartieRepository extends CrudRepository<Partie, Integer> {
}
