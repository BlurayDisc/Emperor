package emperor.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

<<<<<<< HEAD
<<<<<<< HEAD
import emperor.controller.GameController;
import emperor.message.GameMessage;
=======
import emperor.model.message.GameMessage;
>>>>>>> origin/master
=======
import emperor.message.GameMessage;
>>>>>>> parent of 7dd6b61... Update: Version beta 0.3

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 9048404266038860032L;
	private final JButton confirmButton;
	private final JButton quitButton;
	private final JButton loadButton;
	private final JLabel nameLabel;
	private final JTextField nameField;
	private final JComboBox<String> provinceBox;
	private final JRadioButton cnRadioButton;
	private final JRadioButton enRadioButton;
	private final ButtonGroup radioButtonGroup;
	
	private final GameController gc;
	private final GameMessage gm;
	
	public StartPanel(GameController gc, GameMessage gm) {
		
		this.gc = gc;
		this.gm = gm;
		
		confirmButton = new JButton();
		quitButton = new JButton();
		loadButton = new JButton();
		nameLabel = new JLabel();
		nameField = new JTextField();
		provinceBox = new JComboBox<String>();
		radioButtonGroup = new ButtonGroup();
		cnRadioButton = new JRadioButton();
		enRadioButton = new JRadioButton();
		
		initComponents();
	}
	
	private void initComponents() {
		
		confirmButton.setText("确认");
		confirmButton.setBounds(200, 200, 80, 40);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initGame();
			}
		});
		add(confirmButton);
		
		quitButton.setText("退出");
		quitButton.setBounds(300, 200, 80, 40);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(quitButton);
		
		cnRadioButton.setText("中文");
		cnRadioButton.setBounds(450, 150, 80, 22);
		cnRadioButton.setSelected(true);
		cnRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gm.setChinese();
			}
		});
		add(cnRadioButton);
		
		enRadioButton.setText("English");
		enRadioButton.setBounds(450, 200, 80, 22);
		enRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gm.setEnglish();
			}
		});
		add(enRadioButton);
		
		radioButtonGroup.add(cnRadioButton);
		radioButtonGroup.add(enRadioButton);
	}
	
	private void initGame() {
		
		if (gc.optionBox(gm.newGameMsg, gm.newGameTitle) == gc.TRUE) {
			// Initialise Text Strings
			this.initText();
			MainFrame.displayPanel.initText();
			MainFrame.buttonsPanel.initText();
			
			// Change Displayed Panels
			this.setVisible(false);
			MainFrame.displayPanel.setVisible(true);
			MainFrame.infoPanel.setVisible(true);
			MainFrame.buttonsPanel.setVisible(true);
			
			// Initialise Game Threads
			gc.initGameThreads();
		}
	}
	
	private void initText() {
		confirmButton.setText(gm.confirmButtonText);
		quitButton.setText(gm.quitButtonText);
	}
	
    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
    }
}
