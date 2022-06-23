package com.mrp4sten.crud.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrp4sten.crud.crud.dto.EntityDto;
import com.mrp4sten.crud.crud.service.impl.EntitiesServiceImpl;

@RestController
@RequestMapping(value = "/entity")
public class EntitiesController {

    @Autowired EntitiesServiceImpl service;

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody EntityDto entity) {
        return new ResponseEntity(service.add(entity), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") String id, @RequestBody EntityDto entity) {
        return new ResponseEntity(service.update(id, entity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}
