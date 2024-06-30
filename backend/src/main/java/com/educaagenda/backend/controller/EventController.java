package com.educaagenda.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaagenda.backend.dto.event.EventRequestDTO;
import com.educaagenda.backend.dto.event.EventResponseDTO;
import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        return eventService.findById(id);
    }

    @GetMapping
    public List<EventResponseDTO> findAll() {

        List<Event> list = eventService.findAll();
        return list.stream().map(EventResponseDTO::new).toList();
    }

    @GetMapping("/startDate/{startDate}")
    public ResponseEntity<Object> findAllByStartData(
            @PathVariable(name = "startDate") LocalDate startDate) {
        return eventService.findAllByData(startDate);
    }

    @PostMapping
    public EventResponseDTO save(@RequestBody @Valid EventRequestDTO eventRequestDTO) {
        return eventService.save(eventRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody EventRequestDTO eventRequestDTO) {
        return eventService.update(id, eventRequestDTO);
    }

    @PutMapping("score/{eventId}")
    public EventResponseDTO saveScore(
            @PathVariable(name = "eventId") Long eventId) {
        return eventService.saveScore(eventId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
        return eventService.delete(id);
    }

    @PostMapping("participantes/{event_id}/{participante_id}")
    public ResponseEntity<Object> salvar_participantes(
            @PathVariable(name = "event_id") Long event_id,
            @PathVariable(name = "participante_id") Long participante_id) {

        return eventService.salvar_participantes(event_id, participante_id);
    }

}
