package main;

import java.util.ArrayList;

public class Game {

	public static void main(String args[]) {
		Player playerA = new Player("Player-A");
		Player playerB = new Player("Player-B");
		Game game = new Game();
		RandomNumber randomNumForDice = new RandomNumber();
		int diceOutcomebyFirstPerson, newPosition, diceOutcomebySecondPerson;
		LadderList ladders = new LadderList();
		ArrayList<Ladder> allLadders = ladders.generateLadderList(GameProperties.maxNumLadders);
		System.out.println("Ladders:");
		game.displayLadders(allLadders);
		SnakeList snakes = new SnakeList();
		snakes.setLadderList(allLadders);
		ArrayList<Snake> allSnakes = snakes.generateSnakeList(GameProperties.maxNumSnakes);
		System.out.println("Snakes:");
		game.displaySnakes(allSnakes);
		System.out.println("---Game Begin ---");
		while (true) {
			diceOutcomebyFirstPerson = randomNumForDice.DiceOutcome(GameProperties.diceOutComeRange);
			newPosition = game.ifLadder((playerA.getPosition() + diceOutcomebyFirstPerson), allLadders);
			playerA.setPosition(
					newPosition > GameProperties.maxNumPositionsInBoard ? playerA.getPosition() : newPosition);
			playerA.setPosition(game.ifSnake(playerA.getPosition(), allSnakes));
			System.out.print(playerA.getPosition() + "--");

			diceOutcomebySecondPerson = randomNumForDice.DiceOutcome(GameProperties.diceOutComeRange);
			newPosition = game.ifLadder((playerB.getPosition() + diceOutcomebySecondPerson), allLadders);
			playerB.setPosition(
					newPosition > GameProperties.maxNumPositionsInBoard ? playerB.getPosition() : newPosition);
			playerB.setPosition(game.ifSnake(playerB.getPosition(), allSnakes));
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

	int ifLadder(int position, ArrayList<Ladder> laddersList) {
		for (Ladder ladder : laddersList) {
			if (ladder.getBasePosition() == position)
				return ladder.getTopPosition();
		}
		return position;
	}

	int ifSnake(int position, ArrayList<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getTopPosition() == position)
				return snake.getBasePosition();
		}
		return position;
	}

	void displayLadders(ArrayList<Ladder> laddersList) {
		for (Ladder ladder : laddersList) {
			System.out.println(ladder.getBasePosition() + "  " + ladder.getTopPosition());
		}

	}

	void displaySnakes(ArrayList<Snake> sankeList) {
		for (Snake snake : sankeList) {
			System.out.println(snake.getBasePosition() + "  " + snake.getTopPosition());
		}

	}

}
