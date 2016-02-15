package main;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class LaddersListTest {
	LaddersList ladders = new LaddersList();

	@Test
	public void testLaddersList() {
		LaddersList ladders = new LaddersList();
		List<Ladder> laddersSize = ladders.generateLaddersList(4);
		Assert.assertEquals(4, laddersSize.size());
		List<Ladder> newLaddersSize = ladders.generateLaddersList(6);
		Assert.assertEquals(6, newLaddersSize.size());
		Assert.assertNotEquals(laddersSize.get(0), newLaddersSize.get(0));
	}
	
	@Test
	public void testShouldNotHang() {
		LaddersList ladders = new LaddersList();
		List<Ladder> laddersSize = ladders.generateLaddersList(4);
		Assert.assertEquals(4, laddersSize.size());
		List<Ladder> newLaddersSize = ladders.generateLaddersList(1);
		Assert.assertEquals(1, newLaddersSize.size());
	}

}
