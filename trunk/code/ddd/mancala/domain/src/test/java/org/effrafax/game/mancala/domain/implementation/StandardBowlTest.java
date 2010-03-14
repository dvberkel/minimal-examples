/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import static org.junit.Assert.assertEquals;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class StandardBowlTest
{

	/**
	 * Test if {@code Heap} are correctly received.
	 */
	@Test
	public void testReceiveHeap()
	{

		Bowl bowl = new StandardBowl(Player.white, 1);
		Heap heap = new StandardHeap(Player.black, 1);

		bowl.receiveHeap(heap);

		assertEquals(2, bowl.countStones());
		assertEquals(0, heap.countStones());

		Bowl secondBowl = new StandardBowl(Player.white, 1);
		bowl.setNextBowl(secondBowl);

		heap = new StandardHeap(Player.black, 2);

		bowl.receiveHeap(heap);
		assertEquals(3, bowl.countStones());
		assertEquals(2, secondBowl.countStones());
		assertEquals(0, heap.countStones());
	}

	/**
	 * Test if captures are made correctly.
	 */
	@Test
	public void testCapture()
	{

		Bowl bowl = new StandardBowl(Player.white, 0);
		Bowl oppositeBowl = new StandardBowl(Player.black, 1);

		bowl.setOppositeBowl(oppositeBowl);
		bowl.setNextBowl(new MockKalaha(Player.white, 0));

		Heap heap = new StandardHeap(Player.white, 1);

		bowl.receiveHeap(heap);

		assertEquals(0, bowl.countStones());
		assertEquals(0, oppositeBowl.countStones());
		assertEquals(2, bowl.getKahala().countStones());
	}
}
