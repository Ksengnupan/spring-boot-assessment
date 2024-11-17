package com.example.demo.assessment.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.assessment.model.station;

public interface stationRepository extends JpaRepository<station, Long> {
}
