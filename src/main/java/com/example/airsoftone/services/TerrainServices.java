package com.example.airsoftone.services;

import com.example.airsoftone.domaine.Terrain;
import com.example.airsoftone.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TerrainServices {

    private final TerrainRepository terrainRepository;

    public TerrainServices(TerrainRepository terrainRepository){
        this.terrainRepository = terrainRepository;
    }

    public Terrain save(Terrain terrain){
        return terrainRepository.save(terrain);
    }

    public void delete(Terrain terrain){
        terrainRepository.delete(terrain);
    }

    public List<Terrain> getAllTerrain(){
        return terrainRepository.findAll();
    }

}
