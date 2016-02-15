package main;

import java.util.ArrayList;

public class LaddersList {

	private ArrayList<Ladder> laddersList = new ArrayList<Ladder>();

	private RandomNumber randomNumForLadderPostions = new RandomNumber();

	public ArrayList<Ladder> generateLaddersList(int maxNumLadders) {
		while (true) {
			if (laddersList.size() == maxNumLadders)
				break;
			Ladder newLadder = new Ladder();
			newLadder.setBasePosition(
					randomNumForLadderPostions.randomNumberForLadderPosition(GameProperties.maxNumPositionsInBoard));
			newLadder.setTopPosition(
					randomNumForLadderPostions.randomNumberForLadderPosition(GameProperties.maxNumPositionsInBoard));
			if (checkLadder(newLadder) == true) {
				laddersList.add(newLadder);
			}
		}
		return laddersList;
	}

	private boolean checkLadder(Ladder newLadder) {
		for (Ladder ladder : laddersList) {
			return !(ladder.getBasePosition() == newLadder.getBasePosition()
					|| ladder.getTopPosition() == newLadder.getBasePosition());
		}
		return (newLadder.getTopPosition() - newLadder.getBasePosition() > 10);
	}

}
