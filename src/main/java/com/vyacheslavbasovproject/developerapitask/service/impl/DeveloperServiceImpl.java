package com.vyacheslavbasovproject.developerapitask.service.impl;

import com.vyacheslavbasovproject.developerapitask.exceptions.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.repository.DeveloperRepository;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperConverter developerConverter;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository, DeveloperConverter developerConverter) {
        this.developerRepository = developerRepository;
        this.developerConverter = developerConverter;
    }

    @Override
    public DeveloperDto create(DeveloperDto developerDto) {
        Developer developer = developerConverter.fromDeveloperDtoToDeveloper(developerDto);
        Developer developerCreated = developerRepository.save(developer);
        return developerConverter.fromDeveloperToDeveloperDto(developerCreated);
    }

    @Override
    public List<DeveloperDto> readAll() {
        return developerRepository.findAll().stream()
                .map(developerConverter::fromDeveloperToDeveloperDto)
                .collect(Collectors.toList());
    }

    @Override
    public DeveloperDto read(Long id) throws DeveloperNotFoundException {
        Developer developer = find(id);
        return developerConverter.fromDeveloperToDeveloperDto(developer);
    }

    private Developer find(Long id) throws DeveloperNotFoundException {
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
    @Transactional
    public boolean update(DeveloperDto developerDto, Long id) throws DeveloperNotFoundException {
        Developer foundDeveloper = find(id);
        foundDeveloper.setName(developerDto.getName());
        foundDeveloper.setEmail(developerDto.getEmail());
        return foundDeveloper.getName().equals(developerDto.getName());
    }

    @Override
    public boolean delete(Long id) {
        developerRepository.deleteById(id);
        return true;
    }
}
