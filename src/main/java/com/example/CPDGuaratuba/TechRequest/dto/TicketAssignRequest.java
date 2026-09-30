package com.example.CPDGuaratuba.TechRequest.dto;

import jakarta.validation.constraints.NotNull;

public record TicketAssignRequest(@NotNull Long technicianId) {
}
