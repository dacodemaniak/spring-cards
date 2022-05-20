package com.aelion.cards.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aelion.cards.entities.Player;
import com.aelion.cards.repositories.PlayerRepository;
import com.aelion.cards.services.PlayerService;


@RestController
@RequestMapping("player") // URI http://127.0.0.1:8080/player
public class PlayerController {

	@Autowired
	PlayerService playerService; // Injection de la dépendance PlayerRepository
	
	@GetMapping()
	public String sayHello() {
		return "Hello Spring"; // GET http://127.0.0.1:8080/player => arrive ici !
	}
	
	@GetMapping("/{id}") // GET http://127.0.0.1:8080/player/n
	public ResponseEntity<?> getPlayer(@PathVariable Long id) {
		Optional<Player> oPlayer = playerService.findOne(id);
		
		if (oPlayer.isPresent()) {
			return new ResponseEntity<Player>(oPlayer.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping() // POST http://127.0.0.1:8080/player
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Player addPlayer(@RequestBody() Player player) {
		
		playerService.save(player);
		
		return player;
	}
}
