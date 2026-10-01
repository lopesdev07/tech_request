package com.example.CPDGuaratuba.TechRequest.controller;

import com.example.CPDGuaratuba.TechRequest.model.Technician;
import com.example.CPDGuaratuba.TechRequest.model.TechnicianRole;
import com.example.CPDGuaratuba.TechRequest.service.TechnicianService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/technicians")
public class TechnicianController {

    final TechnicianService service;

    public TechnicianController(TechnicianService service) {
        this.service = service;
    }

    @GetMapping
    List<Technician> findTechnicians(@RequestParam(required = false) String name, @RequestParam(required = false) TechnicianRole role) {
        return service.findTechnicians(name, role);
    }

    @GetMapping("/{id}")
    Technician findTechnicianById(@PathVariable Long id) {
        return service.findTechnicianById(id);
    }

    @PostMapping
    ResponseEntity<Technician> saveTechnician(@Valid @RequestBody Technician technician, UriComponentsBuilder uriBuilder) {
        Technician saved = service.saveTechnician(technician);

        URI location = uriBuilder.path("/v1/technicians/{id}")
                .buildAndExpand(technician.getId())
                .toUri();


        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTechnicianById(@PathVariable Long id) {
        service.deleteTechnicianById(id);
        return ResponseEntity.noContent().build();
    }











}
