/**
 * $Id$
 */

/**
 * @author dan
 *
 */
public class LocalPlayer implements PlayerInterface {

	private int id;
	
	public LocalPlayer(int playerId) {
		id = playerId;
	}

	@Override
	public int getBet() {
		// get bet from gui
		return 0;
	}

	@Override
	public int getMove() {
		// get hit or stay from gui
		return 0;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setBet(int bet, int id, int gameId) {
		// I'm local, ignore
	}
}
