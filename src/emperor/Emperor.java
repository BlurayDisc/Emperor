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
            @Override
			public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
