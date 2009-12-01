/**
 * 
 */
package org.effrafax.game.mancala;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Player;
import org.effrafax.game.mancala.message.ExceptionMessage;

/**
 * @author dvberkel
 * 
 */
public class Mancala implements Serializable
{
	private static final long serialVersionUID = 37L;

	private Player currentPlayer = null;

	Map<Player, Bowl> startBowlMap = null;

	public Mancala(MancalaBuilder builder)
	{

		setCurrentPlayer(builder.getStartPlayer());
		setStartBowlMap(BoardFactory.createBoard(builder));
	}

	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer()
	{

		return currentPlayer;
	}

	/**
	 * Ends a turn for the current player. The opponent will become the current player and take a turn.
	 */
	public void endTurn()
	{

		setCurrentPlayer(getCurrentPlayer().opponent());
	}

	/**
	 * @param currentPlayer
	 *            the currentPlayer to set
	 */
	private void setCurrentPlayer(Player currentPlayer)
	{

		this.currentPlayer = currentPlayer;
	}

	/**
	 * @return the startBowlMap
	 */
	private Map<Player, Bowl> getStartBowlMap()
	{

		return startBowlMap;
	}

	/**
	 * @param startBowlMap
	 *            the startBowlMap to set
	 */
	private void setStartBowlMap(Map<Player, Bowl> startBowlMap)
	{

		this.startBowlMap = startBowlMap;
	}

	/**
	 * Returns the start {@code Bowl} of chain owned by the current {@code Player}.
	 * 
	 * @return The start {@code Bowl} owned by the current {@code Player}.
	 */
	private Bowl getStartBowlCurrentPlayer()
	{

		return getStartBowlMap().get(getCurrentPlayer());
	}

	/**
	 * Returns if a {@code Bowl} is playable by the current player.
	 * 
	 * @param bowl
	 *            The {@code Bowl} under scrutiny.
	 * @return {@code true} if the player owns {@code bowl} and {@code bowl} is playable, {@code false} otherwise.
	 */
	private boolean playable(Bowl bowl)
	{

		return bowl.getOwner().equals(getCurrentPlayer()) && bowl.playable();
	}

	/**
	 * Returns the indices of playable {@code Bowl}s for the current {@code Player}. The start {@code Bowl} gets index 0
	 * and every skip increments the index.
	 * 
	 * @return A {@code List<Integer>} of indices of playable {@code Bowl}s.
	 */
	public List<Integer> options()
	{

		List<Integer> options = new ArrayList<Integer>();

		Bowl bowl = getStartBowlCurrentPlayer();

		Integer index = 0;
		while (bowl.getOwner().equals(getCurrentPlayer()))
		{

			if (playable(bowl))
			{

				options.add(index);
			}

			bowl = bowl.getNextBowl();
			index++;
		}

		return options;
	}

	/**
	 * Returns the bowl {@code index} skips away from the start {@code Bowl} of the current {@code Player}. An {@code
	 * IllegalArgumentException} is thrown when {@code index} is {@code null} or negative.
	 * 
	 * @param index
	 *            The number of skips to perform from the start {@code Bowl}.
	 * @return The {@code Bowl} reached after {@code index} skips.
	 * @throws IllegalArgumentException
	 *             if {@code index} is {@code null} or negative.
	 */
	private Bowl getBowlAtIndex(Integer index) throws IllegalArgumentException
	{

		if (index == null || index < 0)
		{

			throw new IllegalArgumentException(ExceptionMessage.NON_NULL_NEGATIVE.toString());
		}

		Bowl bowl = getStartBowlCurrentPlayer();
		while (index > 0)
		{

			bowl = bowl.getNextBowl();
			index--;
		}

		return bowl;
	}

	/**
	 * Returns if a the {@code Bowl} at {@code index} is playable;
	 * 
	 * @param index
	 *            The index of the {@code Bowl} under scrutiny.
	 * @return {@code true} if the {@code Bowl} at {@code index} is playable {@code false} otherwise.
	 */
	public boolean playable(Integer index)
	{

		Bowl bowl = getBowlAtIndex(index);

		return playable(bowl);
	}

	/**
	 * Plays the {@code Bowl} {@code index} skips from the start {@code Bowl} from the current {@code Player}. An
	 * {@code IllegalArgumentException} is thrown if that {@code Bowl} is not playable.
	 * 
	 * @param index
	 *            The number of skips to perform from the start {@code Bowl}.
	 * @throws IllegalArgumentException
	 *             if the {@code Bowl} after {@code index} skips is not playable.
	 */
	public void play(Integer index) throws IllegalArgumentException
	{

		Bowl bowl = getBowlAtIndex(index);

		if (!playable(bowl))
		{

			throw new IllegalStateException(ExceptionMessage.NOT_PLAYABLE.toString());
		}

		if (!bowl.play())
		{

			/* We do not get to take another turn */
			endTurn();
		}
	}

	/**
	 * Returns a {@code Map<Player,List<Integer>>}. This {@code Map} holds per {@code Player} a {@code List<Integer>}.
	 * Each {@code List} determines the number of stones each {@code Bowl} contains, starting at the specific {@code
	 * Player}s start {@code Bowl}.
	 * 
	 * @return A {@code Map<Player,List<Integer>>} which holds the number of stones contained by each {@code Bowl} per
	 *         {@code Player}.
	 */
	public Map<Player, List<Integer>> getStonesPerPlayer()
	{

		Map<Player, List<Integer>> stonesPerPlayer = new HashMap<Player, List<Integer>>();

		for (Player player : Player.values())
		{

			List<Integer> stones = new ArrayList<Integer>();

			Bowl bowl = getStartBowlMap().get(player);
			while (bowl.getOwner().equals(player))
			{

				stones.add(bowl.countStones());
				bowl = bowl.getNextBowl();
			}

			stonesPerPlayer.put(player, stones);
		}

		return stonesPerPlayer;
	}

	/**
	 * Returns if this {@code Mancala} game is finished. A game is finished if the current {@code Player} does not have
	 * any valid options to play.
	 * 
	 * @return {@code true} if the game is finished, {@code false} otherwise.
	 */
	public boolean isFinished()
	{

		return options().size() == 0;
	}

	/**
	 * Returns the score both {@code Player}s currently have. The score is determined by counting the number of stones
	 * said {@code Player} owns.
	 * 
	 * @return A {@code Map<Integer>} which represents the score per {@code Player}.
	 */
	public Map<Player, Integer> score()
	{

		Map<Player, Integer> score = new HashMap<Player, Integer>();

		Map<Player, List<Integer>> stonesPerPlayer = getStonesPerPlayer();
		for (Player player : Player.values())
		{

			Integer playerScore = 0;
			for (Integer numberOfStones : stonesPerPlayer.get(player))
			{

				playerScore += numberOfStones;
			}

			score.put(player, playerScore);
		}

		return score;
	}
}
