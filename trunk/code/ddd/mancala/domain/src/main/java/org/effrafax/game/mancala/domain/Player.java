/**
 * 
 */
package org.effrafax.game.mancala.domain;

/**
 * This enum represents players in the mancala game.
 * 
 * @author dvberkel
 */
public enum Player {
	white {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.effrafax.game.mancala.domain.Player#opponent()
		 */
		@Override
		public Player opponent() {
			return Player.black;
		}
	},
	black {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.effrafax.game.mancala.domain.Player#opponent()
		 */
		@Override
		public Player opponent() {
			return Player.white;
		}
	};
	/**
	 * Returns the opponent {@code Player} for this {@code Player}.
	 * 
	 * @return The opponent.
	 */
	public Player opponent() {
		throw new IllegalStateException("method should be overriden");
	}
}
