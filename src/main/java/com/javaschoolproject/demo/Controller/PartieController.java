package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Partie;
import com.javaschoolproject.demo.repository.PartieRepository;
import com.javaschoolproject.demo.services.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/partie")
public class PartieController {
    private PartieService partieService;

    @Autowired
    public void PartieService(PartieService partieService) {
        this.partieService = partieService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void createPartie(@Valid @RequestBody Partie partie, HttpServletResponse response, HttpServletRequest request) {

        Partie createdPartie = partieService.createPartie(partie);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdPartie.getId()).toString());
    }

    @GetMapping()
    public Iterable<Partie> getAllPartie() {
        return partieService.findAllPartie();
    }
}