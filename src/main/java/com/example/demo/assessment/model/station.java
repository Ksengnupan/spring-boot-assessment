package com.example.demo.assessment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
@Schema(description = "Railway Station Information")
public class station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Station ID")
    private Long id;

    @NotBlank
    @Schema(description = "Station Code", example = "BKK01")
    private String stationCode;

    @NotBlank
    @Schema(description = "Station Name", example = "Siam Station")
    private String stationName;

    @NotBlank
    @Schema(description = "Station Location", example = "Bangkok, Thailand")
    private String location;

    @Schema(description = "Contact Information", example = "123-456-7890")
    private String contactInfo;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}