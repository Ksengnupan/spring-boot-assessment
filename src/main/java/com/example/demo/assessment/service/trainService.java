
package com.example.demo.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.assessment.model.train;
import com.example.demo.assessment.repository.trainRepository;

@Service
public class trainService {
    private final trainRepository trainRepository;

    public trainService(trainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<train> getAllTrains() {
        return trainRepository.findAll();
    }

    public train getTrainById(Long id) {
        return trainRepository.findById(id).orElseThrow(() -> new RuntimeException("Train not found"));
    }

    public train createTrain(train train) {
        return trainRepository.save(train);
    }

    public train updateTrain(Long id, train updatedTrain) {
        train train = getTrainById(id);
        train.setTrainNumber(updatedTrain.getTrainNumber());
        train.setDepartureTime(updatedTrain.getDepartureTime());
        train.setArrivalTime(updatedTrain.getArrivalTime());
        train.setOriginStation(updatedTrain.getOriginStation());
        train.setDestinationStation(updatedTrain.getDestinationStation());
        train.setSeatCapacity(updatedTrain.getSeatCapacity());
        train.setTicketPrice(updatedTrain.getTicketPrice());
        return trainRepository.save(train);
    }

    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }
}
