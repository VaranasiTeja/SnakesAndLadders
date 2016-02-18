package com.tivamo.game.snake;

public class Snake {
	private int basePosition;
	private int topPosition;

	public Snake(int basePosition, int topPosition) {
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
