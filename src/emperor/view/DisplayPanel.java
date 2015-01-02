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

import emperor.controller.GameController;
import emperor.country.Country;
import emperor.country.CountryFactory;
import emperor.data.GameParameter;
import emperor.message.GameMessage;
import emperor.thread.PopularityThread;
import emperor.thread.TaxThread;

/**
 *
 * @author RuN
 */
public class DisplayPanel extends JPanel {

	private static final long serialVersionUID = 8734835512061699344L;
	private final Country country;
    private final GameController gc;
    private final GameParameter gp;
    
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
    
    public final TaxThread taxThread;
    public final PopularityThread popularityThread;  
    
    public DisplayPanel() {
        
        // Init Variables
    	CountryFactory factory = CountryFactory.newInstance();
        country = factory.get(Country.CH);
        
        // Loads Game Save Data
        gc = GameController.getInstance();
        //gc.loadGame();
        
        
        // Init Game Parameters
        gp = GameParameter.getInstance();
        
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
        
        // Start Timers
        taxThread = new TaxThread(country);
        taxThread.setInterval(1000);
        
        popularityThread = new PopularityThread(country);
        popularityThread.setInterval(10000);
    }
    
    public void initText(GameMessage gm) {
    	quitButton.setText(gm.quitButtonText);
        balanceTitleLabel.setText(country.getBalanceName());        
        taxesTitleLabel.setText(country.getTaxesName());        
        theftTitleLabel.setText(country.getTheftName());
        powerTitleLabel.setText(country.getPowerName());        
        popularityTitleLabel.setText(country.getPopularitName());
    }
    
	public void updateBalance() {
	    String balance = country.getBalance() + country.getCurrencyName();
	    balanceValueLabel.setText(balance);
	}
	
	public void updatePopularity() {
	    String popularity = country.getPopularity() + "";
	    popularityValueLabel.setText(popularity);
	}
    
    private void initButtons() {
        
        // Theft Button
        collectButton.setText(country.getCollectButtonName());
        collectButton.setBounds(260, 180, 80, 60);
        collectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                country.collect();
                balanceValueLabel.setText(country.getBalance() + country.getCurrencyName());
                if (country.hasPopularitySystem()) {
                    popularityValueLabel.setText(Integer.toString(country.getPopularity()));
                }
            }
        });
        
        // Close Button
        quitButton.setBounds(525, 15, 60, 33);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                // gc.saveGame();
                System.exit(0);
            }
        });
        
        this.add(collectButton);
        this.add(quitButton);
    }
    
    private void initLabels() {
        
        balanceTitleLabel.setText(country.getBalanceName());
        balanceTitleLabel.setForeground(Color.BLACK);
        balanceTitleLabel.setBounds(10, 10, 60, 22);
        balanceValueLabel.setText(country.getBalance() + country.getCurrencyName());
        balanceValueLabel.setBounds(65, 10, 160, 22);
        balanceValueLabel.setForeground(Color.BLACK);
        
        taxesTitleLabel.setText(country.getTaxesName());
        taxesTitleLabel.setBounds(10, 30, 60, 22);
        taxesTitleLabel.setForeground(Color.GREEN);
        taxesValueLabel.setText(country.getTaxes() + country.getCurrencyName());
        taxesValueLabel.setBounds(65, 30, 80, 22);
        taxesValueLabel.setForeground(Color.GREEN);
        
        theftTitleLabel.setText(country.getTheftName());
        theftTitleLabel.setBounds(200, 10, 60, 22);
        theftTitleLabel.setForeground(Color.GRAY);
        theftValueLabel.setText(country.getTheft() + country.getCurrencyName());
        theftValueLabel.setBounds(265, 10, 80, 22);
        theftValueLabel.setForeground(Color.GRAY);
        
        powerTitleLabel.setText(country.getPowerName());
        powerTitleLabel.setBounds(200, 30, 60, 22);
        powerTitleLabel.setForeground(Color.RED);
        powerValueLabel.setText(Integer.toString(country.getPower()));
        powerValueLabel.setBounds(265, 30, 80, 22);
        powerValueLabel.setForeground(Color.RED);
        
        popularityTitleLabel.setText(country.getPopularitName());
        popularityTitleLabel.setBounds(400, 10, 60, 22);
        popularityTitleLabel.setForeground(Color.BLACK);
        popularityValueLabel.setText(Integer.toString(country.getPopularity()));
        popularityValueLabel.setBounds(465, 10, 80, 22);
        popularityValueLabel.setForeground(Color.BLACK);

        this.add(balanceTitleLabel);
        this.add(balanceValueLabel);
        this.add(powerTitleLabel);
        this.add(powerValueLabel);
        this.add(popularityTitleLabel);
        this.add(popularityValueLabel);
        this.add(theftTitleLabel);
        this.add(theftValueLabel);
        this.add(taxesTitleLabel);
        this.add(taxesValueLabel);
    }

    public JLabel getBalanceValueLabel() {
        return balanceValueLabel;
    }

    public JLabel getPowerValueLabel() {
        return powerValueLabel;
    }

    public JLabel getPopularityValueLabel() {
        return popularityValueLabel;
    }

    public JLabel getTheftValueLabel() {
        return theftValueLabel;
    }

    public JLabel getTaxesValueLabel() {
        return taxesValueLabel;
    }
    
    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
    }
}
