package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Partie;
import com.javaschoolproject.demo.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartieService {

    private PartieRepository partieRepository;

    @Autowired
    public void PartieRepository(PartieRepository partieRepository) {
        this.partieRepository = partieRepository;
    }

    public Partie createPartie(Partie partie) {
        return partieRepository.save(partie);
    }

    public Iterable<Partie> findAllPartie() {
        return partieRepository.findAll();
    }
}
