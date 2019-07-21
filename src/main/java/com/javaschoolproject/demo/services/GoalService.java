package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Goal;
import com.javaschoolproject.demo.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public void GoalRepository(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Iterable<Goal> findAllGoal() {
        return goalRepository.findAll();
    }

    public Optional<Goal> findGoalById(Integer id) {
        return goalRepository.findById(id);
    }
    public void deleteGoal(Integer id){
        goalRepository.deleteById(id);
    }
    public void updateGoal(Goal goal){
        goalRepository.save(goal);
    }
}
