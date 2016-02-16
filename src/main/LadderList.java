package main;

import java.util.ArrayList;

public class LadderList {

	private RandomNumber randomNumForLadderPositions = new RandomNumber();

	ValidLadder validateLadder = new ValidLadder();

	public ArrayList<Ladder> generateLadderList(int maxNumLadders) {
		ArrayList<Ladder> ladderList = new ArrayList<Ladder>();
		while (true) {
			if (ladderList.size() == maxNumLadders)
				break;
			Ladder newLadder = new Ladder();
			newLadder.setBasePosition(
					randomNumForLadderPositions.randomNumberForLadderPosition(GameProperties.maxNumPositionsInBoard));
			newLadder.setTopPosition(
					randomNumForLadderPositions.randomNumberForLadderPosition(GameProperties.maxNumPositionsInBoard));
			if (validateLadder.checkLadder(newLadder, ladderList) == true) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

}
