package com.vyacheslavbasovproject.developerapitask.repository;

import com.vyacheslavbasovproject.developerapitask.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    public Developer findByName(String name);
}
