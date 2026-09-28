package com.example.CPDGuaratuba.TechRequest.service;

import com.example.CPDGuaratuba.TechRequest.repository.RequesterRepository;
import org.springframework.stereotype.Service;

@Service
public class RequesterService {
    public RequesterService(RequesterRepository repository) {
        this.repository = repository;
    }

    RequesterRepository repository;


}
