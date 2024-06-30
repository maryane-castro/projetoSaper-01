package com.educaagenda.backend.dto.participante;

import java.io.Serializable;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;
import com.educaagenda.backend.model.Participante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ParticipanteRequestDTO implements Serializable{
    @NotNull(message = "Nome deve ser preenchido")
    @Size(min = 5, max = 50, message = "Nome deve ter entre 5 e 50 caracteres")
    private String name;

    @NotNull(message = "Tipo deve ser ORGANIZADOR OU ACADEMICO")    
    private String tipo;

    private String avatar;

    @NotNull(message = "E-mail deve ser preenchido")
    @Email(message = "Formado de e-mail incorreto")
    private String email; 
    
    @NotNull(message = "Nome deve ser preenchido")
    @Size(min = 4, max = 10, message = "Password deve ter entre 4 e 10 caracteres")
    private String password;

    private Set<Event> events;
    private Set<EventReview> eventReviews;

    public ParticipanteRequestDTO() {}
 
    public Participante toParticipante() {
        
        password = new BCryptPasswordEncoder().encode(password);

        Participante participante = new Participante();
        participante.setName(name);
        participante.setTipo(tipo);
        participante.setAvatar(avatar);
        participante.setEmail(email);
        participante.setPassword(password);
        participante.setEvents(events);
        participante.setReviews(eventReviews);
        return participante;
    }

    public ParticipanteRequestDTO(String name, String tipo, String avatar, String email, String password) {
        this.name = name;
        this.tipo = tipo;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
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

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<EventReview> getEventReviews() {
        return eventReviews;
    }

    public void setEventReviews(Set<EventReview> eventReviews) {
        this.eventReviews = eventReviews;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }    
    
}
