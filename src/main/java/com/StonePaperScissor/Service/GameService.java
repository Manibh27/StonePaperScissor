package com.StonePaperScissor.Service;

import com.StonePaperScissor.Entity.Match;

public interface GameService {
	
	/**
	 * When a new game is started , new players are initialized.
	 */
	public void startGame();
	
	/**
	 * Return the match players info.
	 */
	public Match getMatchResult();

}
