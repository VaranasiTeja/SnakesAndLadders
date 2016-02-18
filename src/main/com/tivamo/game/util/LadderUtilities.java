package com.tivamo.game.util;

import java.util.List;

import com.tivamo.game.ladder.Ladder;

public class LadderUtilities {

	public int getLadderTopPosition(int position, List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			if (ladder.getBottomPosition() == position)
				return ladder.getTopPosition();
		}
		return position;
	}

	public boolean validateLadder(Ladder newLadder, List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			if (ladder.getBottomPosition() == newLadder.getBottomPosition()
					|| ladder.getTopPosition() == newLadder.getBottomPosition()
					|| ladder.getTopPosition() == newLadder.getTopPosition()
					|| ladder.getBottomPosition() == newLadder.getTopPosition())
				return false;
		}
		return true;
	}

}
