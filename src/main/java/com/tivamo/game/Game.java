package com.tivamo.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.board.Board;
import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;
import com.tivamo.game.player.Player;

public class Game {

	public static void main(String args[]) throws IOException {
		GameProperties.read();
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= GameProperties.NUM_PLAYERS; player++) {
			players.add(new Player());
		}
		Board board = new Board();
		Game.createBoardByLevel(board);
		Game.playGame(players, board);
	}

	private static void playGame(List<Player> players, Board board) {
		List<Ladder> ladderList = board.getLadderList();
		List<Snake> snakeList = board.getSnakeList();
		int diceOutcome, playerUpdatedPosition;
		boolean hasGameEnded = false;
		do {
			for (Player player : players) {
				diceOutcome = RandomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
				playerUpdatedPosition = LadderUtilities.getLadderTopPosition((player.getPosition() + diceOutcome),
						ladderList);
				player.setPosition(playerUpdatedPosition > GameProperties.NUM_POSITIONS_IN_BOARD ? player.getPosition()
						: playerUpdatedPosition);
				player.setPosition(SnakeUtilities.getSnakeTail(player.getPosition(), snakeList));
				if (player.getPosition() == GameProperties.NUM_POSITIONS_IN_BOARD) {
					System.out.println(player.hashCode() + " wins");
					hasGameEnded = true;
					break;
				}
			}
		} while (!hasGameEnded);
	}

	private static void createBoardByLevel(Board board) throws IOException {
		System.out.println("Enter Level Of the Game easy/hard :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String level = br.readLine();
		Level levelObj = new Level();
		levelObj.createLaddersAndSnakesOnLevel(level);
		board.generateValidBoard(Level.ladders, Level.snakes);
	}
}