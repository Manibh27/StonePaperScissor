package com.StonePaperScissor.Entity;

import java.util.List;

/**
 * Each round information stored.
 * @author Mani Bharathi.M
 *
 */
public class Round {
	private int roundNumber;
	private int score;
	private List<Player> players;
    
	//Getters and Setters
    public int getRoundNumber() {
		return roundNumber;
	}
    
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
    public List<Player> getPlayers() {
		return players;
	}
    
	public void setPlayers(List<Player> players) {
		this.players = players;
	} 
}