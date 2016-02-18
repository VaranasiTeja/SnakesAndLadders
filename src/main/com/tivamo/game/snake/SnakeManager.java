package com.tivamo.game.snake;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.RandomNumber;

public class SnakeManager {
	private RandomNumber randomNumForLadderPositions = new RandomNumber();

	ValidateSnake snakeValidator = new ValidateSnake();

	public List<Snake> generateSnakeList(int maxNumSnakes) {
		List<Snake> snakeList = new ArrayList<Snake>();
		while (true) {
			Snake newSnake = new Snake(
					randomNumForLadderPositions
							.randomNumberForLadderPosition(GameProperties.MAX_NUM_POSITIONS_IN_BOARD - 1),
					randomNumForLadderPositions
							.randomNumberForLadderPosition(GameProperties.MAX_NUM_POSITIONS_IN_BOARD - 1));
			if (snakeValidator.validateSnake(newSnake, snakeList) == true) {
				snakeList.add(newSnake);
			}
			if (snakeList.size() == maxNumSnakes)
				break;
		}
		return snakeList;
	}
}
