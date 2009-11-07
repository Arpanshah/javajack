import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan
 *
 */
public class ClientProxy implements ServerModelListenerInterface {

	// Private members
	Socket socket;
	PrintStream out;
	
	/**
	 * Constructor that takes a socket
	 * @param socket
	 */
	public ClientProxy(Socket socket) {
		this.socket = socket;
		try {
			out = new PrintStream(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println(socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() +  " <-- I/O error");
			finalize();		
		}
	}
	
	/**
	 * Sends cell value to the client
	 */
	public void setCell(String value) {
		out.println("setCell " + value);
	}

	/**
	 * Sends game id to the client
	 */
	public void setGameId(int gameId) {
		out.println("setGameId " + gameId);
	}

	/**
	 * Sends game seed to the client
	 */
	public void setGameSeed(int seed) {
		out.println("setGameSeed " + seed);		
	}

	/**
	 * Sends list of game ids to the client
	 */
	public void setGames(Integer[] gameIds) {
		String sendString = "setGames";
		if(gameIds.length == 0) {
			for(int i = 0; i < gameIds.length; i++) {
				sendString += " " + gameIds[i];
			}
		} else {
			sendString += " *";
		}
		out.println(sendString);
	}

	/**
	 * Sends last dealt card's index to the client
	 */
	public void setLastCardIndex(int index) {
		out.println("setLastCardIndex " + index);
	}
	
	/**
	 * Sends players id to the client
	 */
	public void setPlayerId(int playerId) {
		out.println("setPlayerId " + playerId);
	}

	/**
	 * sends list of player ids to the client
	 */
	public void setPlayers(List<Integer> playerIds) {
		String sendString = "setGames";
		if(playerIds.size() == 0) {
			for(int i = 0; i < playerIds.size(); i++) {
				sendString += " " + playerIds.get(i);
			}
		} else {
			sendString += " *";
		}
		out.println(sendString);
	}
	
	/**
	 * Closes open stream and socket
	 */
	public void finalize() {
		try{
			out.close();
			socket.close();
			System.out.println(socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() +  " close");
		} catch (IOException e) {
			System.err.println(socket.getInetAddress().toString().substring(1) + ":" + socket.getPort() +  " --> I/O error");
		}
	}
}
