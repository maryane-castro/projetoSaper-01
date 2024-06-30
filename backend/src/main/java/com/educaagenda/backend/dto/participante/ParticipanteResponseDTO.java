package com.educaagenda.backend.dto.participante;

import java.io.Serializable;
import java.util.Set;

import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;
import com.educaagenda.backend.model.Participante;

public class ParticipanteResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String tipo;
    private String avatar;
    private String email;
    private String password;
    private Set<Event> events;
    private Set<EventReview> reviews;

    public ParticipanteResponseDTO() { }

    public ParticipanteResponseDTO(Participante participante) {
        id = participante.getId();
        name = participante.getName();
        avatar = participante.getAvatar();
        tipo = participante.getTipo();
        email = participante.getEmail();        
        password = participante.getPassword();
        events = participante.getEvents();
        reviews = participante.getReviews();
    }    

    public ParticipanteResponseDTO(Long id, String name, String tipo, String avatar, String email, String password, Set<Event> events,
            Set<EventReview> reviews) {
        this.id = id;
        this.name = name;
        this.tipo = tipo;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.events = events;
        this.reviews = reviews;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<EventReview> getReviews() {
        return reviews;
    }

    public void setReviews(Set<EventReview> reviews) {
        this.reviews = reviews;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
}