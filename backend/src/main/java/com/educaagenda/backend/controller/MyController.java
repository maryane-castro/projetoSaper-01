package com.educaagenda.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaagenda.backend.model.Participante;
import com.educaagenda.backend.service.ParticipanteService;

@RestController
@RequestMapping("/my")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyController {

    @Autowired
    ParticipanteService participanteService;

    @GetMapping("/participante")
    public ResponseEntity<Object> findParticipante() {
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof Participante participante) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(participanteService.findById(participante.getId()).getBody());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }   

}
