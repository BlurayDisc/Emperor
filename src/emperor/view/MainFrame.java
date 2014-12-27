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

/**
 *
 * @author RuN
 */
public class MainFrame extends JFrame{
    
	private static final long serialVersionUID = -956722615494309197L;
    
    private static final ContentPane contentPane;
    public static final DisplayPanel displayPanel;
    public static final InfoPanel infoPanel;
    public static final StructurePanel structurePanel;
    public static final TechnologyPanel technologyPanel;
    public static final PoliticsPanel politicsPanel;
    public static final ButtonsPanel buttonsPanel;
    private final JPanel[] panels;
    
    static {
        contentPane = new ContentPane();
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
        panels = new JPanel[] {displayPanel, buttonsPanel, infoPanel, structurePanel, technologyPanel, politicsPanel};
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
    		panel.setLayout(null);
    		panel.setBackground(Color.WHITE);
    		if (panel instanceof DisplayPanel) panel.setBounds(5, 5, 590, 60);
    		else if (panel instanceof ButtonsPanel) panel.setBounds(5, 315, 590, 80);
    		else panel.setBounds(7, 65, 584, 248);
    		if (panel instanceof DisplayPanel || panel instanceof ButtonsPanel) panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    		else panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		if (panel instanceof DisplayPanel || panel instanceof ButtonsPanel || panel instanceof InfoPanel) panel.setVisible(true);
    		else panel.setVisible(false);
    		getContentPane().add(panel);
    	}
    }
    
    private void setWindowLocation() {
        Dimension windowSize = getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(screenSize.getWidth() - windowSize.getWidth()) / 2, (int)(screenSize.getHeight() - windowSize.getHeight()) / 2);
    }
}
