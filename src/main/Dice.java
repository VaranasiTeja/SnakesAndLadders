package main;

import java.util.Random;

public class Dice {
	Random r = new Random();

	int rollTheDice(int max) {
		return r.nextInt(max) + 1;
	}
}
