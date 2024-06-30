package com.educaagenda.backend.dto.event;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;
import com.educaagenda.backend.model.Participante;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EventRequestDTO  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;

    @NotNull(message = "Nome do Evento deve ser preenchido")
    @Size(min = 5, max = 50, message = "Nome do Evento deve ter entre 5 e 50 caracteres")
    private String name;

    private String campus;

    //@NotNull(message = "Data de início do evento deve ser preenchida")    
    @FutureOrPresent(message = "Data de início do evento deve ser preenchida e não pode ser menor que a data atual")    
    private LocalDate startDate;

    @FutureOrPresent(message = "Data de término do evento deve ser preenchida e não pode ser menor que a data atual")    
    private LocalDate endDate;

    @NotNull(message = "Detalhe deve ser preenchido")
    @Size(min = 10, max = 100, message = "Nome do Evento deve ter entre 10 e 100 caracteres")
    private String details;
    
    @NotNull(message = "Folder deve ser preenchido")
    private String folder;
    
    private double score;
    
    private Set<Participante> participantes;
    private Set<EventReview> reviews;

    public EventRequestDTO() {
    }

    public EventRequestDTO(Long id, String name, String campus, LocalDate startDate, LocalDate endDate, String details, String folder,
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

    public Long getId() {
        return id;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Event toEvent() {
        Event event = new Event();
        event.setName(name);
        event.setCampus(campus);
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setDetails(details);
        event.setFolder(folder);
        event.setScore(score);    
        event.setParticipantes(participantes);
        event.setReviews(reviews);
        return event;
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
