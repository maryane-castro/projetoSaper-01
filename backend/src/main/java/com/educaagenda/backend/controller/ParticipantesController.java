package com.educaagenda.backend.controller;

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

import com.educaagenda.backend.dto.participante.ParticipanteRequestDTO;
import com.educaagenda.backend.dto.participante.ParticipanteResponseDTO;
import com.educaagenda.backend.model.Participante;
import com.educaagenda.backend.repository.RoleRepository;
import com.educaagenda.backend.service.ParticipanteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/participantes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParticipantesController {

    @Autowired
    ParticipanteService participanteService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id) {
        return participanteService.findById(id);
    }

    @GetMapping
    public List<ParticipanteResponseDTO> findAll() {
        List<Participante> list = participanteService.findAll();
        return list.stream().map(ParticipanteResponseDTO::new).toList();
    }

    @PostMapping
    public ParticipanteResponseDTO save(@RequestBody @Valid ParticipanteRequestDTO participanteRequestDTO) {
        return participanteService.save(participanteRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,            
            @RequestBody @Valid ParticipanteRequestDTO participanteRequestDTO) {
        return participanteService.update(id, participanteRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
        return participanteService.delete(id);
    }
}
