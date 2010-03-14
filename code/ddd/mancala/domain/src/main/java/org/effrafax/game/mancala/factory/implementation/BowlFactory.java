/**
 * 
 */
package org.effrafax.game.mancala.factory.implementation;

import java.util.ServiceLoader;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;

/**
 * This enum can provide specific implementations of the following classes
 * <ul>
 * <li>org.effrafax.game.mancala.domain.Bowl</li>
 * <li>org.effrafax.game.mancala.domain.Kalaha</li>
 * <ul>
 * We use an enum as an implementation for the singleton pattern.
 * 
 * @author dvberkel
 * @see org.effrafax.game.mancala.domain.Bowl
 * @see org.effrafax.game.mancala.domain.Kalaha
 */
public enum BowlFactory {
	instance;
	/**
	 * Returns a specific provider of a service.
	 * 
	 * @param <S>
	 *            The generic class of the provider.
	 * @param service
	 *            The service.
	 * @return A provider for {@code service}.
	 * @see java.util.ServiceLoader<S>
	 */
	private <S> S getInstance(Class<S> service) {
		ServiceLoader<S> serviceLoader = ServiceLoader.load(service);
		for (S provider : serviceLoader) {
			/* We are expecting only one provider */
			return provider;
		}
		throw new IllegalStateException("No provider registered for service "
				+ service.toString());
	}

	/**
	 * Returns an empty {@code Bowl}.
	 * 
	 * @param owner
	 *            The {@code Player} who will own the {@code Bowl}.
	 * @return An empty {@code Bowl} owned by {@code player}.
	 */
	public Bowl getBowl(Player owner) {
		return getBowl(owner, 0);
	}

	/**
	 * Returns an {@code Bowl} with a number of stones.
	 * 
	 * @param owner
	 *            The {@code Player} who will own the {@code Bowl}.
	 * @param numberOfStones
	 *            The number of stones the {@code Bowl} will contain.
	 * @return An empty {@code Bowl} owned by {@code player}.
	 */
	public Bowl getBowl(Player owner, int numberOfStones) {
		Bowl bowl = getInstance(Bowl.class);
		bowl.initialize(owner, numberOfStones);
		return bowl;
	}

	/**
	 * Returns an empty {@code Kalaha}.
	 * 
	 * @param owner
	 *            The {@code Player} who will own the {@code Kalaha}.
	 * @return An empty {@code Kalaha} owned by {@code player}.
	 */
	public Kalaha getKalaha(Player owner) {
		return getKalaha(owner, 0);
	}

	/**
	 * Returns an {@code Kalaha} with a number of stones.
	 * 
	 * @param owner
	 *            The {@code Player} who will own the {@code Kalaha}.
	 * @param numberOfStones
	 *            The number of stones the {@code Kalaha} will contain.
	 * @return An empty {@code Kalaha} owned by {@code player}.
	 */
	public Kalaha getKalaha(Player owner, int numberOfStones) {
		Kalaha kalaha = getInstance(Kalaha.class);
		kalaha.initialize(owner, numberOfStones);
		return kalaha;
	}
}
