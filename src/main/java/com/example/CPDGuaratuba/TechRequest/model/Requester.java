package com.example.CPDGuaratuba.TechRequest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Requester { // maybe use a valid local government credential or smth like that
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @Enumerated(EnumType.STRING)
    @NotNull
    private RequesterDepartment deparment;
    @OneToMany(mappedBy = "requester")
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

    public RequesterDepartment getDeparment() {
        return deparment;
    }

    public void setDeparment(RequesterDepartment deparment) {
        this.deparment = deparment;
    }


}
