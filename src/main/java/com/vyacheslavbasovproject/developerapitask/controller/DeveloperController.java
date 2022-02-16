package com.vyacheslavbasovproject.developerapitask.controller;

import com.vyacheslavbasovproject.developerapitask.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("/developers")
    public ResponseEntity<List<DeveloperDto>> getAllDevelopers(){
        List<DeveloperDto> developers = developerService.readAll();
        return ResponseEntity.ok().body(developers);
    }

    @PostMapping("/developers")
    public ResponseEntity<?> newDeveloper(@RequestBody DeveloperDto developerDto) {
        developerService.create(developerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
