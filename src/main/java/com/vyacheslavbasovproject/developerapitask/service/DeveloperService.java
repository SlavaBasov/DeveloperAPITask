package com.vyacheslavbasovproject.developerapitask.service;

import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.model.Developer;

import java.util.List;

public interface DeveloperService {
    boolean createDeveloper(Developer developer) throws DeveloperNotFoundException;
    boolean updateDeveloper(Developer developer) throws DeveloperNotFoundException;
    Developer findDeveloper(Long id) throws DeveloperNotFoundException;
    Developer findDeveloper(String name);
    List<Developer> findAllDevelopers();
    boolean deleteDeveloper(Long id);
    boolean deleteDeveloper(Developer developer);

}
