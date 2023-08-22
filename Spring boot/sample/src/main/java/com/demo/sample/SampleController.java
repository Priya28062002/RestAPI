package com.demo.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/{name}")
    public ResponseEntity<?> sendMessage(@PathVariable("name") String name) {
        return ResponseEntity.ok("Welcome " + name);
    }
}
