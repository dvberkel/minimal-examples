/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Ownable;
import org.effrafax.game.mancala.domain.Player;
import org.effrafax.game.mancala.message.ExceptionMessage;

/**
 * @author dvberkel
 */
public class StandardOwnable implements Ownable {
	private Player owner = null;

	@Override
	public void changeOwner() {
		setOwner(getOwner().opponent());
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public void setOwner(Player owner) throws IllegalArgumentException, IllegalStateException {
		if (owner == null) {
			throw new IllegalArgumentException(ExceptionMessage.OWNER_NULL.toString());
		}
		if (this.owner != null) {
			throw new IllegalStateException(ExceptionMessage.OWNER_ASSIGNED.toString());
		}
		this.owner = owner;
	}
}
