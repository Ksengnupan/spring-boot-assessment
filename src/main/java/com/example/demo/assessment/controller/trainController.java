package com.example.demo.assessment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/trains")
@Tag(name = "Train Management", description = "APIs for managing railway trains")
public class trainController {
    private final trainService trainService;

    public trainController(trainService trainService) {
        this.trainService = trainService;
    }

    @Operation(summary = "Get all trains")
    @ApiResponse(responseCode = "200", description = "List of all trains retrieved")
    @GetMapping
    public ResponseEntity<List<train>> getAllTrains() {
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    @Operation(summary = "Get train by ID")
    @ApiResponse(responseCode = "200", description = "Train found")
    @ApiResponse(responseCode = "404", description = "Train not found")
    @GetMapping("/{id}")
    public ResponseEntity<train> getTrainById(
            @Parameter(description = "Train ID") 
            @PathVariable Long id) {
        return ResponseEntity.ok(trainService.getTrainById(id));
    }

    @Operation(summary = "Create new train")
    @ApiResponse(responseCode = "201", description = "Train created successfully")
    @PostMapping
    public ResponseEntity<train> createTrain(
            @Parameter(description = "Train details") 
            @RequestBody train train) {
        return new ResponseEntity<>(trainService.createTrain(train), HttpStatus.CREATED);
    }

    @Operation(summary = "Update train")
    @ApiResponse(responseCode = "200", description = "Train updated successfully")
    @ApiResponse(responseCode = "404", description = "Train not found")
    @PutMapping("/{id}")
    public ResponseEntity<train> updateTrain(
            @Parameter(description = "Train ID") 
            @PathVariable Long id,
            @Parameter(description = "Updated train details") 
            @RequestBody train train) {
        return ResponseEntity.ok(trainService.updateTrain(id, train));
    }

    @Operation(summary = "Delete train")
    @ApiResponse(responseCode = "204", description = "Train deleted successfully")
    @ApiResponse(responseCode = "404", description = "Train not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(
            @Parameter(description = "Train ID") 
            @PathVariable Long id) {
        trainService.deleteTrain(id);
        return ResponseEntity.noContent().build();
    }
}