/**
 * 
 */
package org.effrafax.delegate.interfaces.implementations;

import org.effrafax.delegate.interfaces.Eatable;

/**
 * @author dvberkel
 * 
 */
public class Food implements Eatable
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.delegate.interfaces.Eatable#eat()
	 */
	@Override
	public void eat()
	{
		System.out.println("The food has been eaten.");
	}

}
