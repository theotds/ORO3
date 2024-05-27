package com.educationalconference.Entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ConferenceRoom conferenceRoom;

    @OneToMany(mappedBy = "presentation")
    private Set<Participation> participations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;



    public Presentation() {}

    public Presentation(String title) {
        this.title = title;
    }

    public Presentation(String title, ConferenceRoom conferenceRoom) {
        this.title = title;
        this.conferenceRoom = conferenceRoom;
    }

    public void setPerson(Person person) {
        this.person=person;
    }
}