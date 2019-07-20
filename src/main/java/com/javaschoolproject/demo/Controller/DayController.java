package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Day;
import com.javaschoolproject.demo.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/day")
public class DayController {
    @Autowired
    private DayRepository dayRepository;

    @PostMapping(path = "/")
    public String addNewDay (@RequestBody Day day) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Day r = new Day();
        r.setNom("Nom");
        dayRepository.save(r);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Day> getAllReplique(){
        return dayRepository.findAll();
    }
}