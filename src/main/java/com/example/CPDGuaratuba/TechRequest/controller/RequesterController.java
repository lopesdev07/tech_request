package com.example.CPDGuaratuba.TechRequest.controller;

import com.example.CPDGuaratuba.TechRequest.model.Requester;
import com.example.CPDGuaratuba.TechRequest.model.RequesterDepartment;
import com.example.CPDGuaratuba.TechRequest.service.RequesterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/requesters")
public class RequesterController {

    final RequesterService service;

    public RequesterController(RequesterService service) {
        this.service = service;
    }

    @GetMapping
    List<Requester> findRequesters(@RequestParam(required = false) String name, @RequestParam(required = false) RequesterDepartment department) {
        return service.findRequesters(name, department);
    }

    @GetMapping("/{id}")
    Requester findRequesterById(@PathVariable Long id) {
        return service.findRequesterById(id);
    }

    @PostMapping
    ResponseEntity<Requester> saveRequester(@Valid @RequestBody Requester requester) {
        Requester saved = service.saveRequester(requester);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRequesterById(@PathVariable Long id) {
        service.deleteRequesterById(id);
        return ResponseEntity.noContent().build();
    }
}
