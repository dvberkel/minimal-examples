package org.effrafax.math;

import java.util.ArrayList;
import java.util.List;

public class Factorization
{

	public static List<Integer> factor(int n)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();

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