package com.tivamo.game.laddertest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.ladder.LadderManager;

public class LaddersManagerTest {
	LadderManager ladders = new LadderManager();

	@Test
	public void testLaddersList() {
		LadderManager laddersObject = new LadderManager();
		List<Ladder> ladders = laddersObject.generateLadderList(4);
		Assert.assertEquals(4, ladders.size());
		List<Ladder> newLadders = laddersObject.generateLadderList(6);
		Assert.assertEquals(6, newLadders.size());
		Assert.assertNotEquals(ladders.get(0), newLadders.get(0));
	}

	@Test
	public void testShouldNotHang() {
		LadderManager laddersObject = new LadderManager();
		List<Ladder> ladders = laddersObject.generateLadderList(4);
		Assert.assertEquals(4, ladders.size());
		List<Ladder> newLadders = laddersObject.generateLadderList(1);
		Assert.assertEquals(1, newLadders.size());
	}

}
