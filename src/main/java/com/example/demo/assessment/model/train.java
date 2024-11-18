package com.example.demo.assessment.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Schema(description = "Train Information")
public class train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the train", example = "1")
    private Long id;

    @NotBlank(message = "Train number is required")
    @Schema(description = "Unique train number", example = "12345")
    private String trainNumber;

    @NotNull(message = "Departure time is required")
    @Future(message = "Departure time must be in the future")
    @Schema(description = "Train departure time", example = "2024-12-25T08:00:00")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time is required")
    @Future(message = "Arrival time must be in the future")
    @Schema(description = "Train arrival time", example = "2024-12-25T12:00:00")
    private LocalDateTime arrivalTime;

    @NotBlank(message = "Origin station is required")
    @Schema(description = "Origin station of the train", example = "Victory Monument")
    private String originStation;

    @NotBlank(message = "Destination station is required")
    @Schema(description = "Destination station of the train", example = "Hua Lamphong")
    private String destinationStation;

    @Min(value = 1, message = "Seat capacity must be at least 1")
    @Schema(description = "Total number of seats available on the train", example = "200")
    private int seatCapacity;

    @Min(value = 0, message = "Ticket price must be non-negative")
    @Schema(description = "Price of a ticket", example = "62.00")
    private double ticketPrice;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getOriginStation() {
        return originStation;
    }

    public void setOriginStation(String originStation) {
        this.originStation = originStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
