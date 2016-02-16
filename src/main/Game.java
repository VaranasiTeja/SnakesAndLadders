package main;

import java.util.ArrayList;

public class Game {

	public static void main(String args[]) {
		Player playerA = new Player("Player-A");
		Player playerB = new Player("Player-B");
		RandomNumber randomNumForDice = new RandomNumber();
		int diceOutcomebyFirstPerson, newPosition, diceOutcomebySecondPerson;
		LadderList ladders = new LadderList();
		ArrayList<Ladder> allLadders = ladders.generateLadderList(GameProperties.maxNumLadders);
		System.out.println("Ladders:");
		Display display = new Display();
		display.displayLadders(allLadders);
		SnakeList snakes = new SnakeList();
		ValidSnake validSnake = new ValidSnake();
		validSnake.setLadderList(allLadders);
		ArrayList<Snake> allSnakes = snakes.generateSnakeList(GameProperties.maxNumSnakes);
		System.out.println("Snakes:");
		display.displaySnakes(allSnakes);
		System.out.println("---Game Begin ---");
		LadderPosition ladderPosition = new LadderPosition();
		SnakePosition snakePosition = new SnakePosition();
		while (true) {
			diceOutcomebyFirstPerson = randomNumForDice.DiceOutcome(GameProperties.diceOutComeRange);
			newPosition = ladderPosition.ifLadder((playerA.getPosition() + diceOutcomebyFirstPerson), allLadders);
			playerA.setPosition(
					newPosition > GameProperties.maxNumPositionsInBoard ? playerA.getPosition() : newPosition);
			playerA.setPosition(snakePosition.ifSnake(playerA.getPosition(), allSnakes));
			System.out.print(playerA.getPosition() + "--");

			diceOutcomebySecondPerson = randomNumForDice.DiceOutcome(GameProperties.diceOutComeRange);
			newPosition = ladderPosition.ifLadder((playerB.getPosition() + diceOutcomebySecondPerson), allLadders);
			playerB.setPosition(
					newPosition > GameProperties.maxNumPositionsInBoard ? playerB.getPosition() : newPosition);
			playerB.setPosition(snakePosition.ifSnake(playerB.getPosition(), allSnakes));
			System.out.println(playerB.getPosition());

			if (playerA.getPosition() == GameProperties.maxNumPositionsInBoard) {
				System.out.println("Palyer A wins");
				break;
			}
			if (playerB.getPosition() == GameProperties.maxNumPositionsInBoard) {
				System.out.println("Palyer B wins");
				break;
			}
		}
	}

}
