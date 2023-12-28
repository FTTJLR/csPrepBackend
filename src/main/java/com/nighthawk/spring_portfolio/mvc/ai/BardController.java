package com.nighthawk.spring_portfolio.mvc.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/bard")
public class BardController {

    private final GoogleBardExample bardExample;

    @Autowired
    public BardController() {
        String token = "eAhIiu0w8muSSVRFVqMHMywUgUrdWz0RjLohT4sptxpNCIe-QQj_GAgO45A0LLfCnIOBJw.;sidts-CjIBPVxjSsvdCRnxtXTZBM-GVuqXgiJfJ5fLgLw582nOp6yw00PEmnZOFgYUSzD4J9nmgxAA";
        this.bardExample = new GoogleBardExample(token);
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody String question) {
        String answer = bardExample.askQuestion(question);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}

