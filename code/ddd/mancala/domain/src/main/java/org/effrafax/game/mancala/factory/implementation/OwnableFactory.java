/**
 * 
 */
package org.effrafax.game.mancala.factory.implementation;

import org.effrafax.game.mancala.domain.Ownable;
import org.effrafax.game.mancala.factory.Factory;

/**
 * @author dvberkel
 */
public enum OwnableFactory implements Factory<Ownable> {
	instance;
	@Override
	public Ownable getInstance() {
		Ownable ownable = ServiceProviderFactory.getInstance(Ownable.class);
		return ownable;
	}
}
