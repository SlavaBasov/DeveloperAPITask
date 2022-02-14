package com.vyacheslavbasovproject.developerapitask.service.impl;


import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.repository.DeveloperRepository;
import com.vyacheslavbasovproject.developerapitask.service.DeveloperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype.aDeveloper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeveloperServiceImplTest {

    private DeveloperRepository developerRepository;
    private DeveloperService developerService;

    @BeforeEach
    void setUp() {
        developerRepository = mock(DeveloperRepository.class);
        developerService = new DeveloperServiceImpl(developerRepository);
    }

//    @Test
//    void createDeveloper() {
//    }
//
//    @Test
//    void updateDeveloper() {
//    }

    @Test
    void findDeveloper_ById_SuccessfullyFound() throws DeveloperNotFoundException {
        when(developerRepository.findById(anyLong())).thenReturn(Optional.of(aDeveloper()));
        assertEquals(developerService.findDeveloper(anyLong()), aDeveloper());
    }

    @Test
    void findDeveloper_ById_NotFoundException()  {
        Exception exception = assertThrows(DeveloperNotFoundException.class, ()->developerService.findDeveloper(anyLong()));
        assertEquals(exception.getMessage(), String.format("Not found developer by id=%d",anyLong()));
    }

//    @Test
//    void testFindDeveloper() {
//    }
//
//    @Test
//    void findAllDevelopers() {
//    }

//    @Test
//    void deleteDeveloper() {
//    }

//    @Test
//    void testDeleteDeveloper() {
//    }
}