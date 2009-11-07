import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public class GameBrowser {
	
	Socket s;
	ServerProxy proxy;
	GameBrowserGUI gui;
	
	int gameToJoin;
	int gameSeed;
	int lastCardIndex;
	List<Integer> playerIds;
	int playerId;
	
	PlayerListenerInterface listener;
	
	public GameBrowser( Socket s ) {
		
		gameToJoin = -1;
		gameSeed = -1;
		lastCardIndex = -1;
		playerIds = null;
		playerId = -1;
		
		this.s = s;
		proxy = ServerProxy.getInstance();
		proxy.setSocket( s );
		
		gui = new GameBrowserGUI( this );
		proxy.setListener( new ServerModelListenerInterface() {

			@Override
			public void setCell(String value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setGameSeed(int seed) {
				GameBrowser.this.gameSeed = seed;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
			}

			@Override
			public void setLastCardIndex(int index) {
				GameBrowser.this.lastCardIndex = index;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
				
			}

			@Override
			public void setPlayers(List<Integer> playerIds) {
				GameBrowser.this.playerIds = playerIds;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
			}

			@Override
			public void setGames(Integer[] gameIds) {
				gui.populateList( gameIds );
			}

			@Override
			public void setPlayerId(int playerId) {
				GameBrowser.this.playerId = playerId;
				if ( readyToJoinGame() ) {
					createJavajack();
				}
			}

			@Override
			public void setGameId(int gameId) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void joinGame( Integer gameId ) {
		gameToJoin = gameId;
		listener.joinGame( gameId ); // gameId.intValue() ?
	}
	
	public void createGame( Integer gameId, int playerId ) {
		Random r = new Random();
		int seed = r.nextInt( Integer.MAX_VALUE );
		listener.createGame( seed );
	}
	
	private boolean readyToJoinGame() {
		return ( playerIds != null && playerId >= 0 && gameSeed >= 0 && gameToJoin >= 0 && lastCardIndex >=0 );
	}
	
	private void createJavajack() {
		List<PlayerInterface> players = new ArrayList<PlayerInterface>();
		LocalPlayer localPlayer = new LocalPlayer( playerId );
		players.add( localPlayer );
		for ( Integer id : playerIds ) {
			if ( id.intValue() == playerId ) { // If it's me, skip it
				continue;
			} // otherwise
			players.add( new RemotePlayer( gameToJoin, playerId ) );
		}
		
		Referee referee = new Referee( players, gameSeed, gameToJoin );
		Javajack game = new Javajack( referee );
	}

	public void getGames() {
		listener.getGames(); // Ask the server for the games
	}
	
	// If player wants to create a new game:
		// Generate seed
		// Create LocalPlayer
		// Create a Dealer with List<PlayerInterface> and seed
		// Pass Dealer to constructor of Javajack
	// If player wants to join an already created game:
		// getSeed()
		// getListOfPlayers
		// getLastCardIndex
		// Create LocalPlayer
		// Create RemotePlayers based on list of players got from server
		// Create List<PlayerInterface> with LocalPlayer and RemotePlayers
		// Create Dealer with List we just created and lastCardIndex
		// Pass seed (from server) and new Dealer to constructor of javajack
}