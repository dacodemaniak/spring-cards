package com.aelion.cards.services;

import java.util.List;
import java.util.Optional;

import com.aelion.cards.entities.Player;

public interface IPlayerService {
	public Optional<Player> findOne(Long id);
	public List<Player> findAll();
	public Player save(Player player);
	public void remove(Player player);
}
