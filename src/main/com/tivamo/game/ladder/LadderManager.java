package com.tivamo.game.ladder;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;

public class LadderManager {

	private RandomNumber randomNumber = new RandomNumber();

	LadderUtilities ladderUtilities = new LadderUtilities();

	public List<Ladder> generateLadderList(int maxNumLadders) {
		List<Ladder> ladderList = new ArrayList<Ladder>();
		int topPosition, bottomPosition;
		while (ladderList.size() < maxNumLadders) {
			topPosition = randomNumber.getRandomNumberInRange(GameProperties.MAX_NUM_POSITIONS_IN_BOARD - 1, 12);
			bottomPosition = randomNumber.getRandomNumberInRange(topPosition - 10, 2);
			Ladder newLadder = new Ladder(bottomPosition, topPosition);
			if (ladderUtilities.validateLadder(newLadder, ladderList)) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

}
