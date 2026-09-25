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

    TechnicianRepository repository;

    public void saveUser(Technician technician) {
        repository.save(technician);
    }

    public List<Technician> filterTechnicianByRole(TechnicianRole role) {
        return repository.findTechnicianByRole(role);
    }

    public Technician findTechnicianByName(String name) {
        return repository.findFirstTechnicianByName(name).orElse(null);

    }


}
