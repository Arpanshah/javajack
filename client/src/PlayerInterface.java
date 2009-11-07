import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public interface PlayerInterface {

	public int getId();	
	
	public List<Integer> getPlayers();
	
	public void tellPlayers(List<Integer> playerIds);
	
	public int getLastCardIndex();
	
	public void tellLastCardIndex(int index);
	
	public int getBet();
	
	public void tellBet(int playerId, int amount);
	
	public int tellCard();
	
	public int getMove();
	
	public void setResult(int result);
	
}
