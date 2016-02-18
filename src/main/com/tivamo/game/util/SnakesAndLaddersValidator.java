package com.tivamo.game.util;

import java.util.List;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.snake.Snake;

public class SnakesAndLaddersValidator {
	public boolean validateSnakesAndLadders(List<Ladder> ladderList, List<Snake> snakeList) {
		for (Ladder ladder : ladderList) {
			for (Snake snake : snakeList) {
				if (ladder.getTopPosition() == snake.getTopPosition()
						|| ladder.getBasePosition() == snake.getTopPosition()
						|| ladder.getTopPosition() == snake.getBasePosition()
						|| ladder.getBasePosition() == snake.getBasePosition())
					return false;
			}
		}
		return true;
	}
}
