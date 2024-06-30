package com.educaagenda.backend.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.educaagenda.backend.model.Participante;
import com.educaagenda.backend.repository.ParticipanteRepository;

@Service
public class AuthenticatorService implements UserDetailsService
{

    @Autowired
    ParticipanteRepository participanteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Participante> participanteOptional = participanteRepository.findByEmail(username);
        if (participanteOptional.isPresent()) {
            return participanteOptional.get();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
    }
    
}
