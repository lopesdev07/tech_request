package com.example.CPDGuaratuba.TechRequest.repository;

import com.example.CPDGuaratuba.TechRequest.model.TechnicianRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CPDGuaratuba.TechRequest.model.Technician;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    List<Technician> findTechnicianByName(String name);

    List<Technician> findTechnicianByRole(TechnicianRole role);

}
