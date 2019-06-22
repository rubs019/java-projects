package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.domaine.Partie;
import com.javaschoolproject.demo.domaine.Terrain;
import org.springframework.data.repository.CrudRepository;

public interface PartieRepository extends CrudRepository<Partie, Integer> {
}
