package com.tivamo.game.snake;

import java.util.List;

public class SnakePositionFinder {

	public int returnSnakeBasePositionIfSnakeExist(int position, List<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getTopPosition() == position)
				return snake.getBasePosition();
		}
		return position;
	}

}
