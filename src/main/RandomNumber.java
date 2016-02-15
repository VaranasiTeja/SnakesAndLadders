package main;

import java.util.Random;

public class RandomNumber {
	private Random r = new Random();

	public int DiceOutcome(int max) {
		return r.nextInt(max) + 1;
	}

	public int randomNumberForLadderPosition(int max) {
		return r.nextInt(max) + 1;
	}
}
