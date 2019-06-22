package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.domaine.Terrain;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
