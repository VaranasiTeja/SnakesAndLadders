package main;

import java.util.ArrayList;

	public class SnakePosition {
	
		int ifSnake(int position, ArrayList<Snake> snakeList) {
			for (Snake snake : snakeList) {
				if (snake.getTopPosition() == position)
					return snake.getBasePosition();
			}
			return position;
		}

}
