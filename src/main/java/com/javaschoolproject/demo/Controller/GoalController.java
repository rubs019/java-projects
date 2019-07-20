package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Field;
import com.javaschoolproject.demo.models.Goal;
import com.javaschoolproject.demo.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/objectif")
public class GoalController {
    @Autowired
    private GoalRepository goalRepository;

    @PostMapping()
    public String addNewGoal (@RequestBody Field administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Goal n = new Goal();
        n.setNom("Nom");
        n.setType("capture de point");
        goalRepository.save(n);
        return "Saved";
    }

    @GetMapping()
    public Iterable<Goal> getAllGoal(){
        return goalRepository.findAll();
    }
}
