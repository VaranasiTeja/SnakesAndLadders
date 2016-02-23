package com.tivamo.game.board;

import java.util.List;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.ladder.LadderManager;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.snake.SnakeManager;

public class Board {

	private List<Ladder> ladderList;
	private List<Snake> snakeList;

	public void generateValidBoard() {
		LadderManager ladderManager = new LadderManager();
		SnakeManager snakeManager = new SnakeManager();
		do {
			ladderList = ladderManager.generateLadderList(GameProperties.MAX_LADDERS);
			snakeList = snakeManager.generateSnakeList(GameProperties.MAX_SNAKES);
		} while (!validateBoard(ladderList, snakeList));
	}

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

	public List<Ladder> getLadderList() {
		return ladderList;
	}

	public List<Snake> getSnakeList() {
		return snakeList;
	}

}
