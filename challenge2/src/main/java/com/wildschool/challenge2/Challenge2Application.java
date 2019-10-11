package com.wildschool.challenge2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
@Controller
@SpringBootApplication
public class Challenge2Application {

	public static void main(String[] args) {
		SpringApplication.run(Challenge2Application.class, args);
	}
	
	@GetMapping("/doctor/{number}")
	@ResponseBody
	public Doctor afficheDoctor(@PathVariable int number) {
		if (number >=1 && number<=8 ) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See other doctor");

	
		}
		switch(number) {
		
		case 9:
			return new Doctor (number,"Christopher Eccleston");
		case 10:
			return new Doctor (number,"David tennant");
		case 11:
			return new Doctor (number,"Matt Smith");
		case 12:
			return new Doctor (number,"Peter Capaldi");
		case 13:
			return new Doctor (number,"Jodie Whittaker");
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation "+ number);
		
	}
	
	}
