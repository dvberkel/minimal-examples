/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dvberkel
 * 
 */
@SuppressWarnings("serial")
public class MockBowl extends AbstractBowl
{

	public MockBowl()
	{

		/* Parameterless constructor provided for the service loader */
	}

	public MockBowl(Player owner)
	{

		super(owner);
	}

	public MockBowl(Player owner, int numberOfStones)
	{

		super(owner, numberOfStones);
	}

	@Override
	public boolean receiveHeap(Heap heap)
	{

		/* This method is should not be tested so no implementation is given. */
		return false;
	}
}
