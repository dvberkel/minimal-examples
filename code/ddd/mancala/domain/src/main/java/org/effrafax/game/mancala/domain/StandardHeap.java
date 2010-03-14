/**
 * 
 */
package org.effrafax.game.mancala.domain;

import java.io.Serializable;

import org.effrafax.game.mancala.message.ExceptionMessage;

/**
 * This class represents all the heaps of stones in the mancala game.
 * 
 * @author dvberkel
 */
public class StandardHeap implements Heap, Serializable {
	private static final long serialVersionUID = 37L;
	private int numberOfStones = 0;
	private Player owner = null;

	/**
	 * Returns an empty {@code Heap}.
	 * 
	 * @param player
	 *            The owner of this {@code Heap}.
	 */
	public StandardHeap(Player player) {
		this.setOwner(player);
	}

	/**
	 * Returns a {@code Heap} with a preset number of stones. The preset number
	 * of stones should be non-negative,
	 * otherwise an IllegalArgumentException is thrown.
	 * 
	 * @param player
	 *            The owner of this {@code Heap}.
	 * @param numberOfStones
	 *            The preset number of stones.
	 * @throws IllegalArgumentException
	 *             if {@code numberOfStones} is negative.
	 */
	public StandardHeap(Player player, int numberOfStones)
			throws IllegalArgumentException {
		this(player);
		this.addStone(numberOfStones);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#countStones()
	 */
	public int countStones() {
		return numberOfStones;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#addStone(int)
	 */
	public void addStone(int numberOfStones) throws IllegalArgumentException {
		if (numberOfStones < 0) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NEGATIVE
					.toString());
		}
		this.numberOfStones += numberOfStones;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#addStone()
	 */
	public void addStone() {
		addStone(1);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#addStone(org.effrafax.game.mancala.domain.Heap)
	 */
	public void addStone(Heap heap) {
		int numberOfStones = heap.countStones();
		heap.removeStone(numberOfStones);
		this.addStone(numberOfStones);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#removeStone(int)
	 */
	public void removeStone(int numberOfStones)
			throws IllegalArgumentException, IllegalStateException {
		if (numberOfStones < 0) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NEGATIVE
					.toString());
		}
		if (this.countStones() < numberOfStones) {
			throw new IllegalStateException(ExceptionMessage.TO_FEW_STONES
					.toString());
		}
		this.numberOfStones -= numberOfStones;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#removeStone()
	 */
	public void removeStone() throws IllegalStateException {
		removeStone(1);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#getOwner()
	 */
	public Player getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#setOwner(org.effrafax.game.mancala.domain.Player)
	 */
	public void setOwner(Player owner) throws IllegalArgumentException {
		if (owner == null) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NULL
					.toString());
		}
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#changeOwner()
	 */
	public void changeOwner() {
		setOwner(getOwner().opponent());
	}
}
