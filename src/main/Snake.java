package main;

public class Snake {
	private int basePosition;
	private int topPosition;

	void setBasePosition(int position) {
		this.basePosition = position;
	}

	void setTopPosition(int position) {
		this.topPosition = position;
	}

	int getBasePosition() {
		return this.basePosition;
	}

	int getTopPosition() {
		return this.topPosition;
	}

}
