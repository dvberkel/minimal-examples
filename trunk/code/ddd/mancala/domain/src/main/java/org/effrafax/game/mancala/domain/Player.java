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
		@Override
		public Player opponent() {
			return Player.black;
		}
	},
	black {
		@Override
		public Player opponent() {
			return Player.white;
		}
	};
	abstract public Player opponent();
}
