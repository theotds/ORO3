package com.educationalconference.Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String role; // scientist, student, organizer
    private String country;

    @OneToMany(mappedBy = "person")
    private Set<Presentation> presentations;

    public Person(String firstName, String lastName, String role, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.country = country;
    }

    public Person() {}

    public String getFirstName() {
        return firstName;
    }

    public Set<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }
}