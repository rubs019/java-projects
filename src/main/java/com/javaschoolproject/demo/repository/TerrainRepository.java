package com.javaschoolproject.demo.repository;

import com.javaschoolproject.demo.models.Terrain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends CrudRepository<Terrain, Integer> {
}
