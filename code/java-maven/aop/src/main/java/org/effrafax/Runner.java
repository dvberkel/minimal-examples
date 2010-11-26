package org.effrafax;

import java.util.Arrays;

public class Runner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Factorizer factors = Factorizer.getInstance();

		Integer n = 1729;

		System.out.format("The factors of %d are %s", n, Arrays.toString(factors.of(n).toArray()));
	}

}
