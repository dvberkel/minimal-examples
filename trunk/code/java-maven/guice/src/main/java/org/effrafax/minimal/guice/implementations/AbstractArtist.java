package org.effrafax.minimal.guice.implementations;

import org.effrafax.minimal.guice.interfaces.Artist;
import org.effrafax.minimal.guice.interfaces.Muze;

public abstract class AbstractArtist implements Artist
{
	private final Muze muze;

	protected AbstractArtist(Muze muze)
	{
		this.muze = muze;
	}

	@Override
	public void perform()
	{
		System.out.format("I created a %s %s\n", getMuze().inspire(), workOfArt());
	}

	protected abstract String workOfArt();

	public Muze getMuze()
	{
		return muze;
	}
}
