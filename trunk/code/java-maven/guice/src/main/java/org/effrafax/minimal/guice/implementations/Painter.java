package org.effrafax.minimal.guice.implementations;

import org.effrafax.minimal.guice.interfaces.Artist;
import org.effrafax.minimal.guice.interfaces.Muze;

public class Painter implements Artist
{
	private Muze muze;

	public Painter(Muze muze)
	{
		this.muze = muze;
	}

	protected String workOfArt()
	{
		return "painting";
	}

	@Override
	public void perform()
	{
		System.out.format("I created a %s %s\n", muze.inspire(), workOfArt());
	}

}
