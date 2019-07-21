package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Day;
import com.javaschoolproject.demo.models.Field;
import com.javaschoolproject.demo.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DayService {
    private DayRepository dayRepository;

    @Autowired
    public void DayRepository(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public Day createDay(Day day){
        return dayRepository.save(day);
    }

    public Iterable<Day> findAllDay() {
        return dayRepository.findAll();
    }

    public Optional<Day> findDayById(Integer id) {
        return dayRepository.findById(id);
    }

    public void deleteDay(Integer id){
        dayRepository.deleteById(id);
    }

    public void updateDay(Day day){
        dayRepository.save(day);
    }

    public Day addField(Day day, Field field){
        day.setField(field);
        return dayRepository.save(day);
    }
}
