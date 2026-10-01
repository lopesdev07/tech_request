package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.dto.TicketAssignRequest;
import com.example.CPDGuaratuba.TechRequest.dto.TicketCreateRequest;
import com.example.CPDGuaratuba.TechRequest.dto.TicketStatusUpdateRequest;
import com.example.CPDGuaratuba.TechRequest.model.Requester;
import com.example.CPDGuaratuba.TechRequest.model.Technician;
import com.example.CPDGuaratuba.TechRequest.model.Ticket;
import com.example.CPDGuaratuba.TechRequest.model.TicketStatus;
import com.example.CPDGuaratuba.TechRequest.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketService {

    private final TicketRepository repository;
    private final RequesterService requesterService;
    private final TechnicianService technicianService;

    public TicketService(TicketRepository repository, RequesterService requesterService, TechnicianService technicianService) {
        this.repository = repository;
    this.requesterService = requesterService;
    this.technicianService = technicianService;}

    public Ticket createTicket(TicketCreateRequest request) {
        Requester requester = requesterService.findRequesterById(request.requesterId());

        Ticket ticket = new Ticket();
        ticket.setSubject(request.subject());
        ticket.setDescription(request.description());
        ticket.setRequester(requester);
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setOpenedAt(LocalDateTime.now());

        return repository.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No ticket found with this id"));
    }

    public List<Ticket> filterTicketByStatus(TicketStatus status) {
        if (status != null) {
            return repository.findTicketByStatus(status);
        }
        return repository.findAll();
    }

    public void ensureTicketIsNotClosed(Ticket ticket) {
            if (ticket.getStatus() == TicketStatus.CLOSED) {
                throw new IllegalArgumentException("Can't change technician when ticket status is CLOSED");
            }
    }

    public Ticket assignTechnician(Long ticketId, TicketAssignRequest request) {
            Ticket ticket = findTicketById(ticketId);
            ensureTicketIsNotClosed(ticket);
            Technician technician = technicianService.findTechnicianById(request.technicianId());
            ticket.setTechnician(technician);
            ticket.setStatus(TicketStatus.ONGOING);
            return repository.save(ticket);
    }

    public Ticket updateTicketStatus(Long ticketId, TicketStatusUpdateRequest ticketStatusUpdate) {
        Ticket ticket = findTicketById(ticketId);
        if (ticketStatusUpdate.status() == TicketStatus.CLOSED) {
            ticketStatusUpdate.status()
        }

    }


}
