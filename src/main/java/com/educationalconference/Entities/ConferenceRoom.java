package com.educationalconference.Entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

    @OneToMany(mappedBy = "conferenceRoom")
    private Set<Presentation> presentations = new HashSet<>();

    public ConferenceRoom() {}

    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}