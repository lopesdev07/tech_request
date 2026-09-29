package com.example.CPDGuaratuba.TechRequest.repository;

import com.example.CPDGuaratuba.TechRequest.model.Requester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequesterRepository extends JpaRepository<Requester, Long> {
}
