package com.tivamo.game;

import java.util.List;

import com.tivamo.game.board.BoardManager;
import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.ladder.LadderManager;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.snake.SnakeManager;
import com.tivamo.game.util.DisplayBoard;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;
import com.tivamo.game.player.Player;

public class Game {

	public static void main(String args[]) {
		Player playerA = new Player();
		Player playerB = new Player();
		RandomNumber randomNumber = new RandomNumber();
		int diceOutcomebyFirstPerson, playerUpdatedPosition, diceOutcomebySecondPerson;
		List<Ladder> ladderList;
		List<Snake> snakeList;
		LadderManager ladderManager = new LadderManager();
		SnakeManager snakeManager = new SnakeManager();
		BoardManager boardManager = new BoardManager();
		while (true) {
			ladderList = ladderManager.generateLadderList(GameProperties.MAX_NUM_LADDERS);
			snakeList = snakeManager.generateSnakeList(GameProperties.MAX_NUM_SNAKES);
			if (boardManager.validateBoard(ladderList, snakeList))
				break;
			else
				continue;
		}
		System.out.println("Ladders:");
		DisplayBoard display = new DisplayBoard();
		display.displayLadders(ladderList);
		System.out.println("Snakes:");
		display.displaySnakes(snakeList);
		System.out.println("---Game Begin ---");
		LadderUtilities ladderUtilities = new LadderUtilities();
		SnakeUtilities snakeUtilities = new SnakeUtilities();
		while (true) {
			diceOutcomebyFirstPerson = randomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
			playerUpdatedPosition = ladderUtilities
					.getLadderTopPosition((playerA.getPosition() + diceOutcomebyFirstPerson), ladderList);
			playerA.setPosition(playerUpdatedPosition > GameProperties.MAX_NUM_POSITIONS_IN_BOARD
					? playerA.getPosition() : playerUpdatedPosition);
			playerA.setPosition(snakeUtilities.getSnakeTail(playerA.getPosition(), snakeList));
			System.out.print(playerA.getPosition() + "--");
			diceOutcomebySecondPerson = randomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
			playerUpdatedPosition = ladderUtilities
					.getLadderTopPosition((playerB.getPosition() + diceOutcomebySecondPerson), ladderList);
			playerB.setPosition(playerUpdatedPosition > GameProperties.MAX_NUM_POSITIONS_IN_BOARD
					? playerB.getPosition() : playerUpdatedPosition);
			playerB.setPosition(snakeUtilities.getSnakeTail(playerB.getPosition(), snakeList));
			System.out.println(playerB.getPosition());

			if (playerA.getPosition() == GameProperties.MAX_NUM_POSITIONS_IN_BOARD) {
				System.out.println("Palyer A wins");
				break;
			}
			if (playerB.getPosition() == GameProperties.MAX_NUM_POSITIONS_IN_BOARD) {
				System.out.println("Palyer B wins");
				break;
			}
		}
	}

}
