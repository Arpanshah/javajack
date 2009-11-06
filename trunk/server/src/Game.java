import java.util.ArrayList;
import java.util.List;

/**
 * $Id$
 */

/**
 * Facilitates synchronization of a game between multiple players
 * @author dan
 *
 */
public class Game {

	// Private members
	private int gameId = 0;
	private int seed = 0;
	private int lastCardIndex = 0;
	private List<Cell<String>> playerCells = new ArrayList<Cell<String>>();
	
	public Game() {}
	
	/**
	 * Constructor with gameId parameter
	 * @param gameId
	 */
	public Game(int gameId, int seed, int lastCardIndex) {
		this.gameId = gameId;
		this.seed = seed;
		this.lastCardIndex = lastCardIndex;
	}

	/**
	 * Gets this game's id
	 * @return this game's id
	 */
	public int getGameId() {
		return gameId;
	}
	
	/**
	 * Adds a new player to the game, and returns the new player's id
	 * @return new player's id
	 */
	public synchronized int makeNewPlayer() {
		playerCells.add(new Cell<String>());
		return playerCells.size();
	}
	
	/**
	 * Gets playerId's cell's value
	 * @param playerId
	 * @return playerId's cell's value
	 */
	public String get(int playerId) {
		if(playerId <= playerCells.size()) {
			return playerCells.get(playerId--).get();
		} else {
			return null;
		}
	}
	
	/**
	 * Sets playerId's cell's value with given value
	 * @param playerId
	 * @param value
	 * @return true if successfully set, else false
	 */
	public boolean set(int playerId, String value) {
		if(playerId <= playerCells.size()) {
			playerCells.get(playerId--).set(value);
			return true;
		} else {
			return false;
		}
	}
}
