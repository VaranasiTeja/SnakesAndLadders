package main;

import java.util.ArrayList;

public class Display {

	void displayLadders(ArrayList<Ladder> laddersList) {
		for (Ladder ladder : laddersList) {
			System.out.println(ladder.getBasePosition() + "  " + ladder.getTopPosition());
		}

	}

	void displaySnakes(ArrayList<Snake> sankeList) {
		for (Snake snake : sankeList) {
			System.out.println(snake.getBasePosition() + "  " + snake.getTopPosition());
		}

	}

}
