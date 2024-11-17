package com.example.demo.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.assessment.model.ticket;

public interface ticketRepository extends JpaRepository<ticket, Long> {
}
