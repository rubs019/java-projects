package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Field;
import com.javaschoolproject.demo.repository.FieldRepository;
import com.javaschoolproject.demo.services.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/terrain")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Field> addNewField (@Valid @RequestBody Field field, HttpServletRequest request) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Field createdField = fieldService.createField(field);
        URI location = URI.create(request.getRequestURL().append("/").append(createdField.getId()).toString());
        return ResponseEntity.created(location).body(createdField);
    }

    @GetMapping()
    public Iterable<Field> getAllField(){
        return fieldService.findAllField();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> getFieldById(@PathVariable String id) {
        Optional<Field> foundField = fieldService.findFieldById(Integer.parseInt(id));
        if(!foundField.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundField.get());
    }

    @DeleteMapping("/{id}")
    public void deleteField(@PathVariable String id) {
        fieldService.deleteField(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Field> updateFieldById(@RequestBody Field field, @PathVariable String id) {
        Optional<Field> foundField = fieldService.findFieldById(Integer.parseInt(id));
        if(!foundField.isPresent()){
            return ResponseEntity.notFound().build();
        }
        field.setId(foundField.get().getId());
        fieldService.updateField(field);
        return ResponseEntity.noContent().build();
    }
}