package com.tivamo.game;

import java.io.IOException;
import java.util.List;

import com.tivamo.game.board.BoardManager;
import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;
import com.tivamo.game.player.Player;

public class Game {

	public static void main(String args[]) throws IOException {
		GameProperties.readProperties();
		Player playerA = new Player();
		Player playerB = new Player();
		RandomNumber randomNumber = new RandomNumber();
		int diceOutcomebyFirstPerson, playerUpdatedPosition, diceOutcomebySecondPerson;
		List<Ladder> ladderList;
		List<Snake> snakeList;
		BoardManager boardManager = new BoardManager();
		boardManager.generateBoardOnValidity();
		ladderList = boardManager.getLadderList();
		snakeList = boardManager.getSnakeList();
		Player[] players = new Player[2];

		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}

		while (true) {
			diceOutcomebyFirstPerson = randomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
			playerUpdatedPosition = LadderUtilities
					.getLadderTopPosition((playerA.getPosition() + diceOutcomebyFirstPerson), ladderList);
			playerA.setPosition(playerUpdatedPosition > GameProperties.MAX_POSITIONS_IN_BOARD ? playerA.getPosition()
					: playerUpdatedPosition);
			playerA.setPosition(SnakeUtilities.getSnakeTail(playerA.getPosition(), snakeList));
			System.out.print(playerA.getPosition() + "--");
			diceOutcomebySecondPerson = randomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
			playerUpdatedPosition = LadderUtilities
					.getLadderTopPosition((playerB.getPosition() + diceOutcomebySecondPerson), ladderList);
			playerB.setPosition(playerUpdatedPosition > GameProperties.MAX_POSITIONS_IN_BOARD ? playerB.getPosition()
					: playerUpdatedPosition);
			playerB.setPosition(SnakeUtilities.getSnakeTail(playerB.getPosition(), snakeList));
			System.out.println(playerB.getPosition());

			if (playerA.getPosition() == GameProperties.MAX_POSITIONS_IN_BOARD) {
				System.out.println("Palyer A wins");
				break;
			}
			if (playerB.getPosition() == GameProperties.MAX_POSITIONS_IN_BOARD) {
				System.out.println("Palyer B wins");
				break;
			}
		}
	}

}
