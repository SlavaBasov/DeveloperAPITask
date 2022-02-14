package com.vyacheslavbasovproject.developerapitask.service;

import com.vyacheslavbasovproject.developerapitask.model.Developer;

import java.util.List;

public interface DeveloperService {
    Developer createDeveloper(Developer developer);
    boolean updateDeveloper(Developer developer);
    Developer findDeveloper(Long id);
    Developer findDeveloper(String name);
    List<Developer> findAllDevelopers();
    boolean deleteDeveloper(Long id);
    boolean deleteDeveloper(Developer developer);

}
