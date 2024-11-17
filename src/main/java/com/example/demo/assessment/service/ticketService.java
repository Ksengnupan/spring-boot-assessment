package com.example.demo.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.assessment.model.ticket;
import com.example.demo.assessment.repository.ticketRepository;

@Service

public class ticketService {
    private final ticketRepository ticketRepository;

    public ticketService(ticketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public ticket createTicket(ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public ticket updateTicket(Long id, ticket updatedTicket) {
        ticket ticket = getTicketById(id);
        ticket.setPassengerName(updatedTicket.getPassengerName());
        ticket.setSeatNumber(updatedTicket.getSeatNumber());
        ticket.setTrainId(updatedTicket.getTrainId());
        ticket.setDepartureDate(updatedTicket.getDepartureDate());
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
