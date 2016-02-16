package main;

import java.util.ArrayList;

public class LadderPosition {

	int ifLadder(int position, ArrayList<Ladder> laddersList) {
		for (Ladder ladder : laddersList) {
			if (ladder.getBasePosition() == position)
				return ladder.getTopPosition();
		}
		return position;
	}
}
