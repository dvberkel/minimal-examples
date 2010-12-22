/**
 * 
 */
package org.effrafax.delegate.interfaces.implementations;

import org.effrafax.delegate.interfaces.Moveable;

/**
 * @author dvberkel
 * 
 */
public class Car implements Moveable
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.delegate.interfaces.Moveable#move()
	 */
	@Override
	public void move()
	{
		System.out.println("The car has moved.");

	}

}
