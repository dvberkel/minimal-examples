package org.effrafax.minimal.guice;

import org.effrafax.minimal.guice.implementations.GreekMuze;
import org.effrafax.minimal.guice.implementations.Painter;
import org.effrafax.minimal.guice.interfaces.Artist;

public class Runner
{
	public static void main(String[] args)
	{
		Artist artist = new Painter(new GreekMuze());
		artist.perform();
	}

}
