package br.com.ithings.controller;

import br.com.ithings.model.CityModel;
import br.com.ithings.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping
    public ResponseEntity<CityModel> create(CityModel cityModel){
        CityModel model = service.create(cityModel);
        return  new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityModel> findById(@PathVariable(name = "id")long id){
        CityModel model = service.findById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CityModel> update(@RequestBody CityModel cityModel){
        CityModel model = service.update(cityModel);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CityModel>> findALl(){
        var List = service.findAll();
        return new ResponseEntity<List<CityModel>>(list, HttpStatus.OK);
    }
}
