package com.vyacheslavbasovproject.developerapitask;

import com.vyacheslavbasovproject.developerapitask.controller.DeveloperController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DeveloperApiTaskApplicationTest {

    @Autowired
    DeveloperController developerController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(developerController);
    }
}