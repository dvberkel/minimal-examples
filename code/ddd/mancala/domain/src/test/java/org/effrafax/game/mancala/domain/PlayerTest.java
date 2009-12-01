/**
 * 
 */
package org.effrafax.game.mancala.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class PlayerTest
{

	/**
	 * This test asserts the correct behavior of the opponent method.
	 */
	@Test
	public void testOpponent()
	{

		Player white = Player.white;
		Player black = Player.black;

		assertEquals(black, white.opponent());

		assertEquals(white, black.opponent());
	}
}
