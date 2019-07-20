package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Field;
import com.javaschoolproject.demo.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/terrain")
public class FieldController {
    @Autowired
    private FieldRepository fieldRepository;

    @PostMapping()
    public String addNewTerrain (@RequestBody Field administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Field n = new Field();
        n.setNom("Nom");
        n.setLocalisation("14 Avenue Louis Pasteur");
        fieldRepository.save(n);
        return "Saved";
    }

    @GetMapping()
    public Iterable<Field> getAllTerrain(){
        return fieldRepository.findAll();
    }
}