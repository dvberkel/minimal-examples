/**
 * 
 */
package org.effrafax.game.mancala.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class HeapTest
{

	/**
	 * Test the correct construction of {@code Heap}s.
	 */
	@Test
	public void testConstructors()
	{

		int numberOfStones = 1;

		assertEquals(0, (new StandardHeap(Player.white)).countStones());

		assertEquals(numberOfStones, (new StandardHeap(Player.white, numberOfStones)).countStones());
	}

	/**
	 * Tests if stones get added correctly.
	 */
	@Test
	public void testAddStone()
	{

		Heap heap = new StandardHeap(Player.white);

		heap.addStone();
		assertEquals(1, heap.countStones());

		heap.addStone(2);
		assertEquals(3, heap.countStones());

		Heap addedHeap = new StandardHeap(Player.white, 3);
		heap.addStone(addedHeap);
		assertEquals(6, heap.countStones());
		assertEquals(0, addedHeap.countStones());
	}

	/**
	 * Test if stones get removed correctly.
	 */
	@Test
	public void testRemoveStone()
	{

		Heap heap = new StandardHeap(Player.white, 3);

		heap.removeStone();
		assertEquals(2, heap.countStones());

		heap.removeStone(2);
		assertEquals(0, heap.countStones());
	}

	/**
	 * Test constructor with illegal arguments.
	 */
	@Test
	public void testConstructionFailure()
	{

		try
		{

			new StandardHeap(null);
			fail();
		}
		catch (IllegalArgumentException iae)
		{

			return; /* This exception is expected */
		}

		try
		{

			new StandardHeap(Player.white, -1);
			fail();
		}
		catch (IllegalArgumentException iae)
		{

			return; /* This exception is expected */
		}
	}

	/**
	 * Test {@code addStone(int)} with illegal arguments.
	 */
	@Test
	public void testAddStoneFailure()
	{

		try
		{

			(new StandardHeap(Player.white)).addStone(-1);
		}
		catch (IllegalArgumentException iae)
		{

			return; /* This exception is expected */
		}
	}

	/**
	 * Test {@code removeStone(int)} with illegal arguments.
	 */
	@Test
	public void testRemoveStoneFailure()
	{

		try
		{

			(new StandardHeap(Player.white)).removeStone(-1);
		}
		catch (IllegalArgumentException iae)
		{

			return; /* This exception is expected */
		}

		try
		{

			(new StandardHeap(Player.white)).removeStone(1);
		}
		catch (IllegalStateException iae)
		{

			return; /* This exception is expected */
		}
	}
}
