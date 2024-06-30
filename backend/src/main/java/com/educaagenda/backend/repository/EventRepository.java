package com.educaagenda.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educaagenda.backend.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    List<Event> findAllByStartDate(LocalDate startDate);
    
}
