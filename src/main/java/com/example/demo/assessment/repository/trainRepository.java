package com.example.demo.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.assessment.model.train;

public interface trainRepository extends JpaRepository<train, Long> {
    
}
