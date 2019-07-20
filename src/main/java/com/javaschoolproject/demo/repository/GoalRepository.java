package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Goal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Integer>{
}
