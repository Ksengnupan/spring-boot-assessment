package com.example.demo.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.assessment.model.station;
import com.example.demo.assessment.repository.stationRepository;

@Service
public class stationService {
    private final stationRepository stationRepository;

    public stationService(stationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<station> getAllStations() {
        return stationRepository.findAll();
    }

    public station getStationById(Long id) {
        return stationRepository.findById(id).orElseThrow(() -> new RuntimeException("Station not found"));
    }

    public station createStation(station station) {
        return stationRepository.save(station);
    }

    public station updateStation(Long id, station updatedStation) {
        station station = getStationById(id);
        station.setStationCode(updatedStation.getStationCode());
        station.setStationName(updatedStation.getStationName());
        station.setLocation(updatedStation.getLocation());
        station.setContactInfo(updatedStation.getContactInfo());
        return stationRepository.save(station);
    }

    public void deleteStation(Long id) {
        stationRepository.deleteById(id);
    }
}
