package main;

import java.util.ArrayList;

public class SnakeList {
	private RandomNumber randomNumForLadderPositions = new RandomNumber();

	ValidSnake validSnake = new ValidSnake();

	public ArrayList<Snake> generateSnakeList(int maxNumSnakes) {
		ArrayList<Snake> snakeList = new ArrayList<Snake>();
		while (true) {
			if (snakeList.size() == maxNumSnakes)
				break;
			Snake newSnake = new Snake();
			newSnake.setBasePosition(randomNumForLadderPositions
					.randomNumberForLadderPosition(GameProperties.maxNumPositionsInBoard - 1));
			newSnake.setTopPosition(randomNumForLadderPositions
					.randomNumberForLadderPosition(GameProperties.maxNumPositionsInBoard - 1));
			if (validSnake.checkSnake(newSnake, snakeList) == true) {
				snakeList.add(newSnake);
			}
		}
		return snakeList;
	}
}
