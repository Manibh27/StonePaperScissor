package com.StonePaperScissor.Entity;

import java.util.List;

/**
 * Match Players information and the winner is stored.
 * @author Mani Bharathi.M
 *
 */
public class Match {
	private List<Round> rounds;
	private List<Player> players;
	private Player winner;
	
	//Getters and Setters
	public List<Round> getRounds() {
		return rounds;
	}
	
	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public void setWinner(Player winner) {
		this.winner = winner;
	}

}
