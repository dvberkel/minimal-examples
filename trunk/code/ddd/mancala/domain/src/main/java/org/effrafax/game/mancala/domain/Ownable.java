package org.effrafax.game.mancala.domain;

public interface Ownable {
	/**
	 * @return the owner
	 */
	public abstract Player getOwner();

	/**
	 * Setter for the owner of this {@code Heap}. An exception is thrown if
	 * {@code owner} is null.
	 * 
	 * @param owner
	 *            the owner to set
	 * @throws IllegalArgumentException
	 *             if {@code owner} is null.
	 */
	public abstract void setOwner(Player owner) throws IllegalArgumentException;

	/**
	 * Changes the ownership of this {@code Heap} to the opponent of the current
	 * owner.
	 */
	public abstract void changeOwner();
}
