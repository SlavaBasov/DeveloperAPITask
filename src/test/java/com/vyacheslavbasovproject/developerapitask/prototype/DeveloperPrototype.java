package com.vyacheslavbasovproject.developerapitask.prototype;

import com.vyacheslavbasovproject.developerapitask.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.model.Developer;

public class DeveloperPrototype {

    public static Developer aDeveloper(){
        Developer developer = new Developer();
        developer.setId(1L);
        developer.setName("test_name");
        developer.setEmail("test_email@gmail.com");
        return developer;
    }

    public static DeveloperDto aDeveloperDto(){
        return DeveloperDto.builder()
                .id(1L)
                .name("test_name")
                .email("test_email@gmail.com")
                .build();
    }
}
