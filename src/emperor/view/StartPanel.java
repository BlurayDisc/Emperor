package emperor.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import emperor.model.message.GameMessage;

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 9048404266038860032L;
	private final JButton confirmButton;
	private final JButton quitButton;
	private final JComboBox<String> provinceBox;
	private final JRadioButton cnRadioButton;
	private final JRadioButton enRadioButton;
	private final ButtonGroup radioButtonGroup;
	
	private final GameMessage gm;
	
	public StartPanel() {
		
		confirmButton = new JButton();
		quitButton = new JButton();
		provinceBox = new JComboBox<String>();
		radioButtonGroup = new ButtonGroup();
		cnRadioButton = new JRadioButton();
		enRadioButton = new JRadioButton();
		gm = new GameMessage();
		
		initComponents();
	}
	
	private void initComponents() {
		
		confirmButton.setText("È·¶¨");
		confirmButton.setBounds(200, 200, 80, 40);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainFrame.displayPanel.setVisible(true);
				MainFrame.displayPanel.taxThread.execute();
				MainFrame.displayPanel.popularityThread.execute();
				MainFrame.infoPanel.setVisible(true);
				MainFrame.buttonsPanel.setVisible(true);
			}
		});
		add(confirmButton);
		
		quitButton.setText("ÍË³ö");
		quitButton.setBounds(300, 200, 80, 40);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(quitButton);
		
		cnRadioButton.setText(" ");
		cnRadioButton.setBounds(450, 150, 80, 22);
		cnRadioButton.setSelected(true);
		cnRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.selectChinese();
				updateGameMessages();
			}
		});
		add(cnRadioButton);
		
		enRadioButton.setText("English");
		enRadioButton.setBounds(450, 200, 80, 22);
		enRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.selectEnglish();
				updateGameMessages();
			}
		});
		add(enRadioButton);
		
		radioButtonGroup.add(cnRadioButton);
		radioButtonGroup.add(enRadioButton);
	}
	
	private void updateGameMessages() {
		initText(gm);
		MainFrame.displayPanel.initText(gm);
		MainFrame.buttonsPanel.initText(gm);
	}
	
	private void initText(GameMessage gm) {
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
