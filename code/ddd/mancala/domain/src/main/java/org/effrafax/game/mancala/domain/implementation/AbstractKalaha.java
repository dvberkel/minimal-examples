/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;
import org.effrafax.game.mancala.message.ExceptionMessage;

/**
 * @author dvberkel
 */
public abstract class AbstractKalaha extends AbstractBowl implements Kalaha {
	private static final long serialVersionUID = 37L;

	public AbstractKalaha() {
		super();
	}

	public AbstractKalaha(Player owner) {
		this(owner, 0);
	}

	public AbstractKalaha(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.game.mancala.domain.implementation.AbstractBowl#captureHeap
	 * ()
	 */
	@Override
	public Heap captureHeap() {
		throw new IllegalStateException(
				ExceptionMessage.NO_SUCH_OBJECT_FOR_KALAHA.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * 
	 * org.effrafax.game.mancala.domain.implementation.AbstractBowl#collectHeap(org
	 * .effrafax.game.mancala.domain.Heap)
	 */
	@Override
	public void collectHeap(Heap heap) {
		this.getHeap().addStone(heap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.game.mancala.domain.implementation.AbstractBowl#getKahala()
	 */
	@Override
	public Kalaha getKahala() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.game.mancala.domain.implementation.AbstractBowl#getOppositeBowl
	 * ()
	 */
	@Override
	public Bowl getOppositeBowl() {
		throw new IllegalStateException(
				ExceptionMessage.NO_SUCH_OBJECT_FOR_KALAHA.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.game.mancala.domain.implementation.AbstractBowl#playable()
	 */
	@Override
	public boolean playable() {
		return false;
	}
}
