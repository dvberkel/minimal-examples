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
public class StandardHeap implements Serializable {
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

	/**
	 * Counts the number of stones in this {@code Heap}.
	 * 
	 * @return The number of stones in this {@code Heap}.
	 */
	public int countStones() {
		return numberOfStones;
	}

	/**
	 * Adds a number of stones to this {@code Heap}. The amount added should be
	 * non-negative or else an exception is
	 * thrown.
	 * 
	 * @param numberOfStones
	 *            The number of stones added to this {@code Heap}.
	 * @throws IllegalArgumentException
	 *             if {@code numberOfStones} is negative.
	 */
	public void addStone(int numberOfStones) throws IllegalArgumentException {
		if (numberOfStones < 0) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NEGATIVE
					.toString());
		}
		this.numberOfStones += numberOfStones;
	}

	/**
	 * Adds one stone to this {@code Heap}. If you want to add multiple stones
	 * in one go, see {@code addStone(int)}.
	 * 
	 * @see org.effrafax.game.mancala.domain.Heap.addStone(int)
	 */
	public void addStone() {
		addStone(1);
	}

	/**
	 * Adds all the stones of {@code heap} to this {@code Heap}.
	 * 
	 * @param heap
	 *            The heap which stones get added to this {@code Heap}.
	 */
	public void addStone(StandardHeap heap) {
		int numberOfStones = heap.countStones();
		heap.removeStone(numberOfStones);
		this.addStone(numberOfStones);
	}

	/**
	 * Removes a number of stones from this {@code Heap}. An exception is thrown
	 * in the following circumstances:
	 * <ul>
	 * <li>The number of stones is negative.</li>
	 * <li>This {@code Heap} does not contain the said number of stones.</li>
	 * </ul>
	 * 
	 * @param numberOfStones
	 *            The number of stones removed from this {@code Heap}.
	 * @throws IllegalArgumentException
	 *             if {@code numberOfStones} is negative.
	 * @throws IllegalStateException
	 *             if this {@code Heap} does not contain at least {@code
	 *             numberOfStones} stones.
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

	/**
	 * Removes one stone from this {@code Heap}. An IllegalStateException is
	 * thrown if this {@Heap} does not
	 * contain one stone.
	 * 
	 * @throws IllegalStateException
	 *             If this {@code Heap} does not contain one stone.
	 */
	public void removeStone() throws IllegalStateException {
		removeStone(1);
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Setter for the owner of this {@code Heap}. An exception is thrown if
	 * {@code owner} is null.
	 * 
	 * @param owner
	 *            the owner to set
	 * @throws IllegalArgumentException
	 *             if {@code owner} is null.
	 */
	public void setOwner(Player owner) throws IllegalArgumentException {
		if (owner == null) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NULL
					.toString());
		}
		this.owner = owner;
	}

	/**
	 * Changes the ownership of this {@code Heap} to the opponent of the current
	 * owner.
	 */
	public void changeOwner() {
		setOwner(getOwner().opponent());
	}
}
