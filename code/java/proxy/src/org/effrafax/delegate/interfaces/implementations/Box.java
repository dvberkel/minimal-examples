package org.effrafax.delegate.interfaces.implementations;

import org.effrafax.delegate.interfaces.Moveable;

public class Box implements Moveable
{

	@Override
	public void move()
	{
		System.out.println("the box has moved");
	}

}
