package com.tivamo.game.snake;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;

public class SnakeManager {
	private RandomNumber randomNumber = new RandomNumber();

	SnakeUtilities snakeUtilities = new SnakeUtilities();

	public List<Snake> generateSnakeList(int maxNumSnakes) {
		List<Snake> snakeList = new ArrayList<Snake>();
		int head, tail;
		while (snakeList.size() < maxNumSnakes) {
			head = randomNumber.getRandomNumberInRange(GameProperties.MAX_NUM_POSITIONS_IN_BOARD - 1, 12);
			tail = randomNumber.getRandomNumberInRange(head - 10, 2);
			Snake newSnake = new Snake(tail, head);
			if (snakeUtilities.validateSnake(newSnake, snakeList)) {
				snakeList.add(newSnake);
			}
		}
		return snakeList;
	}
}
