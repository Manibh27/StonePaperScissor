package com.StonePaperScissor.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.StonePaperScissor.Common.Constants;
import com.StonePaperScissor.Dao.GameDao;
import com.StonePaperScissor.Entity.Match;
import com.StonePaperScissor.Entity.Player;
import com.StonePaperScissor.Entity.Round;

/**
 * Buisness calculations are performed here.
 * @author Mani Bharathi.M
 *
 */
@Service
public class GameServiceImpl implements GameService {
	@Autowired
    private GameDao gameDao;
	
	static int roundNumber = 0;

	@Override
	public void startGame() {
		roundNumber = 0;
		gameDao.initializeMatch();
	}

	@Override
	public Match getMatchResult() {
		Match matchResult = gameDao.getMatchResult();
		if (!CollectionUtils.isEmpty(matchResult.getPlayers())) {
		    for (Player player : matchResult.getPlayers()) {
			     updatePlayersTotalScore(player);
		    }
		}
		updateMatchWinner(matchResult);
		return matchResult;
	}

	/**
	 * The total score of each player is compared and the winner is chosen.
	 * As of now if two player has same score first come player will be the winner.
	 * @param matchResult
	 */
	private void updateMatchWinner(Match matchResult) {
		Player winner = matchResult.getPlayers().get(0);
		if (!CollectionUtils.isEmpty(matchResult.getPlayers())) {
			for (Player player : matchResult.getPlayers()) {
				if (player.getTotalScore() > winner.getTotalScore()) {
					winner = player;
				}
			}
		}
		matchResult.setWinner(winner);
	}

	/**
	 * The players score of each round is added and the total score is updated.
	 * @param player
	 *        - Player whose score to be updated.
	 */
	private void updatePlayersTotalScore(Player player) {
		int totalScore = 0;
		if (!CollectionUtils.isEmpty(player.getRounds())) {
		    for (Round round : player.getRounds()) {
				totalScore =+ round.getScore();
		    }
		}
		player.setTotalScore(totalScore);
	}

	@Override
	public JSONObject updateRoundInfo(HttpServletRequest request) {
    	int playerOneChoice = Integer.parseInt(request.getParameter(
    			Constants.PLAYER_ONE_CHOICE));
    	int playerTwoChoice = Integer.parseInt(request.getParameter(
    			Constants.PLAYER_TWO_CHOICE));
    	int playerThreeChoice = Integer.parseInt(request.getParameter(
    			Constants.PLAYER_THREE_CHOICE));
    	int playerFourChoice = Integer.parseInt(request.getParameter(
    			Constants.PLAYER_FOUR_CHOICE));   	
    	List<Player> players = getPlayers(playerOneChoice, playerTwoChoice, playerThreeChoice, playerFourChoice);
        gameDao.updateMatch(players);
        JSONObject success = new JSONObject();
        success.put("result", "success");
		return success;
	}

	/**
	 * Scores are calculated based on the players choice and game rules.
	 * When a player choice is greater than another player score increases by one,
	 * if it is less score decreases by one
	 * @param players
	 */
	private void updatePlayerWithRoundScore(Player player, int roundNumber,  int... oponentsChoice) {
		    int score = 0;
		    
		    // Choice 1 is stone, choice 2 is paper,  choice 3 is scissor.
		    // Based on the choice the score is calculated.
			if (1 == player.getChoice()) {
				for (int oponentChoice : oponentsChoice) {
					if (3 == oponentChoice) {
						score++;
					} else if (2 == oponentChoice) {
						score--;
					}
				}
			} else if (2 == player.getChoice()) {
				for (int oponentChoice : oponentsChoice) {
					if (1 == oponentChoice) {
						score++;
					} else if (3 == oponentChoice) {
						score--;
					}
				}
			} else if (3 == player.getChoice()) {
				for (int oponentChoice : oponentsChoice) {
					if (2 == oponentChoice) {
						score++;
					} else if (1 == oponentChoice) {
						score--;
					}
				}
			} 
			if (score < 0) {
				score = 0;
			}
			Round round = new Round();
			round.setRoundNumber(roundNumber);
			round.setScore(score);
			List<Round> rounds = new ArrayList<Round>();
			rounds.add(round);
			player.setRounds(rounds);
	}

	/**
	 * Create players with their choice and return as list.
	 * @param playerOneChoice
	 * @param playerTwoChoice
	 * @param playerThreeChoice
	 * @param playerFourChoice
	 * @return
	 */
	private List<Player> getPlayers(int playerOneChoice, int playerTwoChoice, 
			int playerThreeChoice, int playerFourChoice) {
    	Player playerOne = new Player(1, playerOneChoice);
    	Player playerTwo = new Player(2, playerTwoChoice);
    	Player playerThree = new Player(3, playerThreeChoice);
    	Player playerFour = new Player(4, playerFourChoice);
    	roundNumber++;
    	updatePlayerWithRoundScore(playerOne, roundNumber, playerTwoChoice, playerThreeChoice,
    			playerFourChoice);
    	updatePlayerWithRoundScore(playerTwo, roundNumber, playerOneChoice, playerThreeChoice,
    			playerFourChoice);
    	updatePlayerWithRoundScore(playerThree,roundNumber,  playerOneChoice, playerTwoChoice,
    			playerFourChoice);
    	updatePlayerWithRoundScore(playerFour, roundNumber, playerOneChoice, playerTwoChoice,
    			playerThreeChoice);

    	List<Player> players = new ArrayList<Player>();
    	players.add(playerOne);
    	players.add(playerTwo);
    	players.add(playerThree);
    	players.add(playerFour);
    	
    	return players;
	}

}
