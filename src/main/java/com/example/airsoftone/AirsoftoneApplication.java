package com.example.airsoftone;

import com.example.airsoftone.domaine.Terrain;
import com.example.airsoftone.services.TerrainServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirsoftoneApplication implements CommandLineRunner {
    private  final TerrainServices terrainServices;

    public AirsoftoneApplication(TerrainServices terrainServices){
        this.terrainServices = terrainServices;
    }
    public static void main(String[] args) {
        SpringApplication.run(AirsoftoneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Terrain ter1 = new Terrain("Chez loic","Bievres");
        Terrain ter2 = new Terrain("Chez Christopher","Montgeron");
        Terrain ter3 = new Terrain("Chez PSG","Paris");
        System.out.println("----------------------------------Add new Terrain ------------------------------------");
        System.out.println("Terrain info"+terrainServices.save(ter1));
        System.out.println("Terrain info"+terrainServices.save(ter2));
        System.out.println("Terrain info"+terrainServices.save(ter3));
        terrainServices.getAllTerrain().forEach(terrain ->
                System.out.println("Nom : " + terrain.getNom()+ "Localisation : "+ terrain.getLocalisation()));
        System.out.println("----------------------------------delete Terrain ------------------------------------");
        terrainServices.delete(ter1);
        terrainServices.getAllTerrain().forEach(terrain ->
                System.out.println("Nom : " + terrain.getNom()+ "Localisation : "+ terrain.getLocalisation()));
    }
}
