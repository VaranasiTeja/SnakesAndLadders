package main;

public class Player {

	private String name;

	private int position = 0;

	public Player(String name) {
		this.name = name;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

}
