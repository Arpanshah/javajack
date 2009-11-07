import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public interface ServerModelListenerInterface {
	void setCell(String value);
	void setGameSeed(int seed);
	void setPlayerId(int playerId);
	void setGames(Integer[] gameIds);
	void setPlayers(List<Integer> playerIds);
	void setLastCardIndex(int index);
	void setGameId(int gameId);
}
