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

import com.example.demo.assessment.model.ticket;
import com.example.demo.assessment.service.ticketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Ticket Management", description = "APIs for managing railway tickets")
public class ticketController {
    private final ticketService ticketService;

    public ticketController(ticketService ticketService) {
        this.ticketService = ticketService;
    }

    @Operation(summary = "Get all tickets")
    @ApiResponse(responseCode = "200", description = "List of all tickets retrieved")
    @GetMapping
    public ResponseEntity<List<ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @Operation(summary = "Get ticket by ID")
    @ApiResponse(responseCode = "200", description = "Ticket found")
    @ApiResponse(responseCode = "404", description = "Ticket not found")
    @GetMapping("/{id}")
    public ResponseEntity<ticket> getTicketById(
            @Parameter(description = "Ticket ID") 
            @PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @Operation(summary = "Create new ticket")
    @ApiResponse(responseCode = "201", description = "Ticket created successfully")
    @PostMapping
    public ResponseEntity<ticket> createTicket(
            @Parameter(description = "Ticket details") 
            @RequestBody ticket ticket) {
        return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.CREATED);
    }

    @Operation(summary = "Update ticket")
    @ApiResponse(responseCode = "200", description = "Ticket updated successfully")
    @ApiResponse(responseCode = "404", description = "Ticket not found")
    @PutMapping("/{id}")
    public ResponseEntity<ticket> updateTicket(
            @Parameter(description = "Ticket ID") 
            @PathVariable Long id,
            @Parameter(description = "Updated ticket details") 
            @RequestBody ticket ticket) {
        return ResponseEntity.ok(ticketService.updateTicket(id, ticket));
    }

    @Operation(summary = "Delete ticket")
    @ApiResponse(responseCode = "204", description = "Ticket deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(
            @Parameter(description = "Ticket ID") 
            @PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}