package com.example.CPDGuaratuba.TechRequest.repository;

import com.example.CPDGuaratuba.TechRequest.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
