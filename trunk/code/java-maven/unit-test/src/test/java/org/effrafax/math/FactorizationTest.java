package org.effrafax.math;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class FactorizationTest
{
	@Test
	public void factorizationOf2Is2()
	{
		assertEquals(Arrays.asList(new Integer[] { 2 }), Factorization.factor(2));
	}
}
