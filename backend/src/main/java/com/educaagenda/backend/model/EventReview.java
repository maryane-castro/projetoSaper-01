package com.educaagenda.backend.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity()
public class EventReview implements  Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "event_id")
    Event event;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "participante_id")
    Participante participante;

    private LocalDate review_date;
    private String text;
    private double rate_value;
    
    public EventReview() {}

    public EventReview(Long id, Event event, Participante participante, LocalDate review_date, String text, double rate_value) {
        this.id = id;
        this.event = event;
        this.participante = participante;
        this.review_date = review_date;
        this.text = text;
        this.rate_value = rate_value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }   

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRate_value() {
        return rate_value;
    }

    public void setRate_value(double rate_value) {
        this.rate_value = rate_value;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public LocalDate getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDate review_date) {
        this.review_date = review_date;
    }

    

}
