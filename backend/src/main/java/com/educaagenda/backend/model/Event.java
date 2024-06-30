package com.educaagenda.backend.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String campus;
    private LocalDate startDate;
    private LocalDate endDate;

    @Column(length = 2000)
    private String details;
    
    @Column(length = 2000)
    private String folder;
    private double score;
    
     @JsonIgnore
    @ManyToMany(targetEntity = Participante.class)
    @JoinTable(
        name = "participantes_events",                
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "participante_id"))
    Set<Participante> participantes;

    @OneToMany(mappedBy = "event")
    Set<EventReview> reviews;
    
    public Event() {
    }    

    public Event(long id, String name, String campus, LocalDate startDate, LocalDate endDate, String details, String folder,
            Set<Participante> participantes, Set<EventReview> reviews, double score) {
        this.id = id;
        this.name = name;
        this.campus = campus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.details = details;
        this.folder = folder;
        this.score = score;
        this.participantes = participantes;
        this.reviews = reviews;
    }       

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }    

    public Set<EventReview> getReviews() {
        return reviews;
    }

    public void setReviews(Set<EventReview> reviews) {
        this.reviews = reviews;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }    
}
