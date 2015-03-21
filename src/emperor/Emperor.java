package emperor;

import emperor.view.MainFrame;

/**
 * Main Class for Emperor Application.
 * @author RuN
 */
public class Emperor {

    public static void main(String[] args) {
                
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){}
        
        java.awt.EventQueue.invokeLater(new Runnable() {
<<<<<<< HEAD
            @Override
			public void run() {
                new MainFrame().setVisible(true);
=======
            public void run() {
<<<<<<< HEAD
            	
               MainFrame frame = new MainFrame();
               frame.setVisible(true);
               
               GameController controller = new GameController();
               
               frame.addController(controller);
>>>>>>> origin/master
=======
                new MainFrame().setVisible(true);
>>>>>>> parent of 7dd6b61... Update: Version beta 0.3
            }
        });
    }
}
