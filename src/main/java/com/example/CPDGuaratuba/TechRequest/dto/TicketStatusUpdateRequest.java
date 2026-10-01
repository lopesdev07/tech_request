package com.example.CPDGuaratuba.TechRequest.dto;

import com.example.CPDGuaratuba.TechRequest.model.TicketStatus;
import jakarta.validation.constraints.NotNull;

public record TicketStatusUpdateRequest(@NotNull TicketStatus status) {
}
