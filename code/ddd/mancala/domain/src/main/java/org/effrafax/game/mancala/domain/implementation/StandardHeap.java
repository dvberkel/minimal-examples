/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import java.io.Serializable;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Ownable;
import org.effrafax.game.mancala.domain.Player;
import org.effrafax.game.mancala.factory.implementation.OwnableFactory;
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
	private Ownable ownableDelegate = null;

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
	public StandardHeap(Player player, int numberOfStones) throws IllegalArgumentException {
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
			throw new IllegalArgumentException(ExceptionMessage.NON_NEGATIVE.toString());
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
	public void removeStone(int numberOfStones) throws IllegalArgumentException, IllegalStateException {
		if (numberOfStones < 0) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NEGATIVE.toString());
		}
		if (this.countStones() < numberOfStones) {
			throw new IllegalStateException(ExceptionMessage.TO_FEW_STONES.toString());
		}
		this.numberOfStones -= numberOfStones;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Heap#removeStone()
	 */
	public void removeStone() throws IllegalStateException {
		removeStone(1);
	}

	public Player getOwner() {
		return getOwnableDelegate().getOwner();
	}

	public void setOwner(Player owner) throws IllegalArgumentException {
		getOwnableDelegate().setOwner(owner);
	}

	public void changeOwner() {
		getOwnableDelegate().changeOwner();
	}

	private Ownable getOwnableDelegate() {
		if (ownableDelegate == null) {
			setOwnableDelegate(OwnableFactory.instance.getInstance());
		}
		return ownableDelegate;
	}

	private void setOwnableDelegate(Ownable ownableDelegate) {
		if (ownableDelegate == null) {
			throw new IllegalArgumentException(ExceptionMessage.BOWL_NULL.toString());
		}
		this.ownableDelegate = ownableDelegate;
	}
}
