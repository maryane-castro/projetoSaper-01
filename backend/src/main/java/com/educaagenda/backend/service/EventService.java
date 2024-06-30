package com.educaagenda.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.educaagenda.backend.dto.event.EventRequestDTO;
import com.educaagenda.backend.dto.event.EventResponseDTO;
import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.Participante;
import com.educaagenda.backend.repository.EventRepository;
import com.educaagenda.backend.repository.ParticipanteRepository;

import jakarta.transaction.Transactional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public ResponseEntity<Object> findById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Evento não encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(new EventResponseDTO(event));
    }

    @Transactional
    public EventResponseDTO save(EventRequestDTO eventRequestDTO) {
        Event event = eventRequestDTO.toEvent();
        return new EventResponseDTO(eventRepository.save(event));
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Evento não Encontrado"));
        eventRepository.delete(event);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, EventRequestDTO eventRequestDTO) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Evento não encontrado"));

        // Modificar
        if (eventRequestDTO.getName() != null) {
            event.setName(eventRequestDTO.getName());
        }

        if (eventRequestDTO.getStartDate() != null) {
            event.setStartDate(eventRequestDTO.getStartDate());
        }

        if (eventRequestDTO.getEndDate() != null) {
            event.setEndDate(eventRequestDTO.getEndDate());
        }

        if (eventRequestDTO.getDetails() != null) {
            event.setDetails(eventRequestDTO.getDetails());
        }

        if (eventRequestDTO.getFolder() != null) {
            event.setFolder(eventRequestDTO.getFolder());
        }

        // Salvar
        return ResponseEntity.status(HttpStatus.OK).body(new EventResponseDTO(eventRepository.save(event)));

    }

    public ResponseEntity<Object> salvar_participantes(Long event_id, Long participante_id) {

        Optional<Event> eventOptional = eventRepository.findById(event_id);
        if (eventOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
        }

        Optional<Participante> participanteOptional = participanteRepository.findById(participante_id);
        if (participanteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participante não encontrado");
        }

        Event event = eventOptional.get();
        Participante participante = participanteOptional.get();

        if (participante.getEvents().contains(event)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Participante já cadastrado no Evento");
        }

        event.getParticipantes().add(participante);

        return ResponseEntity.status(HttpStatus.CREATED).body(new EventResponseDTO(eventRepository.save(event)));
    }    

    @Transactional
    public EventResponseDTO saveScore(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Evento não encontrado"));

        // serviço para atualizar as atualizações
        AtualizarScoreService atualizarScoreService = new AtualizarScoreService();
        atualizarScoreService.atualizarScore(event);        

        return new EventResponseDTO(eventRepository.save(event));
    }

    public ResponseEntity<Object> findAllByData(LocalDate startDate) {
        return ResponseEntity.status(HttpStatus.OK).body(eventRepository.findAllByStartDate(startDate));        
    }
}