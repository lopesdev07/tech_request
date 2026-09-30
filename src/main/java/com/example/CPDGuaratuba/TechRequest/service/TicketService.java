package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.dto.TicketCreateRequest;
import com.example.CPDGuaratuba.TechRequest.model.Requester;
import com.example.CPDGuaratuba.TechRequest.model.Ticket;
import com.example.CPDGuaratuba.TechRequest.model.TicketStatus;
import com.example.CPDGuaratuba.TechRequest.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class TicketService {

    private final TicketRepository repository;
    private final RequesterService requesterService;

    public TicketService(TicketRepository repository, RequesterService requesterService) {
        this.repository = repository;
    this.requesterService = requesterService;}

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




}
