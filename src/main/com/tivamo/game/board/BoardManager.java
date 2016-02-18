package com.tivamo.game.board;

import java.util.List;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.snake.Snake;

public class BoardManager {

	public boolean validateBoard(List<Ladder> ladderList, List<Snake> snakeList) {
		for (Ladder ladder : ladderList) {
			for (Snake snake : snakeList) {
				if (ladder.getTopPosition() == snake.getHead() || ladder.getBottomPosition() == snake.getHead()
						|| ladder.getTopPosition() == snake.getTail() || ladder.getBottomPosition() == snake.getTail())
					return false;
			}
		}
		return true;
	}

}
