package com.aelion.cards.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.cards.entities.Player;
import com.aelion.cards.repositories.PlayerRepository;

@Service()
public class PlayerService implements IPlayerService {
	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public Optional<Player> findOne(Long id) {
		return this.playerRepository.findById(id);
	}

	@Override
	public List<Player> findAll() {
		// SELECT * FROM player
		return (List<Player>) this.playerRepository.findAll();
	}

	@Override
	public Player save(Player player) {
		return this.playerRepository.save(player);
	}

	@Override
	public void remove(Player player) {
		this.playerRepository.delete(player);
		
	}

}
