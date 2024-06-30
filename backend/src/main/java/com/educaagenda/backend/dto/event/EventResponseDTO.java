package com.educaagenda.backend.dto.event;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;
import com.educaagenda.backend.model.Participante;

public class EventResponseDTO  implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;  
    private String name;
    private String campus;
    private LocalDate startDate;
    private LocalDate endDate;
    private String details;
    private String folder;     
    private double score;
    private Set<Participante> participantes;
    private Set<EventReview> reviews;

    public EventResponseDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.campus = event.getCampus();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.details = event.getDetails();
        this.folder = event.getFolder();
        this.score = event.getScore();
        this.participantes = event.getParticipantes();
        this.reviews = event.getReviews();
    }    

    public EventResponseDTO() {
    }
    
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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
