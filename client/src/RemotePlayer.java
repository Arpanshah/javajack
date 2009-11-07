import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan
 *
 */
public class RemotePlayer implements PlayerInterface {

	ServerProxy proxy;
	Cell<String> cell;
	
	public RemotePlayer(int intValue) {
		proxy = ServerProxy.getInstance();
		proxy.setListener( new ServerModelListenerInterface() {

			public void setCell(String value) {
				cell.set(value);
			}

			public void setGameId(int gameId) {

			}

			public void setGameSeed(int seed) {

			}

			public void setGames(Integer[] gameIds) {

			}

			public void setLastCardIndex(int index) {

			}

			public void setPlayerId(int playerId) {
				
			}

			public void setPlayers(List<Integer> playerIds) {
				
			}
		} );
	}

	public int getBet(int gameId, int playerId) {
		proxy.getCell(gameId, playerId);
		return Integer.parseInt( cell.get() );
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMove() {
		proxy;
		return 0;
	}

	public void setBet(int bet, int playerId, int gameId) {
		proxy.setCell(gameId, playerId, Integer.toString(bet) );
	}

}
