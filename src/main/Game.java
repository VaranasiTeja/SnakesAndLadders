package main;

import java.util.Random;

import players.Player;

public class Game {

	Random r = new Random();

	int[][] ladder = { { 6, 13 }, { 21, 43 }, { 27, 61 }, { 54, 87 } };

	int[][] snake = { { 20, 2 }, { 35, 10 }, { 75, 40 }, { 85, 34 }, { 97, 4 } };

	public static void main(String args[]) {
		Player playerA = new Player("Player-A");
		Player playerB = new Player("Player-B");
		Game obj = new Game();

		int randomOne, newPosition, randomTwo;

		while (true) {

			randomOne = obj.getRandom(1, 6);
			newPosition = obj.ifLadder(playerA.position + randomOne);
			playerA.position = newPosition > 100 ? playerA.position : newPosition;
			playerA.position = obj.ifSnake(playerA.position);
			System.out.print(playerA.position + "----");

			randomTwo = obj.getRandom(1, 6);
			newPosition = obj.ifLadder(playerB.position + randomTwo);
			playerB.position = newPosition > 100 ? playerB.position : newPosition;
			playerB.position = obj.ifSnake(playerB.position);
			System.out.println(playerB.position);

			if (playerA.position == 100) {
				System.out.println("Palyer A wins");
				break;
			}
			if (playerB.position == 100) {
				System.out.println("Palyer B wins");
				break;
			}

		}

	}

	int getRandom(int min, int max) {
		return r.nextInt(max - min) + min;
	}

	int ifLadder(int position) {
		for (int i = 0; i < 4; i++) {
			if (ladder[i][0] == position)
				return ladder[i][1];
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
}
