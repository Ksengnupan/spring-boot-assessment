package com.example.demo.assessment.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Schema(description = "Ticket Information")
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Ticket ID")
    private Long id;

    @NotBlank(message = "Passenger name is required")
    @Schema(
        description = "Name of the passenger",
        example = "John"
    )
    private String passengerName;

    @NotBlank(message = "Seat number is required")
    @Schema(
        description = "Seat number assigned",
        example = "B2"
    )
    private String seatNumber;

    @NotNull(message = "Train ID is required")
    @Schema(
        description = "ID of the train",
        example = "1"
    )
    private Long trainId;

    @NotNull(message = "Departure date is required")
    @Future(message = "Departure date must be in the future")
    @Schema(
        description = "Date of departure",
        example = "2024-12-25"
    )
    private LocalDate departureDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}