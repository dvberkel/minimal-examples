/**
 * 
 */
package org.effrafax.game.mancala;

import java.util.HashMap;
import java.util.Map;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;

/**
 * This abstract class provides a static method which creates a mancala board.
 * 
 * The following terminology is used throughout this file.
 * 
 * <ul>
 * <li>
 * {@code Bowl} B is linked to {@code Bowl} A, if the {@code setNextBowl(Bowl)} method of A is called with parameter B.
 * Or more concisely {@code A.setNextBowl(B)}.</li>
 * <li>
 * A <em>chain</em> is a number of {@code Bowls} linked together. Every chain has precisely one {@code Kalaha}, and it
 * is always at the end.</li>
 * <li>
 * A <em>start {@code Bowl}</em> of a chain is the first {@code Bowl} in a chain.</li>
 * <li>
 * A <em>linked chain</em> are two chains with the respective {@code Kalaha}s are linked to the start {@code Bowl} of
 * the other chain.</li>
 * <li>
 * A <em>skip</em> is following a link from a {@code Bowl} to the linked {@code Bowl}.</li>
 * <li>
 * In a linked chain every {@code Bowl} is reachable by starting at any {@code Bowl} and skipping. The {@code Bowl}
 * which is reached starting from a certain {@code Bowl} and skipping a number of times is called a <em>tour</em>. To
 * designate a specific tour we will use the following syntax: The tour of {@code Bowl} after n skips.</li>
 * <li>
 * A <em>interlocking chain</em> is a linked chain where every {@code Bowl} has his opposite {@code Bowl} set.</li>
 * <li>
 * A <em>board</em> is a interlocking chain which is interfaced by mapping the {@code Player}s to the start {@code Bowl}
 * of the chains. </i>
 * </ul>
 * 
 * @author dvberkel
 * 
 */
public abstract class BoardFactory
{

	/**
	 * Returns a modifiable empty {@code Map<K,V>}. It uses type inference to return the correct map.
	 * 
	 * @param <K>
	 *            Generic type for the keys.
	 * @param <V>
	 *            Generic type for the Values
	 * @return A empty {@code Map<K,V>}
	 */
	private static <K, V> Map<K, V> createEmptyMap()
	{

		return new HashMap<K, V>();
	}

	/**
	 * Creates a chain of {@code Bowl}s which ends in a {@code Kalaha}. All {@code Bowls} except the {@code Kalaha} will
	 * be filled with a number of stones.
	 * 
	 * @param owner
	 *            The owner of the {@code Bowls} in the chain.
	 * @param numberOfBowls
	 *            The number of {@code Bowls} before the {@code Kalaha}.
	 * @param numberOfStones
	 *            The number of stones in every {@code Bowl}.
	 * @return The first {@code Bowl} in the chain.
	 */
	private static Bowl createChain(Player owner, int numberOfBowls, int numberOfStones)
	{

		Bowl chain = BowlFactory.instance.getBowl(owner, numberOfStones);

		Bowl tail = null;
		if (numberOfBowls > 1)
		{

			tail = createChain(owner, numberOfBowls - 1, numberOfStones);
		}
		else
		{

			tail = BowlFactory.instance.getKalaha(owner);
		}
		chain.setNextBowl(tail);

		return chain;
	}

	/**
	 * Creates two changes with a specified number of {@code Bowls} which are filled with a number of stones.
	 * 
	 * @param builder
	 *            The {@code MancalaBuilder} which specifies the number of {@code Bowls} and number of stones.
	 * @return A {@code Map<Player,Bowl>} which maps a {@code Player} to the start {@code Bowl} of the chain which is
	 *         owned by that {@code Player}.
	 */
	private static Map<Player, Bowl> createChains(MancalaBuilder builder)
	{

		Map<Player, Bowl> startBowlMap = createEmptyMap();

		for (Player player : Player.values())
		{

			Bowl chain = createChain(player, builder.getNumberOfBowls(), builder.getNumberOfStones());

			startBowlMap.put(player, chain);
		}

		return startBowlMap;
	}

	/**
	 * Links two chains together which results in a linked chain.
	 * 
	 * @param startBowlMap
	 *            A {@code Map} as per createChains.
	 * @see org.effrafax.game.mancala.BoardFactory.createChains(MancalaBuilder)
	 */
	private static void linkChains(Map<Player, Bowl> startBowlMap)
	{

		Bowl whiteStartBowl = startBowlMap.get(Player.white);
		Bowl blackStartBowl = startBowlMap.get(Player.black);

		Kalaha whiteKalaha = whiteStartBowl.getKahala();
		Kalaha blackKalaha = blackStartBowl.getKahala();

		whiteKalaha.setNextBowl(blackStartBowl);
		blackKalaha.setNextBowl(whiteStartBowl);
	}

	/**
	 * Returns a tour.
	 * 
	 * @param bowl
	 *            the {@code Bowl} at which we start following links.
	 * @param tourNumber
	 *            The number of links we will follow.
	 * @return The tour of {@code bowl} after {@code tourNumber} skips.
	 */
	private static Bowl tour(Bowl bowl, int tourNumber)
	{

		while (tourNumber > 0)
		{

			bowl = bowl.getNextBowl();
			tourNumber--;
		}

		return bowl;
	}

	/**
	 * Created an interlocking chain from a linked chain.
	 * 
	 * @param builder
	 *            The {@code MancalaBuilder} which specifies the number of {@code Bowls}
	 * @param startBowlMap
	 *            A {@code Map} as per createChains. The chain should linked.
	 * @see org.effrafax.game.mancala.BoardFactory.createChains(MancalaBuilder)
	 */
	private static void linkOpponents(MancalaBuilder builder, Map<Player, Bowl> startBowlMap)
	{

		/*
		 * If n is the number of {@code Bowl}s (not counting the {@code Kalaha}) in a chain then there are 2 * n + 2
		 * {@code Bowl}s in a linked chain (counting the {@code Kalaha}s).
		 * 
		 * So a round skip needs 2 * n + 2 skips. The opponent of the a start {@code Bowl} is 2 skips back or 2 * n
		 * skips forward. The previous bowl is 1 skip back or 2 * n + 1 skips forward.
		 * 
		 * This explains the tourNumbers in this method.
		 */
		int tourNumber = 2 * builder.getNumberOfBowls();

		Bowl whiteBowl = startBowlMap.get(Player.white);
		Bowl opposite = tour(whiteBowl, tourNumber);

		/* Number of skips to get to the previous bowl. */
		tourNumber++;

		int countPairs = 0;
		while (countPairs < builder.getNumberOfBowls())
		{

			whiteBowl.setOppositeBowl(opposite);
			opposite.setOppositeBowl(whiteBowl);

			whiteBowl = whiteBowl.getNextBowl();
			opposite = tour(opposite, tourNumber);
			countPairs++;
		}
	}

	/**
	 * Creates a Board.
	 * 
	 * @param builder
	 *            The {@code MancalaBuilder} which specifies the number of {@code Bowls} and number of stones.
	 * @return A board according to the specification laid out by the builder.
	 */
	public static Map<Player, Bowl> createBoard(MancalaBuilder builder)
	{

		Map<Player, Bowl> startBowlMap = createChains(builder);
		linkChains(startBowlMap);
		linkOpponents(builder, startBowlMap);

		return startBowlMap;
	}

}
