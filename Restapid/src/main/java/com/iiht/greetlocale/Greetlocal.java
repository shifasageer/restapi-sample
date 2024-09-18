package com.iiht.greetlocale;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetlocal")
public class Greetlocal {
	
//	@GetMapping("/hello")
//    public ResponseEntity<String> greetings(@RequestHeader HttpHeaders headers) {
//        Locale locale = headers.getAcceptLanguageAsLocales().get(0);
//        String greeting = getGreeting(locale);
//        return ResponseEntity.status(HttpStatus.OK).body(greeting);
//    }
//
//    private String getGreeting(Locale locale) {
//        switch (locale.getLanguage()) {
//            case "en":
//                if (locale.getCountry().equals("UK")) {
//                    return "Hello";
//                }
//                break;
//            case "fr":
//                return "Bonjour";
//            case "ind":
//                return "Namasthe";
//            default:
//                return "Hello";
//        }
//        return "Hello";
//    }
	
	
	@GetMapping("/hello")
    public ResponseEntity<String> greetings(@RequestHeader(name="locallanguage") String language) {

        String greeting = getGreeting(language);
        return ResponseEntity.status(HttpStatus.OK).body(greeting);
    }

    private String getGreeting(String language) {
        switch (language) {
            case "en":
               
                    return "Hello";
             
            case "fr":
                return "Bonjour";
            case "ind":
                return "Namasthe";
            default:
                return "Hello";
        }
      //  return "Hello";
    }
	
}


