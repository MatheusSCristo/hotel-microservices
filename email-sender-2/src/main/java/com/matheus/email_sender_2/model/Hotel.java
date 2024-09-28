package com.matheus.email_sender_2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String cep;
    private String city;
    @OneToMany(mappedBy = "hotel")
    private List<Reservation> reservations = new ArrayList<>();


}