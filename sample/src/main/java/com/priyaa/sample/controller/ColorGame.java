package com.priyaa.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorGame {
        @Value("${col}")
        private String color;
        @GetMapping("colors")
        public String color(){
        	
			return "My favorite color is "+color;
        }
}
