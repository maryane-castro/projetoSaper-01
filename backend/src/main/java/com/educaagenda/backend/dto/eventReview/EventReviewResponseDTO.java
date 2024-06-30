package com.educaagenda.backend.dto.eventReview;

import java.io.Serializable;
import java.time.LocalDate;

import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;
import com.educaagenda.backend.model.Participante;

public class EventReviewResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Participante participante;
    private Event event;
    private LocalDate review_date;
    private String text;
    private double rate_value;

    public EventReviewResponseDTO(EventReview eventReview) {
        this.id = eventReview.getId();
        this.participante = eventReview.getParticipante();
        this.event = eventReview.getEvent();
        this.review_date = eventReview.getReview_date();
        this.text = eventReview.getText();
        this.rate_value = eventReview.getRate_value();
    }

    public EventReviewResponseDTO() {
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
