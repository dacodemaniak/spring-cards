package com.aelion.cards.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aelion.cards.entities.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {}
