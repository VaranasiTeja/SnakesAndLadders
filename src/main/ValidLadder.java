package main;

import java.util.ArrayList;

public class ValidLadder {

	public boolean checkLadder(Ladder newLadder, ArrayList<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			return !(ladder.getBasePosition() == newLadder.getBasePosition()
					|| ladder.getTopPosition() == newLadder.getBasePosition()
					|| newLadder.getTopPosition() == ladder.getTopPosition()
					|| (newLadder.getTopPosition() - newLadder.getBasePosition() < 10));
		}
		return (newLadder.getTopPosition() - newLadder.getBasePosition() > 10);
	}

}
