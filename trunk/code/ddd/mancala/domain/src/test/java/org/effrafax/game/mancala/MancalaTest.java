/**
 * 
 */
package org.effrafax.game.mancala;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class MancalaTest
{

	/**
	 * Test the construction of a mancala game.
	 */
	@Test
	public void testConstruction()
	{

		int[] expected = { 0, 1, 2, 3 };

		MancalaBuilder builder = new MancalaBuilder().setNumberOfBowls(4).setNumberOfStones(2);

		Mancala game = new Mancala(builder);

		assertEquals(Player.white, game.getCurrentPlayer());

		for (int turn = 0; turn < 2; turn++)
		{

			List<Integer> options = game.options();

			assertEquals(expected.length, options.size());
			for (int index = 0; index < expected.length; index++)
			{

				assertEquals(expected[index], (int) options.get(index));
			}

			game.endTurn();
		}
	}

	/**
	 * Test playing bowl.
	 */
	@Test
	public void testPlay()
	{

		int[] expected = { 1, 2, 3 };

		MancalaBuilder builder = new MancalaBuilder().setNumberOfBowls(4).setNumberOfStones(2);

		Mancala game = new Mancala(builder);

		game.play(0);
		assertEquals(Player.black, game.getCurrentPlayer());

		game.play(0);
		assertEquals(Player.white, game.getCurrentPlayer());

		for (int turn = 0; turn < 2; turn++)
		{

			List<Integer> options = game.options();

			assertEquals(expected.length, options.size());
			for (int index = 0; index < expected.length; index++)
			{

				assertEquals(expected[index], (int) options.get(index));
			}

			game.endTurn();
		}
	}
}
