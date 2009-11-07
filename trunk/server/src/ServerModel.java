import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan
 *
 */
public class ServerModel {
	
	private HashMap<Integer,Game> games = new HashMap<Integer,Game>();
	
	private ServerModelListenerInterface modelListener;
	
	public ServerModel() {}
	
	public boolean addGame(int gameId, Game game) {
		if(!games.containsKey(gameId)) {
			games.put(gameId, game);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeGame(int gameId) {
		if(!games.containsKey(gameId)) {
			games.remove(gameId);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setCell(int gameId, int playerId, String value) {
		return ((Game)games.get(gameId)).set(playerId, value);
	}
	
	public void getCell(int gameId, int playerId) {
		modelListener.setCell(((Game)games.get(gameId)).get(playerId));
	}
	
	public void getGames() {
		modelListener.setGames((Integer[])games.keySet().toArray());
	}
	
	public void joinGame(int gameId) {
		Game gameToJoin = (Game)games.get(gameId);
		modelListener.setGameSeed(gameToJoin.getSeed());
		modelListener.setPlayerId(gameToJoin.makeNewPlayer());
	}
	
	public void createGame(int seed) {
		
	}
		
	// When new player joins:
		// Calls setGameSeed( int seed );
		// Calls setPlayer( List<Integer> playerIds (of that game))
}