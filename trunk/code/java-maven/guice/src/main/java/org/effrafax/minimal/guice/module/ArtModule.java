package org.effrafax.minimal.guice.module;

import org.effrafax.minimal.guice.implementations.GreekMuze;
import org.effrafax.minimal.guice.implementations.Painter;
import org.effrafax.minimal.guice.interfaces.Artist;
import org.effrafax.minimal.guice.interfaces.Muze;

import com.google.inject.AbstractModule;

public class ArtModule extends AbstractModule
{
	@Override
	protected void configure()
	{
		bind(Artist.class).to(Painter.class);
		bind(Muze.class).to(GreekMuze.class);
	}

}
