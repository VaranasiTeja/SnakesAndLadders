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
		Level.levels();
		GameProperties.read();
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= GameProperties.MAX_PLAYERS; player++) {
			players.add(new Player());
		}
		Board board = new Board();
		Game.createLevel(board);
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
				player.setPosition(playerUpdatedPosition > GameProperties.MAX_POSITIONS_IN_BOARD ? player.getPosition()
						: playerUpdatedPosition);
				player.setPosition(SnakeUtilities.getSnakeTail(player.getPosition(), snakeList));
				if (player.getPosition() == GameProperties.MAX_POSITIONS_IN_BOARD) {
					System.out.println(player.hashCode() + " wins");
					hasGameEnded = true;
					break;
				}
			}
		} while (!hasGameEnded);
	}

	private static void createLevel(Board board) throws IOException {
		System.out.println("Enter Level Of the Game 1.easy 2.Hard :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean isValidBoard = false;
		while (!isValidBoard) {
			int level = Integer.parseInt(br.readLine());
			if (level == 1) {
				board.generateValidBoard(GameProperties.MAX_LADDERS + 3, 0);
				isValidBoard = true;
			} else if (level == 2) {
				board.generateValidBoard(0, GameProperties.MAX_SNAKES + 3);
				isValidBoard = true;
			} else {
				System.out.println("Enter Valid Level");
				continue;
			}
		}
	}
}