package com.educaagenda.backend.service;

import java.util.regex.Pattern;

public class EmailValidatorService {
    
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }
    
}
