package com.tivamo.game.ladder;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;

public class LadderManager {

	private RandomNumber randomNumber = new RandomNumber();

	public List<Ladder> generateLadderList(int maxLadders) {
		List<Ladder> ladderList = new ArrayList<Ladder>();
		int topPosition, bottomPosition;
		while (ladderList.size() < maxLadders) {
			topPosition = randomNumber.getRandomNumberInRange(GameProperties.MAX_POSITIONS_IN_BOARD - 1, 12);
			bottomPosition = randomNumber.getRandomNumberInRange(topPosition - 10, 2);
			Ladder newLadder = new Ladder(topPosition, bottomPosition);
			if (LadderUtilities.validateLadder(newLadder, ladderList)) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

}
