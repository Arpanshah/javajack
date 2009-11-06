/**
 * $Id$
 */

/**
 * @author dan
 *
 */
public class GameBrowser {
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