/**
 * 
 */
package org.effrafax.game.mancala.message;

/**
 * This enum provides various error messages for the domain.
 * 
 * @author dvberkel
 * 
 */
public enum ExceptionMessage
{

	NON_NULL("argument should be non null."), //
	NON_NEGATIVE("argument should be non-negative."), //
	NON_POSITIVE("argument should be greater then zero."), //
	NON_NULL_NEGATIVE(NON_NULL, NON_NEGATIVE), //
	ALREADY_ASSIGNED("argument is already assigned."), //
	TO_FEW_STONES("heap does not contain enough stones."), //
	NO_SUCH_OBJECT_FOR_KALAHA("there is no such a thing for a kalaha."), //
	BOWL("a bowl argument exception."), //
	BOWL_NULL(BOWL, NON_NULL), //
	BOWL_ASSIGNED(BOWL, ALREADY_ASSIGNED), //
	OWNER("a owner argument exception."), //
	OWNER_NULL(OWNER, NON_NULL), //
	OWNER_ASSIGNED(OWNER, ALREADY_ASSIGNED), //
	NOT_PLAYABLE("the bowl is not playable."), //
	VALID_OPTION("please enter a valid option."), //
	UNRECOVERABLE("Aaaaargh, the pain, the agony, help me, help!");

	private String message = "an exception has occured";

	private ExceptionMessage[] exceptionMessages = {};

	private boolean messageGenerated = false;

	private ExceptionMessage(String message)
	{

		this(message, new ExceptionMessage[] {});
	}

	private ExceptionMessage(ExceptionMessage... exceptionMessages)
	{

		this("", exceptionMessages);
	}

	private ExceptionMessage(String message, ExceptionMessage... exceptionMessages)
	{

		this.message = message;
		this.exceptionMessages = exceptionMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{

		if (exceptionMessages.length != 0 && !messageGenerated)
		{
			StringBuilder builder = new StringBuilder();
			for (int index = 0; index < exceptionMessages.length; index++)
			{

				builder.append(exceptionMessages[index]);
			}

			message = builder.toString();
			messageGenerated = true;
		}

		return message;
	}
}
