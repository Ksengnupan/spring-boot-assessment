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

import com.example.demo.assessment.model.station;
import com.example.demo.assessment.service.stationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/stations")
@Tag(name = "Station Management", description = "APIs for managing railway stations")
public class stationController {
    private final stationService stationService;

    public stationController(stationService stationService) {
        this.stationService = stationService;
    }

    @Operation(
        summary = "Get all stations",
        description = "Retrieves a list of all railway stations in the system"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved all stations",
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = station.class))
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
        )
    })
    @GetMapping
    public ResponseEntity<List<station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @Operation(
        summary = "Get station by ID",
        description = "Retrieves a specific railway station by its ID"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Station found",
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = station.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Station not found"
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<station> getStationById(
        @Parameter(description = "ID of the station to retrieve", required = true)
        @PathVariable Long id
    ) {
        return ResponseEntity.ok(stationService.getStationById(id));
    }

    @Operation(
        summary = "Create a new station",
        description = "Creates a new railway station in the system"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Station created successfully",
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = station.class))
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid station data provided"
        )
    })
    @PostMapping
    public ResponseEntity<station> createStation(
        @Parameter(description = "Station details", required = true)
        @RequestBody station station
    ) {
        return new ResponseEntity<>(stationService.createStation(station), HttpStatus.CREATED);
    }

    @Operation(
        summary = "Update station",
        description = "Updates an existing railway station's information"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Station updated successfully",
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = station.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Station not found"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid station data provided"
        )
    })
    @PutMapping("/{id}")
    public ResponseEntity<station> updateStation(
        @Parameter(description = "ID of the station to update", required = true)
        @PathVariable Long id,
        @Parameter(description = "Updated station details", required = true)
        @RequestBody station station
    ) {
        return ResponseEntity.ok(stationService.updateStation(id, station));
    }

    @Operation(
        summary = "Delete station",
        description = "Deletes a railway station from the system"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "Station deleted successfully"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Station not found"
        )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(
        @Parameter(description = "ID of the station to delete", required = true)
        @PathVariable Long id
    ) {
        stationService.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}