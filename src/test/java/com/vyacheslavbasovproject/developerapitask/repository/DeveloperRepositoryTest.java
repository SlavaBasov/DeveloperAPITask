package com.vyacheslavbasovproject.developerapitask.repository;

import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void findByName_SuccessfullyFound() {
        developerRepository.save(DeveloperPrototype.aDeveloper());
        Developer foundDeveloper = developerRepository.findByName(DeveloperPrototype.aDeveloper().getName());
        assertNotNull(foundDeveloper);
        assertEquals(foundDeveloper.getName(), DeveloperPrototype.aDeveloper().getName());
        assertEquals(foundDeveloper.getEmail(), DeveloperPrototype.aDeveloper().getEmail());
    }

    @Test
    void findByName_NotFound() {
        developerRepository.save(DeveloperPrototype.aDeveloper());
        Developer foundDeveloper = developerRepository.findByName("incorrect_name");
        assertNull(foundDeveloper);
    }
}