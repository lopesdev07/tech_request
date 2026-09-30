package com.example.CPDGuaratuba.TechRequest.controller;

import com.example.CPDGuaratuba.TechRequest.dto.TicketAssignRequest;
import com.example.CPDGuaratuba.TechRequest.dto.TicketCreateRequest;
import com.example.CPDGuaratuba.TechRequest.dto.TicketResponse;
import com.example.CPDGuaratuba.TechRequest.model.Ticket;
import com.example.CPDGuaratuba.TechRequest.model.TicketStatus;
import com.example.CPDGuaratuba.TechRequest.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(
            @Valid @RequestBody TicketCreateRequest request,
            UriComponentsBuilder uriBuilder) {

        Ticket saved = service.createTicket(request);

        URI location = uriBuilder.path("/v1/tickets/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(TicketResponse.from(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> findTicketById(@PathVariable Long id) {
        Ticket ticket = service.findTicketById(id);
        return ResponseEntity.ok(TicketResponse.from(ticket));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> findTickets(@RequestParam(required = false) TicketStatus status) {

        List<TicketResponse> response = service.filterTicketByStatus(status).stream()
                .map(TicketResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/technician")
    public ResponseEntity<TicketResponse> assignTechnician(@PathVariable Long id, @Valid @RequestBody TicketAssignRequest request) {
            Ticket ticket = service.assignTechnician(id, request);

            return ResponseEntity.ok(TicketResponse.from(ticket));
    }
}
