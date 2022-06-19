package com.mrp4sten.crud.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrp4sten.crud.crud.dto.ProviderDto;

@RestController
@RequestMapping(value = "/provider")
public class ProvidersController {
    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody ProviderDto provider) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") String id, @RequestBody ProviderDto provider) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
