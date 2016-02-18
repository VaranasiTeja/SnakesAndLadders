package com.tivamo.game.ladder;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.RandomNumber;

public class LadderManager {

	private RandomNumber randomNumForLadderPositions = new RandomNumber();

	ValidateLadder ladderValidator = new ValidateLadder();

	public List<Ladder> generateLadderList(int maxNumLadders) {
		List<Ladder> ladderList = new ArrayList<Ladder>();
		while (true) {
			if (ladderList.size() == maxNumLadders)
				break;
			Ladder newLadder = new Ladder(
					randomNumForLadderPositions
							.randomNumberForLadderPosition(GameProperties.MAX_NUM_POSITIONS_IN_BOARD),
					randomNumForLadderPositions
							.randomNumberForLadderPosition(GameProperties.MAX_NUM_POSITIONS_IN_BOARD));
			if (ladderValidator.validateLadder(newLadder, ladderList) == true) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

}
