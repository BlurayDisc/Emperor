/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import emperor.controller.GameController;
import emperor.model.ChinaPoliticalSystem;
import emperor.model.PoliticalSystem;

/**
 *
 * @author RuN
 */
public class DisplayPanel extends JPanel {

	private static final long serialVersionUID = 8734835512061699344L;
	private final PoliticalSystem country;
    private final GameController gc;
    
    private final JLabel balanceTitleLabel;
    private final JLabel balanceValueLabel = new JLabel();
    private final JLabel powerTitleLabel;
    private final JLabel powerValueLabel = new JLabel();
    private final JLabel popularityTitleLabel;
    private final JLabel popularityValueLabel = new JLabel();
    private final JLabel theftTitleLabel;
    private final JLabel theftValueLabel = new JLabel();
    private final JLabel taxesTitleLabel;
    private final JLabel taxesValueLabel = new JLabel();
    
    private final JButton theftButton;
    private final JButton closeButton;
    
    public DisplayPanel() {
        
        // Init Variables
        country = ChinaPoliticalSystem.getInstance();
        gc = GameController.getInstance();
        
        // Loads Game Save Data
        gc.loadGame();
        
        // Initialise Labels
        balanceTitleLabel = new JLabel();
        powerTitleLabel = new JLabel();
        popularityTitleLabel = new JLabel();
        theftTitleLabel = new JLabel();
        taxesTitleLabel = new JLabel();
        initLabels();
        
        // Initialise Button
        theftButton = new JButton();
        closeButton = new JButton();
        initButtons();
        
        // Start Timers
        gc.initTimers();
    }
    
    private void initButtons() {
        
        // Theft Button
        theftButton.setText(country.getCollectButtonName());
        theftButton.setBounds(260, 180, 80, 60);
        theftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                country.theft();
                balanceValueLabel.setText(country.getBalance() + country.getCurrencyName());
                if (country.hasPopularitySystem()) {
                    popularityValueLabel.setText(Integer.toString(country.getPopularity()));
                }
            }
        });
        
        // Close Button
        closeButton.setText("Quit");
        closeButton.setBounds(535, 15, 50, 33);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                gc.saveGame();
                System.exit(0);
            }
        });
        
        this.add(theftButton);
        this.add(closeButton);
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
        theftTitleLabel.setBounds(257, 110, 60, 22);
        theftTitleLabel.setForeground(Color.GRAY);
        theftValueLabel.setText(country.getTheft() + country.getCurrencyName());
        theftValueLabel.setBounds(312, 110, 80, 22);
        theftValueLabel.setForeground(Color.GRAY);
        
        powerTitleLabel.setText(country.getPowerName());
        powerTitleLabel.setBounds(240, 110, 60, 22);
        powerTitleLabel.setForeground(Color.RED);
        powerValueLabel.setText(Integer.toString(country.getPower()));
        powerValueLabel.setBounds(330, 110, 80, 22);
        powerValueLabel.setForeground(Color.RED);
        
        popularityTitleLabel.setText(country.getPopularitName());
        popularityTitleLabel.setBounds(240, 140, 60, 22);
        popularityTitleLabel.setForeground(Color.BLACK);
        popularityValueLabel.setText(Integer.toString(country.getPopularity()));
        popularityValueLabel.setBounds(330, 140, 80, 22);
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
        
    public void updateBalance() {
        String balance = country.getBalance() + country.getCurrencyName();
        balanceValueLabel.setText(balance);
    }
    
    public void updatePopularity() {
        String popularity = country.getPopularity() + "";
        popularityValueLabel.setText(popularity);
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
}
