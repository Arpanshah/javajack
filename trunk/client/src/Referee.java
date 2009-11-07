import java.util.List;

/**
 * $Id$
 */

/**
 * @author dan.arnold
 *
 */
public class Referee {
	
	private static final int HIT_VALUE = -1;
	private static final int STAND_VALUE = -2;
	List<PlayerInterface> players;
	
	public Referee( List<PlayerInterface> newPlayers, int seed, int gameId ) {
		
		RemotePlayer dealer = new RemotePlayer( gameId, 0 );
		players.add( dealer );
		
		for ( PlayerInterface player : newPlayers ) {
			players.add( player );
		}
		
		for (;;) {
			
			for ( PlayerInterface p : players ) {
				int bet = p.getBet( );
				for ( PlayerInterface p2 : players ) {
					p2.tellBet( p2.getId(), bet );
				}
				int move = p.getMove();
				switch (move) {
				case HIT_VALUE:
					// do something
					break;
				case STAND_VALUE:
					// do something else
					break;
				}
			}
		}
	}
}