package com.StonePaperScissor.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.StonePaperScissor.Common.Constants;
import com.StonePaperScissor.Entity.Match;
import com.StonePaperScissor.Entity.Player;
import com.StonePaperScissor.Entity.Round;

/**
 * Informations are stored here.
 * @author Mani Bharathi.M
 *
 */
@Repository
public class GameDaoImpl implements GameDao {
	List<Player> matchPlayers = new ArrayList<Player>();

	@Override
	public Match getMatchResult() {
		Match match = new Match();
		match.setPlayers(matchPlayers);
		return match;
	}

	@Override
	public void updateMatch(List<Player> players) {
		if (!CollectionUtils.isEmpty(players)) {
			for (Player player : players) {
				matchPlayers.get(player.getPlayerNumber() - 1)
			    .getRounds().addAll(player.getRounds());
			}
		}
	}

	@Override
	public void initializeMatch() {
		if (!CollectionUtils.isEmpty(matchPlayers)) {
			matchPlayers.removeAll(matchPlayers);
		}
		for (int playerNumber = 1; playerNumber <= Constants.NO_OF_PLAYERS; playerNumber++) {
			Player player = new Player();
			player.setPlayerNumber(playerNumber);
			player.setRounds(new ArrayList<Round>());
			matchPlayers.add(player);
		}
		
	}

	
}
