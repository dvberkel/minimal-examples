/**
 * 
 */
package org.effrafax.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.effrafax.delegate.interfaces.Eatable;
import org.effrafax.delegate.interfaces.Moveable;
import org.effrafax.delegate.interfaces.MoveableAndEatable;
import org.effrafax.delegate.interfaces.implementations.Car;
import org.effrafax.delegate.interfaces.implementations.Food;

/**
 * @author dvberkel
 * 
 */
public class run
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DelegateInvocationHandlerBuilder builder = new DelegateInvocationHandlerBuilder();
		builder.mapInterfaceToDelegateClass(Eatable.class, Food.class).mapInterfaceToDelegateClass(Moveable.class,
			Car.class);
		InvocationHandler invocationHandler = new DelegateInvocationHandler(builder);

		MoveableAndEatable boxOfFruit = (MoveableAndEatable) Proxy.newProxyInstance(run.class.getClassLoader(),
			new Class<?>[] { MoveableAndEatable.class }, invocationHandler);

		boxOfFruit.eat();
		boxOfFruit.move();
	}
}
