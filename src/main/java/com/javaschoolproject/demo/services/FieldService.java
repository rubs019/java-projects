package com.javaschoolproject.demo.services;

import com.javaschoolproject.demo.models.Field;
import com.javaschoolproject.demo.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FieldService {

    private FieldRepository fieldRepository;

    @Autowired
    public void FieldRepository(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field createField(Field field) {
        return fieldRepository.save(field);
    }

    public Iterable<Field> findAllField() {
        return fieldRepository.findAll();
    }

    public Optional<Field> findFieldById(Integer id) {
        return fieldRepository.findById(id);
    }
    public void deleteField(Integer id){
        fieldRepository.deleteById(id);
    }
    public void updateField(Field field){
        fieldRepository.save(field);
    }
}
