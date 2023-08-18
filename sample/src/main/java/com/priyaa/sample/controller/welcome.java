package com.priyaa.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
@GetMapping("color")
   public String Welcome() {
	return "Welcome";
}
}





























































