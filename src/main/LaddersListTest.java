package main;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LaddersListTest {
	LadderList ladders = new LadderList();

	@Test
	public void testLaddersList() {
		LadderList laddersObject = new LadderList();
		List<Ladder> ladders = laddersObject.generateLadderList(4);
		Assert.assertEquals(4, ladders.size());
		List<Ladder> newLadders = laddersObject.generateLadderList(6);
		Assert.assertEquals(6, newLadders.size());
		Assert.assertNotEquals(ladders.get(0), newLadders.get(0));
	}

	@Test
	public void testShouldNotHang() {
		LadderList laddersObject = new LadderList();
		List<Ladder> ladders = laddersObject.generateLadderList(4);
		Assert.assertEquals(4, ladders.size());
		List<Ladder> newLadders = laddersObject.generateLadderList(1);
		Assert.assertEquals(1, newLadders.size());
	}

}
