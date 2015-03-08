/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor;

import emperor.controller.GameController;
import emperor.controller.thread.LoadGameThread;
import emperor.view.MainFrame;

/**
 *
 * @author RuN
 */
public class Emperor {

    public static void main(String[] args) {
                
    	loadGameData();
    	
    	setLookAndFeel();
    	
    	loadGUI();
    }
    
    public static void loadGameData() {
    	
    	LoadGameThread thread = new LoadGameThread();
    	thread.execute();
    }
    
    public static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){}
    }
    
    public static void loadGUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
               MainFrame frame = new MainFrame();
               frame.setVisible(true);
               
               GameController controller = new GameController();
               
               frame.addController(controller);
            }
        });
    }
}
