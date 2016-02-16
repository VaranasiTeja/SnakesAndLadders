package main;

import java.util.ArrayList;

public class LadderList {

	private RandomNumber randomNumForLadderPositions = new RandomNumber();

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
			if (checkLadder(newLadder, ladderList) == true) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

	private boolean checkLadder(Ladder newLadder, ArrayList<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			return !(ladder.getBasePosition() == newLadder.getBasePosition()
					|| ladder.getTopPosition() == newLadder.getBasePosition()
					|| newLadder.getTopPosition() == ladder.getTopPosition()
					|| (newLadder.getTopPosition() - newLadder.getBasePosition() < 10));
		}
		return (newLadder.getTopPosition() - newLadder.getBasePosition() > 10);
	}

}
