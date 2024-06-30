package com.educaagenda.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;

@Repository
public interface EventReviewRepository extends JpaRepository<EventReview, Long>{

    // procura por Eventos que já receberam Avaliações        
    List<EventReview> findByEvent(Event event);
}
