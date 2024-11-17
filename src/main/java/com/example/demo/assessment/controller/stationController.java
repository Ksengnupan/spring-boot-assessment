package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assessment.model.station;
import com.example.demo.assessment.service.stationService;

@RestController
@RequestMapping("/api/stations")
public class stationController {
    private final stationService stationService;

    public stationController(stationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public List<station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public station getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }

    @PostMapping
    public station createStation(@RequestBody station station) {
        return stationService.createStation(station);
    }

    @PutMapping("/{id}")
    public station updateStation(@PathVariable Long id, @RequestBody station station) {
        return stationService.updateStation(id, station);
    }

    @DeleteMapping("/{id}")
    public void deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
    }
}
