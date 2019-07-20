package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Goal;
import com.javaschoolproject.demo.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalController {

    private GoalRepository goalRepository;

    @Autowired
    public void GoalRepository(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Iterable<Goal> findAllGoal() {
        return goalRepository.findAll();
    }
}
