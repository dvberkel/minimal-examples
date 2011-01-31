package org.junit.runners;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class ParameterizedWithBuilder extends Suite
{
	private class TestClassRunnerForParametersWithBuilder extends BlockJUnit4ClassRunner
	{
		private final int fParameterSetNumber;

		private final List<Object> fParameterList;

		TestClassRunnerForParametersWithBuilder(Class<?> type, List<Object> parametersList, int i)
			throws InitializationError
		{
			super(type);
			fParameterList = parametersList;
			fParameterSetNumber = i;
		}

		@Override
		public Object createTest() throws Exception
		{
			return getTestClass().getOnlyConstructor().newInstance(computeParams());
		}

		private Object computeParams() throws Exception
		{
			try
			{
				return fParameterList.get(fParameterSetNumber);
			}
			catch (ClassCastException e)
			{
				throw new Exception(String.format("%s.%s() must return a Collection of objects.", getTestClass()
					.getName(), getParametersMethod(getTestClass()).getName()));
			}
		}

		@Override
		protected String getName()
		{
			return String.format("[%s]", fParameterSetNumber);
		}

		@Override
		protected String testName(final FrameworkMethod method)
		{
			return String.format("%s[%s]", method.getName(), fParameterSetNumber);
		}

		@Override
		protected void validateConstructor(List<Throwable> errors)
		{
			validateOnlyOneConstructor(errors);
		}

		@Override
		protected Statement classBlock(RunNotifier notifier)
		{
			return childrenInvoker(notifier);
		}
	}

	private List<Runner> runners = new ArrayList<Runner>();

	public ParameterizedWithBuilder(Class<?> klass) throws Throwable
	{
		super(klass, Collections.<Runner> emptyList());
		List<Object> parametersList = getParametersList(getTestClass());
		for (int i = 0; i < parametersList.size(); i++)
			runners.add(new TestClassRunnerForParametersWithBuilder(getTestClass().getJavaClass(), parametersList, i));

	}

	@Override
	protected List<Runner> getChildren()
	{
		return runners;
	}

	@SuppressWarnings("unchecked")
	private List<Object> getParametersList(TestClass testClass) throws Throwable
	{
		return (List<Object>) getParametersMethod(testClass).invokeExplosively(null);
	}

	private FrameworkMethod getParametersMethod(TestClass testClass) throws Exception
	{
		List<FrameworkMethod> methods = testClass.getAnnotatedMethods(Parameters.class);
		for (FrameworkMethod each : methods)
		{
			int modifiers = each.getMethod().getModifiers();
			if (Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers))
				return each;
		}

		throw new Exception("No public static parameters method on class " + testClass.getName());
	}

}
