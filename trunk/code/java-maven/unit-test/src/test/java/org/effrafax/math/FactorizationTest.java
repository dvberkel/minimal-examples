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

	public FactorizationTest(FactorizationTestBuilder builder)
	{
		this.number = builder.getNumber();
		this.expectedResult = builder.getExpectedResult();
	}

	@Test
	public void factorize()
	{
		assertEquals(expectedResult, Factorization.factor(number));
	}

	@Parameters
	public static Collection<FactorizationTestBuilder[]> data()
	{
		List<FactorizationTestBuilder[]> data = new ArrayList<FactorizationTestBuilder[]>();
		data.add(new FactorizationTestBuilder[] { FactorizationTestBuilder.withNumber(2).expect(2) });
		data.add(new FactorizationTestBuilder[] { FactorizationTestBuilder.withNumber(8).expect(2, 2, 2) });
		data.add(new FactorizationTestBuilder[] { FactorizationTestBuilder.withNumber(9).expect(3, 3) });
		data.add(new FactorizationTestBuilder[] { FactorizationTestBuilder.withNumber(72).expect(2, 2, 2, 3, 3) });
		return data;
	}
}

class FactorizationTestBuilder
{
	private int number;

	private List<Integer> expectedResult = new ArrayList<Integer>();

	public static FactorizationTestBuilder withNumber(int number)
	{
		return new FactorizationTestBuilder(number);
	}

	private FactorizationTestBuilder(int number)
	{
		this.number = number;
	}

	public FactorizationTestBuilder expect(Integer... expectedResult)
	{
		this.expectedResult = Arrays.asList(expectedResult);
		return this;
	}

	public int getNumber()
	{
		return number;
	}

	public List<Integer> getExpectedResult()
	{
		return expectedResult;
	}
}