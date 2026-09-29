package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.model.Technician;
import com.example.CPDGuaratuba.TechRequest.model.TechnicianRole;
import com.example.CPDGuaratuba.TechRequest.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TechnicianService {

    public TechnicianService(TechnicianRepository repository){
        this.repository = repository;
    }

    final TechnicianRepository repository;

    public Technician saveTechnician(Technician technician) {
        return repository.save(technician);
    }

    public Technician findTechnicianById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No technician found with this id"));
    }

    public List<Technician> findTechnicians(String name, TechnicianRole role) {
        if (name != null && role != null) {
            throw new IllegalArgumentException(
                    "Name and role filters cannot be used together"
            );
        }
        if (name != null) {
            return findTechnicianByName(name);
        }
        if (role != null) {
            return filterTechnicianByRole(role);
        }
        return repository.findAll();
    }

    public List<Technician> filterTechnicianByRole(TechnicianRole role) {
        return repository.findTechnicianByRole(role);
    }

    public List<Technician> findTechnicianByName(String name) {
        return repository.findTechnicianByName(name);
    }

    public void deleteTechnicianById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("No technician found with this id");
        }
        repository.deleteById(id);
    }

}
