/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import emperor.model.Player;

/**
 *
 * @author RuN
 */
public class InfoPanel extends JPanel{
    
	private static final long serialVersionUID = 6321019104558656841L;
	private final JLabel personelTitleLabel;
    private final JLabel[] personels;
    private final JLabel person1;
    private final JLabel person2;
    private final JLabel person3;
    private final JLabel person4;
    private final JLabel person5;
    private final JLabel person6;
    private final JLabel person7;
    private final JLabel person8;
    private final JLabel person9;
    private final JLabel person10;
    
    private final JButton regenerateButton;
    
    public InfoPanel() {
        
        // Init Swing Components
        personelTitleLabel = new JLabel();
        person1 = new JLabel();
        person2 = new JLabel();
        person3 = new JLabel();
        person4 = new JLabel();
        person5 = new JLabel();
        person6 = new JLabel();
        person7 = new JLabel();
        person8 = new JLabel();
        person9 = new JLabel();
        person10 = new JLabel();
        personels = new JLabel[] {person1, person2, person3, person4, person5, person6, person7, person8, person9, person10};
        regenerateButton = new JButton();
        
        initPersonelLabels();
        initButtons();
    }
    
    private void initPersonelLabels() {
        
        personelTitleLabel.setBounds(470, 20, 50, 22);
        personelTitleLabel.setText("部下：");
        add(personelTitleLabel);
        
        // Init Player
        Player player = Player.getInstance();
        if (player.getPersonels().isEmpty()) {
            player.init();
        }
        
        for (int i = 0; i < personels.length; i++) {
            personels[i].setBounds(520, 20 + i * 20, 100, 20);
            personels[i].setText(player.getPersonels().get(i).getName());
            add(personels[i]);
        }
    }
    
    private void initButtons() {
        
        regenerateButton.setText("新人");
        regenerateButton.setBounds(380, 50, 80, 60);
        regenerateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                Player player = Player.getInstance();
                player.init();
                for (int i = 0; i < 10; i++) {
                    personels[i].setText(player.getPersonels().get(i).getName());
                }
            }
        });
        add(regenerateButton);
    }
    
    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
    }
}
