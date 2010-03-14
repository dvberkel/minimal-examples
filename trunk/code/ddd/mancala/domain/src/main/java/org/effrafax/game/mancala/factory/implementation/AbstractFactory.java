/**
 * 
 */
package org.effrafax.game.mancala.factory.implementation;

import java.util.ServiceLoader;

import org.effrafax.game.mancala.factory.Factory;

/**
 * @author dvberkel
 */
public abstract class AbstractFactory<T> implements Factory<T> {
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
	protected <S> S getInstance(Class<S> service) {
		ServiceLoader<S> serviceLoader = ServiceLoader.load(service);
		for (S provider : serviceLoader) {
			/* We are expecting only one provider */
			return provider;
		}
		throw new IllegalStateException("No provider registered for service "
				+ service.toString());
	}
}
