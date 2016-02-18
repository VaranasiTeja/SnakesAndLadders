package com.tivamo.game.ladder;

import java.util.List;

public class ValidateLadder {

	public boolean validateLadder(Ladder newLadder, List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			if (ladder.getBasePosition() == newLadder.getBasePosition()
					|| ladder.getTopPosition() == newLadder.getBasePosition()
					|| ladder.getTopPosition() == newLadder.getTopPosition()
					|| ladder.getBasePosition() == newLadder.getTopPosition()
					|| (newLadder.getTopPosition() - newLadder.getBasePosition() < 10))
				return false;
		}
		return (newLadder.getTopPosition() - newLadder.getBasePosition() > 10);
	}

}
