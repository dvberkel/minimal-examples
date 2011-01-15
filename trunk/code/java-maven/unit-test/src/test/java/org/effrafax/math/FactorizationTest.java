package org.effrafax.math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FactorizationTest
{
	private int number;

	private List<Integer> expectedResult;

	public FactorizationTest(int number, Integer[] result)
	{
		this.number = number;
		this.expectedResult = Arrays.asList(result);
	}

	@Test
	public void factorize()
	{
		assertEquals(expectedResult, Factorization.factor(number));
	}

	@Parameters
	public static Collection<Object[]> data()
	{
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] { 2, new Integer[] { 2 } });
		data.add(new Object[] { 8, new Integer[] { 2, 2, 2 } });
		data.add(new Object[] { 9, new Integer[] { 3, 3 } });
		data.add(new Object[] { 72, new Integer[] { 2, 2, 2, 3, 3 } });
		return data;
	}
}
