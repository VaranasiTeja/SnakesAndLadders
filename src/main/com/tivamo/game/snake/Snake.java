package com.tivamo.game.snake;

public class Snake {
	private int tail;
	private int head;

	public Snake(int tail, int head) {
		this.tail = tail;
		this.head = head;
	}

	public int getTail() {
		return this.tail;
	}

	public int getHead() {
		return this.head;
	}

}
