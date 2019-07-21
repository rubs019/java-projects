package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Day;
import com.javaschoolproject.demo.models.Field;
import com.javaschoolproject.demo.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/days")
public class DayController {
    @Autowired
    private DayService dayService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Day> addNewDay (@Valid @RequestBody Day day, HttpServletRequest request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Day createdDay = dayService.createDay(day);
        URI location = URI.create(request.getRequestURL().append("/").append(createdDay.getId()).toString());
        return ResponseEntity.created(location).body(createdDay);
    }

    @GetMapping()
    public Iterable<Day> getAllDays(){
        return dayService.findAllDay();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Day> getDayById(@PathVariable String id) {
        Optional<Day> foundDay = dayService.findDayById(Integer.parseInt(id));
        if(!foundDay.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundDay.get());
    }

    @DeleteMapping("/{id}")
    public void deleteDay(@PathVariable String id) {
        dayService.deleteDay(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Day> updateSquadById(@RequestBody Day day, @PathVariable String id) {
        Optional<Day> foundDay = dayService.findDayById(Integer.parseInt(id));
        if(!foundDay.isPresent()){
            return ResponseEntity.notFound().build();
        }
        day.setId(foundDay.get().getId());
        dayService.updateDay(day);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/field")
    public ResponseEntity<Field> getField(@PathVariable String id) {
        Optional<Day> foundDay = dayService.findDayById(Integer.parseInt(id));
        if(!foundDay.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundDay.get().getField());
    }

}