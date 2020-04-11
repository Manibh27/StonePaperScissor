package com.StonePaperScissor.Service;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

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

	/**
	 * After each round the player scores are calculated and updated.
	 * @param request
	 * @return
	 */
	public JSONObject updateRoundInfo(HttpServletRequest request);

}
