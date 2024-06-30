// package com.educaagenda.backend.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class WebSecuriry extends WebSecurityConfigurerAdapter {

//     @Autowired
//     AuthenticatorService authenticatorService;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.httpBasic();
//         http.authorizeHttpRequests()                
//             .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
//             .anyRequest().authenticated();
//         http.csrf().disable();
//          /*
//       ROLE_ADMIN,
//       ROLE_ORGANIZADOR,
//       ROLE_ACADEMICO
//      */
//     }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//         // as 4 linhas abaixo, são para criar um usuário "em memoria" para poder fazer
//         // requisições
//         // auth
//         // .inMemoryAuthentication()
//         // .withUser("educameet") // Username
//         // .password("educameet") // Password
//         // .roles("USER");

//         // autenticação pelos usuaarios (participantes) cadastrados no sistema
//         auth
//                 .userDetailsService(authenticatorService)
//                 .passwordEncoder(passwordEncoder());
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
