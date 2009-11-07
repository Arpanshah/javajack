import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
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
	public Server(Socket socket) {
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
	
	public static void main(String [] args) {
		String host = "";
		int port = 0;
		if( args.length != 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		
		ServerSocket ss;
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress(host, port));

		while(true) {
			Socket socket = null;
			socket = ss.accept();
			
			final ClientProxy proxy = new ClientProxy(socket);
			final ServerModel model = ServerModel.getInstance();
			
			model.setListener(proxy);
			
			proxy.setListener(new PlayerListenerInterface() {

				public void createGame(int seed) {
					model.createGame(seed);
				}

				public void getCell(int gameId, int playerId) {
					model.getCell(gameId, playerId);		
				}

				public void getGames() {
					model.getGameIds();
				}

				public void getLastCardIndex(int gameId) {
					model.getLastCardIndex(gameId);
				}

				public void getPlayers(int gameId) {
					model.getPlayerIds(gameId);
				}

				public void joinGame(int gameId) {
					model.joinGame(gameId);
				}

				public void setCell(int gameId, int playerId, String value) {
					model.setCell(gameId, playerId, value);
				}
			});
			
			proxy.start();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
