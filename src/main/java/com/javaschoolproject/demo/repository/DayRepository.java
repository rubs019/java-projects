package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Day;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends CrudRepository<Day, Integer> {
}
