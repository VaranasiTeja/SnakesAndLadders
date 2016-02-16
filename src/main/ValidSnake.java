package main;

import java.util.ArrayList;

public class ValidSnake {

	private ArrayList<Ladder> ladders = new ArrayList<Ladder>();

	void setLadderList(ArrayList<Ladder> ladderList) {
		this.ladders = ladderList;
	}

	public boolean checkSnake(Snake newSnake, ArrayList<Snake> snakeList) {
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
