package com.vyacheslavbasovproject.developerapitask.controller;

import com.vyacheslavbasovproject.developerapitask.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping("/developers")
    public ResponseEntity<?> create(@RequestBody DeveloperDto developerDto) {
        developerService.create(developerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/developers")
    public ResponseEntity<List<DeveloperDto>> readAll(){
        List<DeveloperDto> developers = developerService.readAll();
        return developers != null && !developers.isEmpty()
                ? new ResponseEntity<>(developers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/developers/{id}")
    public ResponseEntity<DeveloperDto> read(@PathVariable(name = "id") Long id) throws DeveloperNotFoundException {
        final DeveloperDto developerDto = developerService.read(id);
        return developerDto != null
                ? new ResponseEntity<>(developerDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/developers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody DeveloperDto developerDto)
            throws DeveloperNotFoundException {
        final boolean updated = developerService.update(developerDto, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/developers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        final boolean deleted = developerService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }




}
