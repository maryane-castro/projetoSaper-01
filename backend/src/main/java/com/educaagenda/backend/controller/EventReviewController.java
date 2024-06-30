package com.educaagenda.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaagenda.backend.dto.eventReview.EventReviewRequestDTO;
import com.educaagenda.backend.dto.eventReview.EventReviewResponseDTO;
import com.educaagenda.backend.service.EventReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventReviewController {

    @Autowired
    EventReviewService eventReviewService;

    @GetMapping("/event/{event_id}")
    public ResponseEntity<Object> findByEventId(@PathVariable(name = "event_id") Long id) {
        return eventReviewService.findByEvent_id(id);
    }

    @GetMapping("/{eventReview_id}")
    public ResponseEntity<Object> findByEventReviewId(@PathVariable(name = "eventReview_id") Long id) {
        return eventReviewService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return eventReviewService.findAll();
    }     

    @PostMapping
    public EventReviewResponseDTO saveReview(@RequestBody @Valid EventReviewRequestDTO eventReviewRequestDTO) {
        return eventReviewService.saveReview(eventReviewRequestDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid EventReviewRequestDTO eventReviewRequestDTO){
        return eventReviewService.update(id, eventReviewRequestDTO);
    }
}
