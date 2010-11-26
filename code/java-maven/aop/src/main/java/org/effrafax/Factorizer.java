package org.effrafax;

import java.util.ArrayList;
import java.util.List;

public class Factorizer
{
	private static Factorizer factors;

	public static Factorizer getInstance()
	{
		if (factors == null)
		{
			factors = new Factorizer();
		}
		return factors;
	}

	private Factorizer()
	{

	}

	public List<Integer> of(int n)
	{
		List<Integer> result = new ArrayList<Integer>();
		int d = 2;
		while (d <= n)
		{
			while (n % d == 0)
			{
				result.add(d);
				n /= d;
			}
			d += 1;
		}

		return result;
	}
}
