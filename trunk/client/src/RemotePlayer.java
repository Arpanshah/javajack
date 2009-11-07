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

			@Override
			public void setCell(String value) {
				cell.set(value);
			}

			@Override
			public void setGameId(int gameId) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setGameSeed(int seed) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setGames(Integer[] gameIds) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setLastCardIndex(int index) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setPlayerId(int playerId) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setPlayers(List<Integer> playerIds) {
				// TODO Auto-generated method stub
				
			}
			
		} );
	}

	@Override
	public int getBet(int gameId, int playerId) {
		proxy.getCell(gameId, playerId);
		return Integer.parseInt( cell.get() );
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMove() {
		proxy;
		return 0;
	}

	@Override
	public void setBet(int bet, int playerId, int gameId) {
		proxy.setCell(gameId, playerId, Integer.toString(bet) );
	}

}
