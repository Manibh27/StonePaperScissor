package com.StonePaperScissor.Entity;

import java.util.List;

/**
 * Players information stored.
 * @author Mani Bharathi.M
 */
public class Player {
	private int playerNumber;
	private int choice;
	private List<Round> rounds;
	private int totalScore;
	
	public Player() {}
	
	public Player(int playerNumber, int choice) {
		this.playerNumber = playerNumber;
		this.choice = choice;
	}
	 
	
	// Getters and Setters.
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	public List<Round> getRounds() {
		return rounds;
	}
	
	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

}
