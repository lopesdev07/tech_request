package com.example.CPDGuaratuba.TechRequest.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    @Enumerated(EnumType.STRING)
    @NotBlank
    private TechnicianRole role;
    @OneToMany(mappedBy = "technician")
    private List<Ticket> tickets;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public TechnicianRole getRole() {
        return role;
    }
    public void setRole(TechnicianRole role) {
        this.role = role;
    }
}
