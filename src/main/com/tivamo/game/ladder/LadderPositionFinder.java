package com.tivamo.game.ladder;

import java.util.List;

public class LadderPositionFinder {

	public int returnLadderTopPositionIfLadderExist(int position, List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			if (ladder.getBasePosition() == position)
				return ladder.getTopPosition();
		}
		return position;
	}
}
