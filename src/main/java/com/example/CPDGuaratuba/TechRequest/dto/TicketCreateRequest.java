package com.example.CPDGuaratuba.TechRequest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketCreateRequest(@NotBlank String subject, @NotBlank String description, @NotNull Long requesterId) {

}
