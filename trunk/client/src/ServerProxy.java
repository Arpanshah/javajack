/**
 * $Id$
 */

import java.net.Socket;
import java.util.List;

/**
 * @author dan.arnold
 *
 */
public class ServerProxy implements PlayerListenerInterface {

	private static ServerProxy instance;
	private Socket s;
	
	private ServerModelListenerInterface listener;
	
    public static ServerProxy getInstance() {
        if ( instance == null )
            instance = new ServerProxy();
        return instance; 
    }
    
    public void setSocket( Socket s ) {
    	instance.s = s;
    }
	
    private ServerProxy() {
    }

	@Override
	public void createGame(int seed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCell(int gameId, int playerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getGames() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLastCardIndex(int gameId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPlayers(int gameId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinGame(int gameId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCell(int gameId, int playerId, String value) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Sets the ServerModelListener of this proxy.
	 * 
	 * @param listener the new listener
	 */
	public void setListener( ServerModelListenerInterface listener ) {
		if ( listener == null ) {
			throw new NullPointerException( "ServerProxy.setListener(): listener is null" );
		}
		this.listener = listener;
	}  

}