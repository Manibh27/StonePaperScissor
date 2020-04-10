package com.StonePaperScissor.Dao;

import com.StonePaperScissor.Entity.Match;
import com.StonePaperScissor.Entity.Player;

public interface GameDao {
	
	/**
	 * The match players information is returned.
	 * @return
	 */
	public Match getMatchResult();
	
	/**
	 * update the player information.
	 * @param
	 *      -player info to be updated.
	 */
	public void updatePlayerPerRound(Player player);
	
	/**
	 * When a new match is started , new players are initialized.
	 */
	public void initializeMatchPlayers();

}
