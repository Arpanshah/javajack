/**
 * $Id$
 */

import java.util.HashMap;


public class GameDB {
	
	private static HashMap<Integer,Game> db;
	
	/**
	 * Singleton getter
	 * @return
	 */
	public static HashMap<Integer,Game> getDB() {
		if(db == null) {
			db = new HashMap<Integer,Game>();
		}
		return db;
	}
}
