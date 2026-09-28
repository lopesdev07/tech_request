package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.model.Requester;
import com.example.CPDGuaratuba.TechRequest.model.Technician;
import com.example.CPDGuaratuba.TechRequest.repository.RequesterRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RequesterService {
    public RequesterService(RequesterRepository repository) {
        this.repository = repository;
    }

    RequesterRepository repository;

    public Requester findFirstRequesterByName(String name) {
        return repository.findFirstRequesterByName(name)
                .orElseThrow(() -> new NoSuchElementException("No requester found with this name"));
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
            throw new NoSuchElementException("No technician found with this id");
        }
        repository.deleteById(id);

    }


}
