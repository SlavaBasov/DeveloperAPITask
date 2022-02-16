package com.vyacheslavbasovproject.developerapitask.service.impl;

import com.vyacheslavbasovproject.developerapitask.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.repository.DeveloperRepository;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype.aDeveloper;
import static com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype.aDeveloperDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DeveloperServiceImplTest {

    @Mock
    DeveloperRepository developerRepository;
    @Mock
    DeveloperConverter developerConverter;
    @InjectMocks
    DeveloperService developerService = new DeveloperServiceImpl(developerRepository, developerConverter);

    @BeforeEach
    void init() {
        when(developerConverter.fromDeveloperDtoToDeveloper(any(DeveloperDto.class))).thenReturn(aDeveloper());
        when(developerConverter.fromDeveloperToDeveloperDto(any(Developer.class))).thenReturn(aDeveloperDto());
        when(developerRepository.save(any(Developer.class))).thenReturn(aDeveloper());

    }

    @Test
    @Disabled
    void createDeveloper_CreatedNewDeveloper() {
        DeveloperDto aDevDto = aDeveloperDto();
        DeveloperDto developerDtoCreated = developerService.create(aDeveloperDto());
        assertEquals(developerDtoCreated, aDevDto);
    }
}