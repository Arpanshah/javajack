import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 * $Id$
 */

/**
 * @author dan
 *
 */
public class GameBrowserGUI extends JFrame {
	
	private GameBrowser g;
	JButton joinGameButton;
	JList games;
	
	public GameBrowserGUI( final GameBrowser g ) {
		this.g = g;
		
		g.getGames();
		
		final JButton joinGameButton = new JButton( "Join Game" );
		joinGameButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.joinGame( (Integer)games.getSelectedValue() );
			}
		} );
	}

	/** put games in the JList */
	public void populateList(Integer[] gameIds) {
		
	}
	}