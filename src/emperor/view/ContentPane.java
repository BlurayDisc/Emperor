package emperor.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ContentPane extends JPanel {
	
	/**
	 * This JPanel acts as the contentPane for the MainFrame, all other panels are attached to this component.S
	 */
	private static final long serialVersionUID = -8668618688820184387L;

	public ContentPane() {
		
		setLayout(null);
		setBounds(0, 0, 600, 400);
		setBackground(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}
}
