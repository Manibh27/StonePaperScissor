package com.StonePaperScissor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

	@Override
	public void startGame() {
		gameDao.initializeMatchPlayers();
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

}
