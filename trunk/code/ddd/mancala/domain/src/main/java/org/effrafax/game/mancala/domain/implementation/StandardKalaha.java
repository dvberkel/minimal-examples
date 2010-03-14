/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.StandardHeap;
import org.effrafax.game.mancala.domain.Player;

/**
 * This class represent a kalaha following the standard rule set.
 * 
 * @author dvberkel
 */
public class StandardKalaha extends AbstractKalaha {
	private static final long serialVersionUID = 37L;

	public StandardKalaha() {
	/* default constructor provided for the service loader */
	}

	public StandardKalaha(Player owner) {
		super(owner);
	}

	public StandardKalaha(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.game.mancala.domain.implementation.AbstractKalaha#receiveHeap
	 * (org.effrafax.game.mancala.domain.Heap)
	 */
	@Override
	public boolean receiveHeap(StandardHeap heap) {
		assert (heap.countStones() > 0);
		if (getOwner().equals(heap.getOwner())) {
			heap.removeStone();
			getHeap().addStone();
		}
		if (heap.countStones() > 0) {
			return getNextBowl().receiveHeap(heap);
		}
		return true;
	}
}
