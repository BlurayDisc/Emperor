package emperor;

import emperor.controller.GameController;
import emperor.controller.thread.LoadGameThread;
import emperor.view.MainFrame;

/**
 * Main Class for Emperor Application.
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
<<<<<<< HEAD
            @Override
			public void run() {
                new MainFrame().setVisible(true);
=======
            public void run() {
            	
               MainFrame frame = new MainFrame();
               frame.setVisible(true);
               
               GameController controller = new GameController();
               
               frame.addController(controller);
>>>>>>> origin/master
            }
        });
    }
}
