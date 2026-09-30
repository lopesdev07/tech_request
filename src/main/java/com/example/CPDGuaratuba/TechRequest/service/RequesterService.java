package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.model.Requester;
import com.example.CPDGuaratuba.TechRequest.model.RequesterDepartment;
import com.example.CPDGuaratuba.TechRequest.repository.RequesterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RequesterService {
    public RequesterService(RequesterRepository repository) {
        this.repository = repository;
    }

    RequesterRepository repository;

    public List<Requester> findRequesters(String name, RequesterDepartment department) {
        return repository.findAll().stream()
                .filter(r -> name == null || r.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(r -> department == null || r.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Requester findRequesterById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No requester found with this id"));
    }

    public Requester saveRequester(Requester requester) {
        return repository.save(requester);
    }

    public void deleteRequesterById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("No requester found with this id");
        }
        repository.deleteById(id);

    }


}
