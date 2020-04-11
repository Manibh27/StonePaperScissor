package com.StonePaperScissor.Dao;

import java.util.List;

import com.StonePaperScissor.Entity.Match;
import com.StonePaperScissor.Entity.Player;
import com.StonePaperScissor.Entity.Round;

public interface GameDao {
	
	/**
	 * The match players information is returned.
	 * @return
	 */
	public Match getMatchResult();
	
	/**
	 * update the Match after each round.
	 * @param
	 *      -players info to be updated.
	 */
	public void updateMatch(List<Player> players);
	
	/**
	 * When a new match is started , new players are initialized.
	 */
	public void initializeMatch();

}
