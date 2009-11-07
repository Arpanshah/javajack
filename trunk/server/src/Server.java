import java.net.Socket;

/**
 * $Id$
 */

/**
 * Serves a client socket
 * @author dan
 *
 */
public class Server{

	// Private members
	private ClientProxy proxy;
	private ServerModel model;
	
	/**
	 * Constructor that takes a socket
	 * @param socket
	 */
	public ServerWorker(Socket socket) {
		model = ServerModel.getInstance();
		proxy = new ClientProxy(socket);
		proxy.setListener(new PlayerListenerInterface() {

			/**
			 * calls the appropriate functions on the model
			 */
			public void createGame(int seed) {
				model.createGame(seed);
			}

			/**
			 * calls the appropriate functions on the model
			 */
			public void getCell(int gameId, int playerId) {
				model.getCell(gameId, playerId);
			}

			/**
			 * calls the appropriate functions on the model
			 */
			public void getGames() {
				model.getGameIds();
			}

			/**
			 * calls the appropriate functions on the model
			 */
			public void getLastCardIndex(int gameId) {
				model.getLastCardIndex(gameId);
			}

			/**
			 * calls the appropriate functions on the model
			 */
			public void getPlayers(int gameId) {
				model.getPlayerIds(gameId);
			}

			/**
			 * calls the appropriate functions on the model
			 */
			public void joinGame(int gameId) {
				model.joinGame(gameId);
			}

			/**
			 * calls the appropriate functions on the model
			 */
			public void setCell(int gameId, int playerId, String value) {
				model.setCell(gameId, playerId, value);
			}
		});
	}

	public void run() {
		proxy();
	}
	
	public static void main(String [] args) {
		
	}
}

class Reader extends Thread {
	public Reader() {
		
	}
}
