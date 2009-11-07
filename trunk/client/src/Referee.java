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
		
		RemotePlayer dealer = new RemotePlayer( 0 );
		players.add( dealer );
		
		for ( PlayerInterface player : newPlayers ) {
			players.add( player );
		}
		
		for (;;) {
			
			for ( PlayerInterface p : players ) {
				int bet = p.getBet( gameId, p.getId() );
				for ( PlayerInterface p : players ) {
					p.setBet( bet, p.getId(), gameId );
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