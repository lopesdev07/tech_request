package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.model.Technician;
import com.example.CPDGuaratuba.TechRequest.model.TechnicianRole;
import com.example.CPDGuaratuba.TechRequest.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TechnicianService {

    public TechnicianService(TechnicianRepository repository){
        this.repository = repository;
    }

    TechnicianRepository repository;

    public Technician saveTechnician(Technician technician) {
        return repository.save(technician);
    }
    
    public Technician findTechnicianById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No technician found with this id"));
    }

    public List<Technician> filterTechnicianByRole(TechnicianRole role) {
        return repository.findTechnicianByRole(role);
    }

    public Technician findTechnicianByName(String name) {
        return repository.findFirstTechnicianByName(name)
                .orElseThrow(() -> new NoSuchElementException("No technician found with this name"));
    }

    public void deleteTechnicianById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("No technician found with this id");
        }
        repository.deleteById(id);
    }

}
