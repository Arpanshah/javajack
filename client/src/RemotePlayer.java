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
	int gameId;
	int playerId;
	
	public RemotePlayer(int gameId, int playerId) {
		this.gameId = gameId;
		this.playerId = playerId;
		
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

	public int getBet() {
		proxy.getCell(gameId, playerId);
		return Integer.parseInt(cell.get());
	}

	public int getId() {
		return playerId;
	}

	public int getLastCardIndex() {
		proxy.getLastCardIndex(gameId);
		return Integer.parseInt(cell.get());
	}

	public int getMove() {
		proxy.getCell(gameId, playerId);
		return Integer.parseInt(cell.get());
	}

	public List<Integer> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setResult(int result) {
		proxy.setCell(gameId, playerId, result + "");
	}

	public void tellBet(int playerId, int amount) {
		// nothing to do
	}

	public void tellCard() {
		proxy.setCell(gameId, playerId, value)
	}

	public void tellLastCardIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	public void tellPlayers(List<Integer> playerIds) {
		// TODO Auto-generated method stub
		
	}
}
