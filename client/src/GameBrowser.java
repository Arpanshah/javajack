import java.net.Socket;
import java.util.List;

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
	
	public GameBrowser( Socket s ) {
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setGames(List<Integer> gameIds) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setLastCardIndex(int index) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setPlayers(List<Integer> playerIds) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void joinGame( Javajack g ) {
		
	}
	// If player wants to create a new game:
		// Generate seed
		// Create LocalPlayer
		// Create a Dealer with List<PlayerInterface>
		// Pass seed and Dealer to constructor of Javajack
	// If player wants to join an already created game:
		// while ( gameInProgress ) {
			// isGameInProgess()
		// }
		// getSeed()
		// getListOfPlayers
		// getLastCardIndex
		// Create LocalPlayer
		// Create RemotePlayers based on list of players got from server
		// Create List<PlayerInterface> with LocalPlayer and RemotePlayers
		// Create Dealer with List we just created and lastCardIndex
		// Pass seed (from server) and new Dealer to constructor of javajack
}