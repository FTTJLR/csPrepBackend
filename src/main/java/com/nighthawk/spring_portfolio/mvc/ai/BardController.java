package com.nighthawk.spring_portfolio.mvc.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://fttjlr.github.io")
@RestController
@RequestMapping("/api/bard")
public class BardController {

    private final GoogleBardExample bardExample;

    @Autowired
    public BardController() {
        String token = "eAhIiu0w8muSSVRFVqMHMywUgUrdWz0RjLohT4sptxpNCIe-QQj_GAgO45A0LLfCnIOBJw.;sidts-CjIBPVxjSpBAhXucvQXxYjr6zpKMfh0nLSaGkLB5Kif8E3peJRn6A-y-iTQ9RYg-cj1DLxAA";
        this.bardExample = new GoogleBardExample(token);
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody String question) {
        String answer = bardExample.askQuestion(question);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}

