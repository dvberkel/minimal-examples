package org.effrafax.minimal.guice;

import org.effrafax.minimal.guice.interfaces.Artist;
import org.effrafax.minimal.guice.module.ArtModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner
{
	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new ArtModule());
		Artist artist = injector.getInstance(Artist.class);
		artist.perform();
	}

}
