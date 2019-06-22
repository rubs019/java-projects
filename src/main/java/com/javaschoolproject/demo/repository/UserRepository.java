package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.domaine.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
