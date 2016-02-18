package com.tivamo.game.util;

import java.util.List;

import com.tivamo.game.snake.Snake;

public class SnakeUtilities {

	public int getSnakeTail(int position, List<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getHead() == position)
				return snake.getTail();
		}
		return position;
	}

	public boolean validateSnake(Snake newSnake, List<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getTail() == newSnake.getTail() || snake.getHead() == newSnake.getTail()
					|| snake.getHead() == newSnake.getHead() || snake.getTail() == newSnake.getHead())
				return false;
		}
		return true;
	}
}
