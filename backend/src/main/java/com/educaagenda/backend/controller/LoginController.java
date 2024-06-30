// package com.educaagenda.backend.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.educaagenda.backend.dto.participante.ParticipanteRequestDTO;
// import com.educaagenda.backend.service.LoginService;

// @RestController
// @RequestMapping("/login")
// public class LoginController {

//     @Autowired
//     LoginService loginService;

//     @GetMapping("/find/{email}")
//     public ResponseEntity<Object> findParticipanteByEmail(
//         @PathVariable(name = "email") String email) {
//         return loginService.findParticipanteByEmail(email);
//     }    

//     @GetMapping("/{email}")
//     public ResponseEntity<Object> login(
//         @PathVariable(name = "email") String email,
//         @RequestBody ParticipanteRequestDTO participanteRequestDTO) {
//         return loginService.login(email, participanteRequestDTO);         
//     }
    
// }
