package com.StonePaperScissor.Entity;

/**
 * Each round information stored.
 * @author Mani Bharathi.M
 *
 */
public class Round {
	private int roundNumber;
    private int score;
    
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
   
}