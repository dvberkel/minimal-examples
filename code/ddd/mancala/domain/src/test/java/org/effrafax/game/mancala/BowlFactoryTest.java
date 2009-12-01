/**
 * 
 */
package org.effrafax.game.mancala;

import static org.junit.Assert.assertEquals;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class BowlFactoryTest
{

	/**
	 * Test if {@code Bowl} can be constructed.
	 */
	@Test
	public void testBowlConstruction()
	{

		BowlFactory factory = BowlFactory.instance;

		Bowl bowl = factory.getBowl(Player.white);

		assertEquals(Player.white, bowl.getOwner());
		assertEquals(0, bowl.countStones());

		bowl = factory.getBowl(Player.black, 1);

		assertEquals(Player.black, bowl.getOwner());
		assertEquals(1, bowl.countStones());
	}

	/**
	 * Test if {@code Kalaha} can be constructed.
	 */
	@Test
	public void testKalahaConstruction()
	{

		BowlFactory factory = BowlFactory.instance;

		Kalaha kalaha = factory.getKalaha(Player.white);

		assertEquals(Player.white, kalaha.getOwner());
		assertEquals(0, kalaha.countStones());

		kalaha = factory.getKalaha(Player.black, 1);

		assertEquals(Player.black, kalaha.getOwner());
		assertEquals(1, kalaha.countStones());
	}
}
