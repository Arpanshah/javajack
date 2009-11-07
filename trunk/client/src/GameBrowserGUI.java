import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

/**
 * $Id$
 */


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * @author dan
 *
 */
public class GameBrowserGUI extends JFrame {
	
	private GameBrowser g;
	private JButton joinGameButton;
	private JButton createGameButton;
	private JList games;
	private JScrollPane scrollPane;

	public GameBrowserGUI( final GameBrowser g ) {
		this.g = g;
		
		g.getGames();

	}

	/** put games in the JList */
	public void populateList(Integer[] gameIds) {
		
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			{
				final JButton joinGameButton = new JButton( "Join Game" );
				getContentPane().add(joinGameButton );
				joinGameButton.setBounds(199, 143, 128, 22);
				joinGameButton.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						g.joinGame( (Integer)games.getSelectedValue() );
					}
				} );
			}
			{
				scrollPane = new JScrollPane();
				getContentPane().add(scrollPane);
				scrollPane.setBounds(12, 12, 314, 113);
				{
					ListModel gameListModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					games = new JList();
					scrollPane.setViewportView(games);
					games.setModel(gameListModel);
				}
			}
			{
				createGameButton = new JButton();
				getContentPane().add(createGameButton);
				createGameButton.setText("Create Game");
				createGameButton.setBounds(24, 143, 109, 22);
			}
			pack();
			this.setSize(338, 198);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	}