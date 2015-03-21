/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.controller;

import java.util.Calendar;
<<<<<<< HEAD

<<<<<<< HEAD
import javax.swing.JOptionPane;

import emperor.country.China;
import emperor.country.Country;
import emperor.data.XmlParser;
import emperor.thread.PopularityThread;
import emperor.thread.TaxThread;
=======
import emperor.model.country.China;
import emperor.model.country.Country;
import emperor.model.data.XmlParser;
import emperor.view.ButtonsPanel;
import emperor.view.MainFrame;
>>>>>>> origin/master
=======
import emperor.country.China;
import emperor.country.Country;
import emperor.data.XmlParser;
>>>>>>> parent of 7dd6b61... Update: Version beta 0.3

/**
 *
 * @author RuN
 */
public class GameController {
	
	public final int TRUE = 0;
	public final int FALSE = 1;
    
<<<<<<< HEAD
    private final Country country;
    private long previousTime;
    
    private final TaxThread taxThread;
    private final PopularityThread popularityThread;
    
    /** GameController separates lots of the game's responsibilities **/
=======
    private static final GameController instance = new GameController();
    private final Country country;
    private long previousTime;
    
<<<<<<< HEAD
>>>>>>> origin/master
    public GameController() {
=======
    private GameController() {
>>>>>>> parent of 7dd6b61... Update: Version beta 0.3
        
        // Init Variables
        country = China.getInstance();
        
        // Start Timers
        taxThread = new TaxThread(country);
        taxThread.setInterval(1000);
        
        popularityThread = new PopularityThread(country);
        popularityThread.setInterval(10000);
    }

    /** Saves game data from this current session **/
    public void saveGame() {
        
        // Save Game code goes here...
//        Calendar calendar = Calendar.getInstance();
//        long currentTime = calendar.getTimeInMillis();
        
        XmlParser parser = XmlParser.getInstance();
        parser.updateFile(country);
        
        country.getBalance();
        country.getPower();
        country.getTaxes();
        country.getTheft();
        country.getPopularity();
    }
    
    /** Loads previously saved game data from a xml file **/
    public void loadGame() {
        
        // Load Game code goes here...
        
        XmlParser parser = XmlParser.getInstance();
        parser.readFile(country);
        
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis() / 1000;
        long timeDiff = currentTime - previousTime;
        country.increaseBalance(timeDiff * country.getTaxes());
        
    }
	
    /** Brings up a new info MessageDialog **/
	public void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	 /** Brings up a new option MessageDialog **/
	public int optionBox(String confirmMessage, String title) {
		return JOptionPane.showConfirmDialog(null, confirmMessage, title, JOptionPane.OK_CANCEL_OPTION);
	}
    
	 /** Initialise game threads **/
    public void initGameThreads() {
    	taxThread.execute();
    	popularityThread.execute();
    }
    
    public void setPreviousTime(long time) {
        previousTime = time;
    }    
}
