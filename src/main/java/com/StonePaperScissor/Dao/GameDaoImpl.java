package com.StonePaperScissor.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.StonePaperScissor.Common.Constants;
import com.StonePaperScissor.Entity.Match;
import com.StonePaperScissor.Entity.Player;

/**
 * Informations are stored here.
 * @author Mani Bharathi.M
 *
 */
@Repository
public class GameDaoImpl implements GameDao {
	List<Player> players = new ArrayList<Player>();

	@Override
	public Match getMatchResult() {
		Match match = new Match();
		match.setPlayers(players);
		return match;
	}

	@Override
	public void updatePlayerPerRound(Player player) {
		players.get(player.getPlayerNumber() - 1)
		    .getRounds().addAll(player.getRounds());	
	}

	@Override
	public void initializeMatchPlayers() {
		if (players.size() > 0) {
			players.removeAll(players);
		}
		for (int playerNumber = 1; playerNumber <= Constants.NO_OF_PLAYERS; playerNumber++) {
			Player player = new Player();
			player.setPlayerNumber(playerNumber);
			players.add(player);
		}
		
	}

	
}
