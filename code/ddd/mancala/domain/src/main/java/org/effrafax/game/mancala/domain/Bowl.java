/**
 * 
 */
package org.effrafax.game.mancala.domain;

/**
 * This interface represents a bowl in the mancala game.
 * 
 * @author dvberkel
 */
public interface Bowl {
	/**
	 * Initializes this {@code Bowl}. The owning player and the number of stones
	 * will be set for this {@code Bowl}.
	 * 
	 * @param owner
	 *            The {@code Player} who will own this {@code Bowl}
	 * @param numberOfStones
	 *            The number of stones this {@code Bowl} will contain.
	 */
	public void initialize(Player owner, int numberOfStones);

	/**
	 * Counts the number of stones in this {@code Bowl}s {@code Heap}.
	 * 
	 * @return The number of stones in the {@code Heap} of this {@code Bowl}.
	 */
	public int countStones();

	/**
	 * Returns the owner of this {@code Bowl}.
	 * 
	 * @return The owner of this {@code Bowl}.
	 */
	public Player getOwner();

	/**
	 * Returns the {@code Bowl} which follows this {@code Bowl}.
	 * 
	 * @return The {@code Bowl} following this {@code Bowl}.
	 */
	public Bowl getNextBowl();

	/**
	 * Sets the next {@code Bowl} for this {@code Bowl}. An exception is thrown
	 * if the next bowl is already set or when {@code nextBowl} is {@code null}.
	 * 
	 * @param nextBowl
	 *            The {@code Bowl} following this {@code Bowl}.
	 * @throws IllegalArgumentException
	 *             if {@code nextBowl} is {@code null}.
	 * @throws IllegalStateException
	 *             if the next bowl is already set.
	 */
	public void setNextBowl(Bowl nextBowl) throws IllegalArgumentException,
			IllegalStateException;

	/**
	 * Returns the {@code Bowl} which is opposite to this {@code Bowl}.
	 * 
	 * @return The opposite {@code Bowl}.
	 */
	public Bowl getOppositeBowl();

	/**
	 * Sets the opposite {@code Bowl} for this {@code Bowl}. An exception is
	 * thrown if the opposite bowl is already set
	 * or when {@code oppositeBowl} is {@code null}.
	 * 
	 * @param oppositeBowl
	 *            The {@code Bowl} opposite to this {@code Bowl}.
	 * @throws IllegalArgumentException
	 *             if {@code oppositeBowl} is {@code null}.
	 * @throws IllegalStateException
	 *             if the opposite bowl is already set.
	 */
	public void setOppositeBowl(Bowl oppositeBowl)
			throws IllegalArgumentException, IllegalStateException;

	/**
	 * This method performs the action for this {@code Bowl} when a {@code Heap}
	 * is distributed across all {@code Bowl} s.
	 * 
	 * @param heap
	 *            The {@code Heap} that is distributed.
	 * @return {@code true} if the an other turn can be made, {@code false}
	 *         otherwise.
	 */
	public boolean receiveHeap(StandardHeap heap);

	/**
	 * Captures the {@code Heap} of this {@code Bowl}.
	 * 
	 * @return The captured {@code Heap}.
	 */
	public StandardHeap captureHeap();

	/**
	 * Collects a captured {@code Heap}.
	 * 
	 * @param heap
	 *            The {@code Heap} that is captured.
	 */
	public void collectHeap(StandardHeap heap);

	/**
	 * Returns the {@code Kalaha} of the {@code Player} who owns this {@code
	 * Bowl}.
	 * 
	 * @return The {@code Kalaha} of the {@code Player} who owns this {@code
	 *         Bowl}.
	 */
	public Kalaha getKahala();

	/**
	 * Plays this {@code Bowl}. A play consist of letting the next {@code Bowl}
	 * recieve the heap of this {@code Bowl}.
	 * An exception is thrown is this {@code Bowl} is not playable.
	 * 
	 * @return {@code true} if the current {@code Player} can take an other
	 *         turn, {@code false} otherwise.
	 * @throws IllegalArgumentException
	 *             if this {@code Bowl} is not playable.
	 */
	public boolean play() throws IllegalArgumentException;

	/**
	 * Returns if this {@code Bowl} is playable. A {@code Bowl} is playable if
	 * it is not a {@code Kalaha} and has
	 * non-zero amount of stones.
	 * 
	 * @return {@code true} if this {@code Bowl} is playable, {@code false}
	 *         othwise.
	 */
	public boolean playable();
}
