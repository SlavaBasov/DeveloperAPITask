package com.vyacheslavbasovproject.developerapitask.service.impl;

import com.vyacheslavbasovproject.developerapitask.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.model.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperConverter {
    public Developer fromDeveloperDtoToDeveloper(DeveloperDto developerDto){
        Developer developer = new Developer();
        developer.setId(developerDto.getId());
        developer.setName(developerDto.getName());
        developer.setEmail(developerDto.getEmail());
        return developer;
    }

    public DeveloperDto fromDeveloperToDeveloperDto(Developer developer){
        return DeveloperDto.builder()
                .id(developer.getId())
                .name(developer.getName())
                .email(developer.getEmail())
                .build();
    }
}
