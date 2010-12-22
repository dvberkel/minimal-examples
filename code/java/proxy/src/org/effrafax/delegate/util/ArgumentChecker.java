/**
 * 
 */
package org.effrafax.delegate.util;

/**
 * @author dvberkel
 * 
 */
public abstract class ArgumentChecker
{
	public static void checkIfArgumentsAreNotNull(Object... arguments)
	{
		for (Object argument : arguments)
		{
			throwExceptionIfArgumentIsNull(argument);
		}
	}

	private static void throwExceptionIfArgumentIsNull(Object argument)
	{
		if (isNull(argument))
		{
			throw new IllegalArgumentException(String.format("Argument %s should not be null", argument.toString()));
		}
	}

	public static boolean isNull(Object argument)
	{
		return argument == null;
	}

}
