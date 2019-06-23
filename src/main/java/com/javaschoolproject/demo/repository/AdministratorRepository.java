package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {
}
