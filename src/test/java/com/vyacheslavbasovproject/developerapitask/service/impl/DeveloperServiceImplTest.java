package com.vyacheslavbasovproject.developerapitask.service.impl;

import com.vyacheslavbasovproject.developerapitask.exceptions.dto.DeveloperDto;
import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.repository.DeveloperRepository;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype.aDeveloper;
import static com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype.aDeveloperDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class DeveloperServiceImplTest {

    @Mock
    DeveloperRepository developerRepository;
    @Mock
    DeveloperConverter developerConverter;

    DeveloperService developerService;

    @BeforeEach
    void init() {
        developerService = new DeveloperServiceImpl(developerRepository, developerConverter);
        when(developerConverter.fromDeveloperDtoToDeveloper(any())).thenReturn(aDeveloper());
        when(developerConverter.fromDeveloperToDeveloperDto(any())).thenReturn(aDeveloperDto());


    }

    @Test
    void createDeveloper_CreatedNewDeveloper() {
        when(developerRepository.save(any(Developer.class))).thenReturn(aDeveloper());
        DeveloperDto developerDtoCreated = developerService.create(aDeveloperDto());
        assertNotNull(developerDtoCreated);
        assertEquals(developerDtoCreated, aDeveloperDto());
    }

    @Test
    void createDeveloper_TrowingException() {
        when(developerRepository.save(any(Developer.class))).thenThrow(ConstraintViolationException.class);
        assertThrows(ConstraintViolationException.class, () -> developerService.create(aDeveloperDto()));
    }

    @Test
    void readAll_Success(){
        List<Developer> developerList = new ArrayList<>();
        developerList.add(aDeveloper());
        when(developerRepository.findAll()).thenReturn(developerList);
        assertNotNull(developerService.readAll());
        assertEquals(developerList
                        .stream()
                        .map(i->developerConverter.fromDeveloperToDeveloperDto(i))
                        .collect(Collectors.toList())
                , developerService.readAll());
    }

    @Test
    void readAll_returnEmptyList(){
        List<Developer> developerList = new ArrayList<>();
        when(developerRepository.findAll()).thenReturn(developerList);
        assertNotNull(developerService.readAll());
        assertEquals(developerList
                        .stream()
                        .map(i->developerConverter.fromDeveloperToDeveloperDto(i))
                        .collect(Collectors.toList())
                , developerService.readAll());
    }

    @Test
    void read_SuccessfulReadingById() throws DeveloperNotFoundException {
        when(developerRepository.findById(2L)).thenReturn(Optional.of(aDeveloper()));
        assertNotNull(developerService.read(2L));
        assertEquals(aDeveloperDto(), developerService.read(2L));

    }

    @Test
    void read_NotFoundDeveloper() {
        when(developerRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(DeveloperNotFoundException.class, () -> developerService.read(2L));

    }









}