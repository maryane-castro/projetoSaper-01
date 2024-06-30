// package com.educaagenda.backend.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.educaagenda.backend.dto.participante.ParticipanteRequestDTO;
// import com.educaagenda.backend.repository.ParticipanteRepository;

// @Service
// public class LoginService {

//     @Autowired
//     ParticipanteRepository participanteRepository;
    
//     public ResponseEntity<Object> findParticipanteByEmail(String email) {
//        return null; 
//         // //Participante participante = participanteRepository.findByEmail(email);        
//         // Participante participante = participanteRepository.findByEmail(email);        

//         // if (participante == null) {
//         //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Participante não localizado(a) no servidor!");
//         // }        
        
//         // return ResponseEntity.status(HttpStatus.OK).body(new ParticipanteResponseDTO(participante));            

//     }    

//     public ResponseEntity<Object> login(String email, ParticipanteRequestDTO participanteRequestDTO) {
//         return null;
//         // Participante participante = participanteRepository.findByEmail(email);        
//         // if (participante == null) {
//         //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Participante não localizado(a) no servidor!");
//         // }

//         // //vem do banco - vem hash
//         // var encodedPassword  = participante.getPassword(); 
//         // var rawPassword = participanteRequestDTO.getPassword();     

//        // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();        
//         //if (passwordEncoder.matches(rawPassword, encodedPassword)) {
//             //return ResponseEntity.status(HttpStatus.OK).body(new ParticipanteResponseDTO(participante));                 
//         //}        
//         //else{

//           //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password inválida para o participante " + participante.getEmail());
//         //}  
        

//     }   
    
// }
