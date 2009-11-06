import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public interface PlayerListenerInterface {
	void setCell( int gameId, int playerId, String value );
	
	void getCell( int gameId, int playerId );
	
	void setGames( List<Integer> gameList );
	
	void getGames();
	
	void getPlayers( int gameId );
	
	void joinGame( int gameId );
	
	void createGame( int seed );
	
	void getLastCardIndex( int gameId );
}