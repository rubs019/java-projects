package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Goal;
import com.javaschoolproject.demo.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/objectif")
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Goal> addNewGoal (@Valid @RequestBody Goal goal, HttpServletRequest request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Goal createdGoal = goalService.createGoal(goal);
        URI location = URI.create(request.getRequestURL().append("/").append(createdGoal.getId()).toString());
        return ResponseEntity.created(location).body(createdGoal);
    }

    @GetMapping()
    public Iterable<Goal> getAllGoal(){
        return goalService.findAllGoal();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable String id) {
        Optional<Goal> foundGoal = goalService.findGoalById(Integer.parseInt(id));
        if(!foundGoal.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundGoal.get());
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable String id) {
        goalService.deleteGoal(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoalById(@RequestBody Goal goal, @PathVariable String id) {
        Optional<Goal> foundGoal = goalService.findGoalById(Integer.parseInt(id));
        if(!foundGoal.isPresent()){
            return ResponseEntity.notFound().build();
        }
        goal.setId(foundGoal.get().getId());
        goalService.updateGoal(goal);
        return ResponseEntity.noContent().build();
    }
}
