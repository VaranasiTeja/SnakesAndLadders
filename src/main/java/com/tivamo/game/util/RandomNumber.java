package com.tivamo.game.util;

import java.util.Random;

public class RandomNumber {
	private Random r = new Random();

	public int diceOutcome(int max) {
		return r.nextInt(max) + 1;
	}

	public int getRandomNumberInRange(int max, int min) {
		return r.nextInt((max - min) + 1) + min;
	}

}
