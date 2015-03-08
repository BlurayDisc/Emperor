/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import emperor.controller.GameController;

/**
 *
 * @author RuN
 */
public class MainFrame extends JFrame{
    
	private static final long serialVersionUID = -956722615494309197L;
    
    private static final ContentPane contentPane;
    private static final StartPanel startPanel;
    public static final DisplayPanel displayPanel;
    public static final InfoPanel infoPanel;
    public static final StructurePanel structurePanel;
    public static final TechnologyPanel technologyPanel;
    public static final PoliticsPanel politicsPanel;
    public static final ButtonsPanel buttonsPanel;
    private final JPanel[] panels;
    private GameController controller;
    
    static {
        contentPane = new ContentPane();
        startPanel = new StartPanel();
        displayPanel = new DisplayPanel();
        infoPanel = new InfoPanel();
        structurePanel = new StructurePanel();
        technologyPanel = new TechnologyPanel();
        politicsPanel = new PoliticsPanel();
        buttonsPanel = new ButtonsPanel();
    }
    
    public MainFrame() {
        
        // Init Layout
        setLayout(null);
        
        // Init Panels
        panels = new JPanel[] {startPanel, displayPanel, buttonsPanel, infoPanel, structurePanel, technologyPanel, politicsPanel};
        initPanels();
                
        // Other Attributes
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setSize(600, 400);
        setWindowLocation();
    }
    
    private void initPanels() {
    	
    	// Init ContentPane();
    	setContentPane(contentPane);
                
        // Init Panels
    	for (JPanel panel: panels) {
    		
    		getContentPane().add(panel);
    		panel.setLayout(null);
    		panel.setBackground(Color.WHITE);
    		
    		if (panel instanceof StartPanel) {
    			panel.setBounds(5, 5, 590, 390);
    		} else if (panel instanceof DisplayPanel) {
    			panel.setBounds(5, 5, 590, 60);
    		} else if (panel instanceof ButtonsPanel) {
    			panel.setBounds(5, 315, 590, 80);
    		} else {
    			panel.setBounds(7, 65, 584, 248);
    		}
    		
    		if (panel instanceof DisplayPanel || panel instanceof ButtonsPanel) {
    			panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    		} else {
    			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    		}
    		
    		if (panel instanceof StartPanel) {
    			panel.setVisible(true);
    		} else {
    			panel.setVisible(false);
    		}
    	}
    }
    
    private void setWindowLocation() {
        Dimension windowSize = getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(screenSize.getWidth() - windowSize.getWidth()) / 2, (int)(screenSize.getHeight() - windowSize.getHeight()) / 2);
    }
    
    public void addController(GameController controller) {
    	this.controller = controller;
    }
}
