package com.tivamo.game.board;

import java.util.List;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.snake.Snake;

public class BoardManager {

	public boolean validateBoard(List<Ladder> ladderList, List<Snake> snakeList) {
		for (Ladder ladder : ladderList) {
			for (Snake snake : snakeList) {
				if (ladder.getTopPosition() == snake.getHeadPos() || ladder.getBottomPosition() == snake.getHeadPos()
						|| ladder.getTopPosition() == snake.getTailPos()
						|| ladder.getBottomPosition() == snake.getTailPos())
					return false;
			}
		}
		return true;
	}

}
