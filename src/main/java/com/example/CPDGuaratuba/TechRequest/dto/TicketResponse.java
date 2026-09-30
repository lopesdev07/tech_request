package com.example.CPDGuaratuba.TechRequest.dto;

import com.example.CPDGuaratuba.TechRequest.model.Technician;
import com.example.CPDGuaratuba.TechRequest.model.Ticket;
import com.example.CPDGuaratuba.TechRequest.model.TicketStatus;

import java.time.LocalDateTime;

public record TicketResponse(
        Long id,
        String subject,
        String description,
        TicketStatus status,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        Long requesterId,
        String requesterName,
        Long technicianId,
        String technicianName
) {
    public static TicketResponse from(Ticket ticket) {
        Technician technician = ticket.getTechnician();

        return new TicketResponse(
                ticket.getId(),
                ticket.getSubject(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getOpenedAt(),
                ticket.getClosedAt(),
                ticket.getRequester().getId(),
                ticket.getRequester().getName(),
                technician != null ? technician.getId() : null,
                technician != null ? technician.getName() : null
        );
    }
}