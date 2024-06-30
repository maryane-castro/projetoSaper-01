package com.educaagenda.backend.service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.educaagenda.backend.dto.eventReview.EventReviewRequestDTO;
import com.educaagenda.backend.dto.eventReview.EventReviewResponseDTO;
import com.educaagenda.backend.model.Event;
import com.educaagenda.backend.model.EventReview;
import com.educaagenda.backend.model.Participante;
import com.educaagenda.backend.repository.EventRepository;
import com.educaagenda.backend.repository.EventReviewRepository;
import com.educaagenda.backend.repository.ParticipanteRepository;

import jakarta.transaction.Transactional;

@Service
public class EventReviewService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    @Autowired
    EventReviewRepository eventReviewRepository;

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                eventReviewRepository.findAll().stream().map((eventReview) -> new EventReviewResponseDTO(eventReview))
                        .toList());
    }

    // procura por Eventos que já receberam Avaliações
    public ResponseEntity<Object> findByEvent_id(Long event_id) {

        Optional<Event> eventOptional = eventRepository.findById(event_id);
        if (eventOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
        }

        Event event = eventOptional.get();
        var resposta = eventReviewRepository.findByEvent(event).stream()
                .map((retorno) -> new EventReviewResponseDTO(retorno)).toList();

        if (resposta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este Evento ainda não recebeu nenhuma avaliação");
        }

        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @Transactional
    public EventReviewResponseDTO saveReview(EventReviewRequestDTO eventReviewRequestDTO) {

        EventReview eventReview = eventReviewRequestDTO.toEventReview();

        // localizar participante pelo eventReviewRequestDTO
        Participante participante = participanteRepository.findById(eventReviewRequestDTO.getParticipanteId())
                .orElseThrow(() -> new NoSuchElementException("Participante não encontrado"));

        // TODO ALTERAR PARA PEGAR OS PARTICIPANTES DESSE EVENTO
        
        //var participante_id = eventReviewRepository.findParticipanteById(eventReviewRequestDTO.getParticipanteId());
        //var teste = participante_id.getParticipante().getId();
        // if (participante_id != null) {
        // throw new ConflictStoreException("Este participante já votou neste evento!");
        // }

        // localizar evento pelo eventReviewRequestDTO
        Event event = eventRepository.findById(eventReviewRequestDTO.getEventId())
                .orElseThrow(() -> new NoSuchElementException("Evento não encontrado"));

        if (!event.getParticipantes().contains(participante)) {
            throw new NoSuchElementException("Este Participante não está inscrito neste Evento!");
        }

        eventReview.setParticipante(participante);
        eventReview.setEvent(event);

        eventReviewRepository.save(eventReview);

        // atualiza nota avaliação
        AtualizarScoreService atualizarScoreService = new AtualizarScoreService();
        atualizarScoreService.atualizarScore(event);

        return new EventReviewResponseDTO(eventReview);
        // return new EventReviewResponseDTO(eventReviewRepository.save(eventReview));
    }

    public ResponseEntity<Object> findById(Long id) {
        EventReview eventReview = eventReviewRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Avaliação não encontrada"));
        return ResponseEntity.status(HttpStatus.OK).body(new EventReviewResponseDTO(eventReview));
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, EventReviewRequestDTO eventReviewRequestDTO) {

        EventReview eventReview = eventReviewRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Avaliação não encontrada"));

        Event event = eventRepository.findById(eventReview.getEvent().getId())
            .orElseThrow(() -> new NoSuchElementException("Evento não encontrado"));

        // data do dia
        eventReview.setReview_date(LocalDate.now());

        // texto avaliacao
        if (eventReviewRequestDTO.getText() != null) {
            eventReview.setText(eventReviewRequestDTO.getText());
        }

        // avaliação
        eventReview.setRate_value(eventReviewRequestDTO.getRate_value());

        eventReviewRepository.save(eventReview);

        // atualiza nota avaliação
        AtualizarScoreService atualizarScoreService = new AtualizarScoreService();
        atualizarScoreService.atualizarScore(event);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new EventReviewResponseDTO(eventReview));

    }

}
