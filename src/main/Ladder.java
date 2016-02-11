package main;

import java.util.Random;

public class Ladder {
	Random rand = new Random();

	int[][] ladder = new int[4][2];

	int randomLadderNumber(int max) {
		return rand.nextInt(max) + 1;
	}

	public int[][] generateLadder() {
		int count = 0, index = 0;
		while (true) {
			ladder[index][0] = randomLadderNumber(50);
			ladder[index][1] = randomLadderNumber(50);
			if (checkLadder(ladder[index][0], ladder[index][1], count) == true) {
				count++;
				index++;
			}

			if (count == 4)
				break;
		}
		return ladder;
	}

	boolean checkLadder(int a, int b, int count) {
		for (int i = 0; i < count; i++) {
			if (ladder[i][0] == a || ladder[i][1] == a) {
				return false;
			}
		}
		if ((b - a) > 10)
			return true;
		else
			return false;
	}
}
