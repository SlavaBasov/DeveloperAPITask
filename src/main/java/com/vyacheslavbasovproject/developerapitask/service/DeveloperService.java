package com.vyacheslavbasovproject.developerapitask.service;

import com.vyacheslavbasovproject.developerapitask.exceptions.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;

import java.util.List;

public interface DeveloperService {
    DeveloperDto create(DeveloperDto developerDto);
    List<DeveloperDto> readAll();
    DeveloperDto read(Long id) throws DeveloperNotFoundException;
    boolean update(DeveloperDto developerDto, Long id) throws DeveloperNotFoundException;
    boolean delete(Long id);

}
