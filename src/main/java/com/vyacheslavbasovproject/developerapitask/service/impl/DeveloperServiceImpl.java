package com.vyacheslavbasovproject.developerapitask.service.impl;

import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.repository.DeveloperRepository;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public boolean createDeveloper(Developer developer) throws DeveloperNotFoundException {
        Developer foundDeveloper = findDeveloper(developer.getName());
        if(foundDeveloper!=null){
            return updateDeveloper(developer);
        }
        developerRepository.save(developer);
        return true;
    }

    @Override
    @Transactional
    public boolean updateDeveloper(Developer developer) throws DeveloperNotFoundException {
        Developer foundDeveloper = findDeveloper(developer.getId());
        foundDeveloper.setName(developer.getName());
        foundDeveloper.setEmail(developer.getEmail());
        return true;
    }

    @Override
    public Developer findDeveloper(Long id) throws DeveloperNotFoundException {
        Developer developer;
        Optional<Developer> developerOptional = developerRepository.findById(id);
        if(developerOptional.isPresent()){
            developer = developerOptional.get();
        }else {
            throw new DeveloperNotFoundException(String.format("Not found developer by id=%d",id));
        }
        return developer;
    }

    @Override
    public Developer findDeveloper(String name) {
        return developerRepository.findByName(name);
    }

    @Override
    public List<Developer> findAllDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public boolean deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteDeveloper(Developer developer) {
        developerRepository.delete(developer);
        return true;
    }
}
