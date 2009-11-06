import java.net.Socket;
import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public class ServerProxy implements PlayerListenerInterface {

	private static ServerProxy instance;
	
    public static ServerProxy getInstance() {
        if ( instance == null )
            instance = new ServerProxy();
        return instance; 
    } 
	
    private ServerProxy() {
        ; // starts with the current time
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

	@Override
	public void setGames(List<Integer> gameList) {
		// TODO Auto-generated method stub
		
	}  

}