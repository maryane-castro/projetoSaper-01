package com.educaagenda.backend.dto.eventReview;

import java.io.Serializable;
import java.time.LocalDate;

import com.educaagenda.backend.model.EventReview;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class EventReviewRequestDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Long participanteId;
    private Long eventId;
    private LocalDate review_date;
    private String text;
    
    @Min(
        value =  1,
        message = "O valor da avaliação deve ser no mínimo 1")
    @Max(
            value =  10,
            message = "O valor da avaliação deve ser no maximo 10")
    private double rate_value;    
    
    public EventReviewRequestDTO() {
    }
  
    public EventReviewRequestDTO(Long id, Long participanteId, Long eventId, LocalDate review_date, String text, double rate_value) {
        this.id = id;
        this.participanteId = participanteId;
        this.eventId = eventId;
        this.review_date = review_date;
        this.text = text;
        this.rate_value = rate_value;
    }    

    public EventReview toEventReview() {
        EventReview eventReview = new EventReview();    
        eventReview.setReview_date(LocalDate.now());
        eventReview.setText(text);
        eventReview.setRate_value(rate_value);      
        return eventReview;
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
    }

    public LocalDate getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDate review_date) {
        this.review_date = review_date;
    }

    
}
