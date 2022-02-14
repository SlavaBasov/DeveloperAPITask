package com.vyacheslavbasovproject.developerapitask.service.impl;

import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.repository.DeveloperRepository;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public Developer createDeveloper(Developer developer) {
        return null;
    }

    @Override
    public boolean updateDeveloper(Developer developer) {
        return false;
    }

    @Override
    public Developer findDeveloper(Long id) {
        return null;
    }

    @Override
    public Developer findDeveloper(String name) {
        return null;
    }

    @Override
    public List<Developer> findAllDevelopers() {
        return null;
    }

    @Override
    public boolean deleteDeveloper(Long id) {
        return false;
    }

    @Override
    public boolean deleteDeveloper(Developer developer) {
        return false;
    }
}
