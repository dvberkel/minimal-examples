/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class AbstractBowlTest
{

	/**
	 * Test if the constructor.
	 */
	@Test
	public void testConstructor()
	{

		AbstractBowl bowl = new MockBowl(Player.white, 4);

		assertEquals(Player.white, bowl.getOwner());
		assertEquals(4, bowl.countStones());
		assertNull(bowl.getNextBowl());
		assertNull(bowl.getOppositeBowl());
	}

	/**
	 * Test if the nextBowl is correctly set.
	 */
	@Test
	public void testNextBowl()
	{

		AbstractBowl first = new MockBowl(Player.white, 4);
		AbstractBowl second = new MockBowl(Player.white, 4);

		first.setNextBowl(second);
		assertEquals(second, first.getNextBowl());
	}

	/**
	 * Test repeated calls to setNextBowl fails.
	 */
	@Test
	public void testNextBowlFailure()
	{

		AbstractBowl bowl = new MockBowl(Player.white, 4);
		bowl.setNextBowl(new MockBowl(Player.white, 4));

		try
		{

			bowl.setNextBowl(null);
			fail();
		}
		catch (IllegalArgumentException iae)
		{

			/* this is the expected behavior. */
		}

		try
		{

			bowl.setNextBowl(new MockBowl(Player.white, 4));
			fail();
		}
		catch (IllegalStateException ise)
		{

			/* this is the expected behavior. */
		}
	}

	/**
	 * Test if the heap gets correctly captured.
	 */
	@Test
	public void testCaptureHeap()
	{

		AbstractBowl bowl = new MockBowl(Player.white, 4);

		Heap capturedHeap = bowl.captureHeap();

		assertEquals(4, capturedHeap.countStones());
		assertEquals(0, bowl.countStones());
	}

	/**
	 * Test if the opposite bowl gets correctly set.
	 */
	@Test
	public void testOppositeBowl()
	{

		AbstractBowl bowl = new MockBowl(Player.white, 4);
		AbstractBowl opposite = new MockBowl(Player.black, 4);

		bowl.setOppositeBowl(opposite);

		assertEquals(opposite, bowl.getOppositeBowl());
	}

	/**
	 * Test setOppositeBowl with illegal arguments.
	 */
	@Test
	public void testOppositeBowlFailure()
	{

		AbstractBowl bowl = new MockBowl(Player.white, 4);
		bowl.setOppositeBowl(new MockBowl(Player.black, 4));

		try
		{

			bowl.setOppositeBowl(null);
			fail();
		}
		catch (IllegalArgumentException iae)
		{

			/* This is the expected behavior */
		}

		try
		{

			bowl.setOppositeBowl(new MockBowl(Player.black, 4));
			fail();
		}
		catch (IllegalStateException ise)
		{

			/* This is the expected behavior */
		}
	}

	/**
	 * Test if playable is correctly implemented.
	 */
	@Test
	public void testPlayable()
	{

		AbstractBowl bowl = new MockBowl(Player.white);

		assertFalse(bowl.playable());

		bowl.getHeap().addStone();

		assertTrue(bowl.playable());
	}

}
