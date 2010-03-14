/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.StandardHeap;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dvberkel
 * 
 */
@SuppressWarnings("serial")
public class MockKalaha extends AbstractKalaha
{

	public MockKalaha()
	{

		/* Parameterless constructor provided for the service loader */
	}

	public MockKalaha(Player owner)
	{

		super(owner);
	}

	public MockKalaha(Player owner, int numberOfStones)
	{

		super(owner, numberOfStones);
	}

	@Override
	public boolean receiveHeap(StandardHeap heap)
	{

		/* This method is should not be tested so no implementation is given. */
		return false;
	}
}
