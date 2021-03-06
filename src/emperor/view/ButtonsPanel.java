package emperor.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import emperor.message.GameMessage;

/**
 *
 * @author RuN
 */
public class ButtonsPanel extends JPanel{
    
	private static final long serialVersionUID = 8576753273866241427L;
	private final JButton structureButton;
    private final JButton politicsButton;
    private final JButton technologyButton;
    private final JButton infoButton;
    
    private final GameMessage gm;
    
    public ButtonsPanel(GameMessage gm) {
               
    	this.gm = gm;
    	
        // Init Swing Components
        infoButton = new JButton();
        structureButton = new JButton();
        politicsButton = new JButton();
        technologyButton = new JButton();
        initButtons();
    }
    
    protected void initText() {
    	infoButton.setText(gm.InfoButtonText);
    	structureButton.setText(gm.BuildingButtonText);
    	technologyButton.setText(gm.TechnologyButtonText);
    	politicsButton.setText(gm.PoliticButtonText);
    }
    
    private void initButtons() {
                
        // Info Button
        infoButton.setBounds(50, 20, 100, 40);
        infoButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent action) {
                MainFrame.infoPanel.setVisible(true);
                MainFrame.structurePanel.setVisible(false);
                MainFrame.technologyPanel.setVisible(false);
                MainFrame.politicsPanel.setVisible(false);
            }
        });
        
        // Structure Button
        structureButton.setBounds(183, 20, 100, 40);
        structureButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent action) {
                MainFrame.structurePanel.setVisible(true);
                MainFrame.technologyPanel.setVisible(false);
                MainFrame.politicsPanel.setVisible(false);
                MainFrame.infoPanel.setVisible(false);
            }
        });
        
        // Technology Button
        technologyButton.setBounds(317, 20, 100, 40);
        technologyButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent action) {
                MainFrame.structurePanel.setVisible(false);
                MainFrame.technologyPanel.setVisible(true);
                MainFrame.politicsPanel.setVisible(false);
                MainFrame.infoPanel.setVisible(false);
            }
        });
        
        // Politics Button
        politicsButton.setBounds(450, 20, 100, 40);
        politicsButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent action) {
                MainFrame.structurePanel.setVisible(false);
                MainFrame.technologyPanel.setVisible(false);
                MainFrame.politicsPanel.setVisible(true);
                MainFrame.infoPanel.setVisible(false);
            }
        });
        
        add(infoButton);
        add(technologyButton);
        add(structureButton);
        add(politicsButton);
    }
    
    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
    }
}
