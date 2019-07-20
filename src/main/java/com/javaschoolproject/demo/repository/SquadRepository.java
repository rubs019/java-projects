package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Squad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends CrudRepository<Squad, Integer> {
}
