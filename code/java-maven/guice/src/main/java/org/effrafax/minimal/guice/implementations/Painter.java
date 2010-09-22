package org.effrafax.minimal.guice.implementations;

import org.effrafax.minimal.guice.interfaces.Muze;

import com.google.inject.Inject;

public class Painter extends AbstractArtist
{
	@Inject
	public Painter(Muze muze)
	{
		super(muze);
	}

	@Override
	protected String workOfArt()
	{
		return "piece of art";
	}

}
