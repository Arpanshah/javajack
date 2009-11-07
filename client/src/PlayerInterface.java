/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public interface PlayerInterface {

	int getMove();

	int getBet(int gameId, int playerId);
	int getId();

	void setBet(int bet, int id, int gameId);

}
