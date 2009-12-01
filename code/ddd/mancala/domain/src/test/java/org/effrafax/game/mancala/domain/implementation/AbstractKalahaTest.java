/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class AbstractKalahaTest
{

	/**
	 * Test exceptions get thrown.
	 */
	@Test
	public void testUnimplementedFailure()
	{

		AbstractKalaha kalaha = new MockKalaha(Player.white, 4);

		try
		{

			kalaha.captureHeap();
			fail();
		}
		catch (IllegalStateException ise)
		{

			/* This is the expected behavior. */
		}

		try
		{

			kalaha.getOppositeBowl();
			fail();
		}
		catch (IllegalStateException ise)
		{

			/* This is the expected behavior. */
		}
	}

	/**
	 * Test if playable is correctly implemented.
	 */
	@Test
	public void testPlayable()
	{

		AbstractKalaha kalaha = new MockKalaha(Player.white);

		assertFalse(kalaha.playable());
	}

}
