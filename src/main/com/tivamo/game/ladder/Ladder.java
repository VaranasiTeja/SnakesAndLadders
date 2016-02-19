package com.tivamo.game.ladder;

public class Ladder {

	private int bottomPosition;
	private int topPosition;

	public Ladder(int bottomPosition, int topPosition) {
		this.bottomPosition = bottomPosition;
		this.topPosition = topPosition;
	}

	public int getBottomPosition() {
		return this.bottomPosition;
	}

	public int getTopPosition() {
		return this.topPosition;
	}
}
