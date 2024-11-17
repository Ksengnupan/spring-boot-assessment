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

import com.example.demo.assessment.model.train;
import com.example.demo.assessment.service.trainService;

@RestController
@RequestMapping("/api/trains")
public class trainController {
    private final trainService trainService;

    public trainController(trainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public List<train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/{id}")
    public train getTrainById(@PathVariable Long id) {
        return trainService.getTrainById(id);
    }

    @PostMapping
    public train createTrain(@RequestBody train train) {
        return trainService.createTrain(train);
    }

    @PutMapping("/{id}")
    public train updateTrain(@PathVariable Long id, @RequestBody train train) {
        return trainService.updateTrain(id, train);
    }

    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
    }
}
