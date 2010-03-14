package org.effrafax.game.mancala.domain;

public interface Heap extends Ownable {
	/**
	 * Counts the number of stones in this {@code Heap}.
	 * 
	 * @return The number of stones in this {@code Heap}.
	 */
	public abstract int countStones();

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
	public abstract void addStone(int numberOfStones)
			throws IllegalArgumentException;

	/**
	 * Adds one stone to this {@code Heap}. If you want to add multiple stones
	 * in one go, see {@code addStone(int)}.
	 * 
	 * @see org.effrafax.game.mancala.domain.Heap.addStone(int)
	 */
	public abstract void addStone();

	/**
	 * Adds all the stones of {@code heap} to this {@code Heap}.
	 * 
	 * @param heap
	 *            The heap which stones get added to this {@code Heap}.
	 */
	public abstract void addStone(Heap heap);

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
	public abstract void removeStone(int numberOfStones)
			throws IllegalArgumentException, IllegalStateException;

	/**
	 * Removes one stone from this {@code Heap}. An IllegalStateException is
	 * thrown if this {@Heap} does not
	 * contain one stone.
	 * 
	 * @throws IllegalStateException
	 *             If this {@code Heap} does not contain one stone.
	 */
	public abstract void removeStone() throws IllegalStateException;
}
