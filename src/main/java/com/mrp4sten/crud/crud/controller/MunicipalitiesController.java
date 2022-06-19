package com.mrp4sten.crud.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrp4sten.crud.crud.dto.MunicipalityDto;
import com.mrp4sten.crud.crud.service.impl.MunicipalityServiceImpl;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/municipality")
public class MunicipalitiesController {

    @Autowired MunicipalityServiceImpl service;

    @RequestMapping(value = "/list")
    public ResponseEntity list() {
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody MunicipalityDto municipality) {
        return new ResponseEntity(service.add(municipality), HttpStatus.OK);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") String id, @RequestBody MunicipalityDto municipality) {
        return new ResponseEntity(service.update(id, municipality), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
}
