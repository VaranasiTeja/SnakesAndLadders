package com.tivamo.game;

import java.util.List;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.ladder.LadderManager;
import com.tivamo.game.ladder.LadderPositionFinder;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.snake.SnakeManager;
import com.tivamo.game.snake.SnakePositionFinder;
import com.tivamo.game.util.DisplayLaddersAndSnakes;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakesAndLaddersValidator;
import com.tivamo.game.player.Player;

public class Game {

	public static void main(String args[]) {
		Player playerA = new Player();
		Player playerB = new Player();
		RandomNumber randomNumForDice = new RandomNumber();
		int diceOutcomebyFirstPerson, playerUpdatedPosition, diceOutcomebySecondPerson;
		List<Ladder> ladderList;
		List<Snake> snakeList;
		LadderManager ladderManager = new LadderManager();
		SnakeManager snakeManager = new SnakeManager();
		SnakesAndLaddersValidator salvc = new SnakesAndLaddersValidator();
		while (true) {
			ladderList = ladderManager.generateLadderList(GameProperties.MAX_NUM_LADDERS);
			snakeList = snakeManager.generateSnakeList(GameProperties.MAX_NUM_SNAKES);
			if (salvc.validateSnakesAndLadders(ladderList, snakeList) == true)
				break;
			else
				continue;
		}
		System.out.println("Ladders:");
		DisplayLaddersAndSnakes display = new DisplayLaddersAndSnakes();
		display.displayLadders(ladderList);
		System.out.println("Snakes:");
		display.displaySnakes(snakeList);
		System.out.println("---Game Begin ---");
		LadderPositionFinder ladderPosition = new LadderPositionFinder();
		SnakePositionFinder snakePosition = new SnakePositionFinder();
		while (true) {
			diceOutcomebyFirstPerson = randomNumForDice.DiceOutcome(GameProperties.DICE_OUTCOME_RANGE);
			playerUpdatedPosition = ladderPosition.returnLadderTopPositionIfLadderExist(
					(playerA.getPosition() + diceOutcomebyFirstPerson), ladderList);
			playerA.setPosition(playerUpdatedPosition > GameProperties.MAX_NUM_POSITIONS_IN_BOARD
					? playerA.getPosition() : playerUpdatedPosition);
			playerA.setPosition(snakePosition.returnSnakeBasePositionIfSnakeExist(playerA.getPosition(), snakeList));
			System.out.print(playerA.getPosition() + "--");
			diceOutcomebySecondPerson = randomNumForDice.DiceOutcome(GameProperties.DICE_OUTCOME_RANGE);
			playerUpdatedPosition = ladderPosition.returnLadderTopPositionIfLadderExist(
					(playerB.getPosition() + diceOutcomebySecondPerson), ladderList);
			playerB.setPosition(playerUpdatedPosition > GameProperties.MAX_NUM_POSITIONS_IN_BOARD
					? playerB.getPosition() : playerUpdatedPosition);
			playerB.setPosition(snakePosition.returnSnakeBasePositionIfSnakeExist(playerB.getPosition(), snakeList));
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
