package main;

import java.util.ArrayList;

public class SnakeList {
	private RandomNumber randomNumForLadderPositions = new RandomNumber();
	private ArrayList<Ladder> ladders = new ArrayList<Ladder>();

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
			if (checkSnake(newSnake, snakeList) == true) {
				snakeList.add(newSnake);
			}
		}
		return snakeList;
	}

	void setLadderList(ArrayList<Ladder> ladderList) {
		this.ladders = ladderList;
	}

	private boolean checkSnake(Snake newSnake, ArrayList<Snake> snakeList) {
		for (Snake snake : snakeList) {
			for (Ladder ladder : ladders) {
				return !(snake.getBasePosition() == newSnake.getBasePosition()
						|| snake.getTopPosition() == newSnake.getBasePosition()
						|| ladder.getTopPosition() == newSnake.getTopPosition()
						|| ladder.getBasePosition() == newSnake.getTopPosition()
						|| (ladder.getBasePosition() == newSnake.getBasePosition())
						|| (newSnake.getTopPosition() - newSnake.getBasePosition() < 10));
			}
		}
		return (newSnake.getTopPosition() - newSnake.getBasePosition() > 10);
	}

}
