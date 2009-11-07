import java.util.List;

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

	public void setBet(int bet, int id, int gameId) {
		// I'm local, ignore
	}

	@Override
	public int getLastCardIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResult(int result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tellBet(int playerId, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tellCard(int playerId, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tellLastCardIndex(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tellPlayers(List<Integer> playerIds) {
		// TODO Auto-generated method stub
		
	}
}
