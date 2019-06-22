package com.example.airsoftone.repository;

import com.example.airsoftone.domaine.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrainRepository extends JpaRepository<Terrain, Long> {
}
