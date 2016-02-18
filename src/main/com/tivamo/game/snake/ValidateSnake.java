package com.tivamo.game.snake;

import java.util.List;

public class ValidateSnake {

	public boolean validateSnake(Snake newSnake, List<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getBasePosition() == newSnake.getBasePosition()
					|| snake.getTopPosition() == newSnake.getBasePosition()
					|| snake.getTopPosition() == newSnake.getTopPosition()
					|| snake.getBasePosition() == newSnake.getTopPosition()
					|| (newSnake.getTopPosition() - newSnake.getBasePosition() < 10))
				return false;
		}
		return (newSnake.getTopPosition() - newSnake.getBasePosition() > 10);
	}

}
