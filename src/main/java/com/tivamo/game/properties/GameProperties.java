package com.tivamo.game.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameProperties {
	public static int MAX_LADDERS;
	public static int MAX_POSITIONS_IN_BOARD;
	public static int DICE_OUTCOME_RANGE;
	public static int MAX_SNAKES;
	public static int MAX_PLAYERS;

	public static void read() throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream("global.properties");
		properties.load(input);
		MAX_LADDERS = Integer.parseInt(properties.getProperty("maxLadders"));
		MAX_SNAKES = Integer.parseInt(properties.getProperty("maxSnakes"));
		MAX_POSITIONS_IN_BOARD = Integer.parseInt(properties.getProperty("maxPositionsInBoard"));
		DICE_OUTCOME_RANGE = Integer.parseInt(properties.getProperty("diceOutcomeRange"));
		MAX_PLAYERS = Integer.parseInt(properties.getProperty("maxPlayers"));

	}
}
