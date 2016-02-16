package main;

import java.util.ArrayList;

public class Game {

	int[][] snake = { { 20, 2 }, { 35, 10 }, { 75, 40 }, { 85, 34 }, { 97, 4 } };

	public static void main(String args[]) {
		Player playerA = new Player("Player-A");
		Player playerB = new Player("Player-B");
		Game game = new Game();
		RandomNumber randomNumForDice = new RandomNumber();
		int diceOutcomebyFirstPerson, newPosition, diceOutcomebySecondPerson;
		LadderList ladders = new LadderList();
		ArrayList<Ladder> allLadders = ladders.generateLadderList(GameProperties.maxNumLadders);
		System.out.println("Ladders:");
		game.display(allLadders);
		System.out.println("---Game Begin ---");
		while (true) {
			diceOutcomebyFirstPerson = randomNumForDice.DiceOutcome(GameProperties.diceOutComeRange);
			newPosition = game.ifLadder((playerA.getPosition() + diceOutcomebyFirstPerson), allLadders);
			playerA.setPosition(
					newPosition > GameProperties.maxNumPositionsInBoard ? playerA.getPosition() : newPosition);
			playerA.setPosition(game.ifSnake(playerA.getPosition()));
			System.out.print(playerA.getPosition() + "--");

			diceOutcomebySecondPerson = randomNumForDice.DiceOutcome(GameProperties.diceOutComeRange);
			newPosition = game.ifLadder((playerB.getPosition() + diceOutcomebySecondPerson), allLadders);
			playerB.setPosition(
					newPosition > GameProperties.maxNumPositionsInBoard ? playerB.getPosition() : newPosition);
			playerB.setPosition(game.ifSnake(playerB.getPosition()));
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

	int ifSnake(int position) {
		for (int i = 0; i < 5; i++) {
			if (snake[i][0] == position)
				return snake[i][1];
		}
		return position;
	}

	void display(ArrayList<Ladder> laddersList) {
		for (Ladder ladder : laddersList) {
			System.out.println(ladder.getBasePosition() + "  " + ladder.getTopPosition());
		}

	}

}
