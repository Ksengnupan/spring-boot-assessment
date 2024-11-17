package com.example.demo.assessment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trainNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String originStation;
    private String destinationStation;
    private int seatCapacity;
    private double ticketPrice;

    //getters and setters
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
