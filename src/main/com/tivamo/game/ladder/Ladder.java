package com.tivamo.game.ladder;

public class Ladder {

	private int basePosition;
	private int topPosition;

	public Ladder(int basePosition, int topPosition) {
		this.basePosition = basePosition;
		this.topPosition = topPosition;
	}

	public int getBasePosition() {
		return this.basePosition;
	}

	public int getTopPosition() {
		return this.topPosition;
	}
}
