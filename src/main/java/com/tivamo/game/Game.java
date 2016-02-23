package com.tivamo.game;

import java.io.IOException;
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
		RandomNumber randomNumber = new RandomNumber();
		Board board = new Board();
		board.generateValidBoard();
		int diceOutcome, playerUpdatedPosition;
		List<Ladder> ladderList = board.getLadderList();
		List<Snake> snakeList = board.getSnakeList();
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= GameProperties.MAX_PLAYERS; player++) {
			players.add(new Player());
		}
		boolean hasGameEnded = false;
		do {
			for (Player player : players) {
				diceOutcome = randomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
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

}
