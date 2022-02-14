package com.vyacheslavbasovproject.developerapitask.repository;

import com.vyacheslavbasovproject.developerapitask.exceptions.DeveloperNotFoundException;
import com.vyacheslavbasovproject.developerapitask.model.Developer;
import com.vyacheslavbasovproject.developerapitask.prototype.DeveloperPrototype;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
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