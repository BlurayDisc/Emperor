/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
    
    public ButtonsPanel() {
               
        // Init Swing Components
        infoButton = new JButton();
        structureButton = new JButton();
        politicsButton = new JButton();
        technologyButton = new JButton();
        initButtons();
    }
    
    private void initButtons() {
                
        // Info Button
        infoButton.setText("基本信息");
        infoButton.setBounds(50, 30, 100, 40);
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                MainFrame.infoPanel.setVisible(true);
                MainFrame.structurePanel.setVisible(false);
                MainFrame.technologyPanel.setVisible(false);
                MainFrame.politicsPanel.setVisible(false);
            }
        });
        
        // Structure Button
        structureButton.setText("建造设施");
        structureButton.setBounds(183, 30, 100, 40);
        structureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                MainFrame.structurePanel.setVisible(true);
                MainFrame.technologyPanel.setVisible(false);
                MainFrame.politicsPanel.setVisible(false);
                MainFrame.infoPanel.setVisible(false);
            }
        });
        
        // Technology Button
        technologyButton.setText("改良科技");
        technologyButton.setBounds(317, 30, 100, 40);
        technologyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                MainFrame.structurePanel.setVisible(false);
                MainFrame.technologyPanel.setVisible(true);
                MainFrame.politicsPanel.setVisible(false);
                MainFrame.infoPanel.setVisible(false);
            }
        });
        
        // Politics Button
        politicsButton.setText("处理公务");
        politicsButton.setBounds(450, 30, 100, 40);
        politicsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                MainFrame.structurePanel.setVisible(false);
                MainFrame.technologyPanel.setVisible(false);
                MainFrame.politicsPanel.setVisible(true);
                MainFrame.infoPanel.setVisible(false);
            }
        });
        
        this.add(infoButton);
        this.add(technologyButton);
        this.add(structureButton);
        this.add(politicsButton);
    }    
}
