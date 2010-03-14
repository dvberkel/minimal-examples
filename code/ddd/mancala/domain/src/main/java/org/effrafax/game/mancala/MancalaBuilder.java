/**
 * 
 */
package org.effrafax.game.mancala;

import org.effrafax.game.mancala.domain.Player;
import org.effrafax.game.mancala.message.ExceptionMessage;

/**
 * This class is used in the construction of the a mancala game.
 * 
 * @author dvberkel
 */
public class MancalaBuilder {
	/**
	 * Default values for a MancalaBuilder
	 */
	private int numberOfBowls = 6;
	private int numberOfStones = 4;
	private Player startPlayer = Player.white;

	/**
	 * @return the numberOfBowls
	 */
	public int getNumberOfBowls() {
		return numberOfBowls;
	}

	/**
	 * @param numberOfBowls
	 *            the numberOfBowls to set
	 * @throws IllegalArgumentException
	 *             if {@code numberOfBowls} is less then one.
	 */
	public MancalaBuilder setNumberOfBowls(int numberOfBowls)
			throws IllegalArgumentException {
		if (numberOfBowls < 1) {
			throw new IllegalArgumentException(ExceptionMessage.NON_POSITIVE
					.toString());
		}
		this.numberOfBowls = numberOfBowls;
		return this;
	}

	/**
	 * @return the numberOfStones
	 */
	public int getNumberOfStones() {
		return numberOfStones;
	}

	/**
	 * @param numberOfStones
	 *            the numberOfStones to set
	 * @throws IllegalArgumentException
	 *             if {@code numberOfBowls} is less then one.
	 */
	public MancalaBuilder setNumberOfStones(int numberOfStones)
			throws IllegalArgumentException {
		if (numberOfStones < 1) {
			throw new IllegalArgumentException(ExceptionMessage.NON_POSITIVE
					.toString());
		}
		this.numberOfStones = numberOfStones;
		return this;
	}

	/**
	 * @return the startPlayer
	 */
	public Player getStartPlayer() {
		return startPlayer;
	}

	/**
	 * @param startPlayer
	 *            the startPlayer to set
	 * @throws IllegalArgumentException
	 *             if {@code startPlayer} is {@code null}.
	 */
	public MancalaBuilder setStartPlayer(Player startPlayer) {
		if (startPlayer == null) {
			throw new IllegalArgumentException(ExceptionMessage.NON_NULL
					.toString());
		}
		this.startPlayer = startPlayer;
		return this;
	}
}
