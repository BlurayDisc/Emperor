/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD
import emperor.country.Country;
import emperor.country.CountryFactory;
import emperor.country.CountryType;
import emperor.message.GameMessage;
=======
import emperor.controller.GameController;
<<<<<<< HEAD
import emperor.controller.thread.PopularityThread;
import emperor.controller.thread.TaxThread;
import emperor.model.country.Country;
import emperor.model.country.CountryFactory;
import emperor.model.data.GameParameter;
import emperor.model.message.GameMessage;
>>>>>>> origin/master
=======
import emperor.country.Country;
import emperor.country.CountryFactory;
import emperor.data.GameParameter;
import emperor.message.GameMessage;
import emperor.thread.PopularityThread;
import emperor.thread.TaxThread;
>>>>>>> parent of 7dd6b61... Update: Version beta 0.3

/**
 *
 * @author RuN
 */
public class DisplayPanel extends JPanel {

	private static final long serialVersionUID = 8734835512061699344L;
	private final Country country;
    
    private final JLabel balanceTitleLabel;
    private final JLabel balanceValueLabel;
    private final JLabel powerTitleLabel;
    private final JLabel powerValueLabel;
    private final JLabel popularityTitleLabel;
    private final JLabel popularityValueLabel;
    private final JLabel theftTitleLabel;
    private final JLabel theftValueLabel;
    private final JLabel taxesTitleLabel;
    private final JLabel taxesValueLabel;
    
    private final JButton collectButton;
    private final JButton quitButton;
    
    private final GameMessage gm;
    
    public DisplayPanel(GameMessage gm) {
    	
    	this.gm = gm;
        
        // Init Variables
    	CountryFactory factory = CountryFactory.newInstance();
<<<<<<< HEAD
        country = factory.get(CountryType.CH);
=======
        country = factory.get(Country.CH);
        
        // Loads Game Save Data
        gc = GameController.getInstance();
        //gc.loadGame();
        
        
        // Init Game Parameters
        gp = GameParameter.getInstance();
>>>>>>> origin/master
        
        // Initialise Button
        collectButton = new JButton();
        quitButton = new JButton();
        
        // Initialise Labels
        balanceTitleLabel = new JLabel();
        balanceValueLabel = new JLabel();
        powerTitleLabel = new JLabel();
        powerValueLabel = new JLabel();
        popularityTitleLabel = new JLabel();
        popularityValueLabel = new JLabel();
        theftTitleLabel = new JLabel();
        theftValueLabel = new JLabel();
        taxesTitleLabel = new JLabel();
        taxesValueLabel = new JLabel();
        
        initLabels();
        initButtons();
    }
    
    public void initText() {
    	
    	collectButton.setText(gm.collectButtonName);
    	quitButton.setText(gm.quitButtonText);
        balanceTitleLabel.setText(gm.balanceName);        
        taxesTitleLabel.setText(gm.taxesName);        
        theftTitleLabel.setText(gm.theftName);
        powerTitleLabel.setText(gm.powerName);        
        popularityTitleLabel.setText(gm.popularityName);
        
        balanceValueLabel.setText(country.getBalance() + gm.currencyName);
        taxesValueLabel.setText(country.getTaxes() + gm.currencyName);
        theftValueLabel.setText(country.getTheft() + gm.currencyName);
        powerValueLabel.setText(Integer.toString(country.getPower()));
        popularityValueLabel.setText(Integer.toString(country.getPopularity()));
    }
    
	public void updateBalance() {
	    String balance = country.getBalance() + gm.currencyName;
	    balanceValueLabel.setText(balance);
	}
	
	public void updatePopularity() {
	    String popularity = country.getPopularity() + "";
	    popularityValueLabel.setText(popularity);
	}
    
    private void initButtons() {
        
        // Theft Button
        collectButton.setBounds(260, 180, 80, 60);
        collectButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent action) {
                country.collect();
                balanceValueLabel.setText(country.getBalance() + gm.currencyName);
                if (country.hasPopularitySystem()) {
                    popularityValueLabel.setText(Integer.toString(country.getPopularity()));
                }
            }
        });
        
        // Close Button
        quitButton.setBounds(525, 15, 60, 33);
        quitButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent action) {
                // gc.saveGame();
                System.exit(0);
            }
        });
        
        add(collectButton);
        add(quitButton);
    }
    
    private void initLabels() {
        
        balanceTitleLabel.setForeground(Color.BLACK);
        balanceTitleLabel.setBounds(10, 10, 100, 22);
        balanceValueLabel.setBounds(65, 10, 160, 22);
        balanceValueLabel.setForeground(Color.BLACK);
        
        taxesTitleLabel.setBounds(10, 30, 100, 22);
        taxesTitleLabel.setForeground(Color.GREEN);
        taxesValueLabel.setBounds(65, 30, 100, 22);
        taxesValueLabel.setForeground(Color.GREEN);
        
        theftTitleLabel.setBounds(200, 10, 100, 22);
        theftTitleLabel.setForeground(Color.GRAY);
        theftValueLabel.setBounds(285, 10, 100, 22);
        theftValueLabel.setForeground(Color.GRAY);
        
        powerTitleLabel.setBounds(200, 30, 100, 22);
        powerTitleLabel.setForeground(Color.RED);
        powerValueLabel.setBounds(285, 30, 100, 22);
        powerValueLabel.setForeground(Color.RED);
        
        popularityTitleLabel.setBounds(400, 10, 100, 22);
        popularityTitleLabel.setForeground(Color.BLACK);
        popularityValueLabel.setBounds(465, 10, 100, 22);
        popularityValueLabel.setForeground(Color.BLACK);

        add(balanceTitleLabel);
        add(balanceValueLabel);
        add(powerTitleLabel);
        add(powerValueLabel);
        add(popularityTitleLabel);
        add(popularityValueLabel);
        add(theftTitleLabel);
        add(theftValueLabel);
        add(taxesTitleLabel);
        add(taxesValueLabel);
    }
    
    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
    }
}
