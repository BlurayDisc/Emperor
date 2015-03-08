/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.controller;

import java.util.Calendar;

import emperor.model.country.China;
import emperor.model.country.Country;
import emperor.model.data.XmlParser;
import emperor.view.ButtonsPanel;
import emperor.view.MainFrame;

/**
 *
 * @author RuN
 */
public class GameController {
    
    private static final GameController instance = new GameController();
    private MainFrame main;
    private final Country country;
    private long previousTime;
    
    public GameController() {
        
        // Init Variables
        country = China.getInstance();
    }
    
    public void addView(MainFrame frame) {
    	this.main = frame;
    }
    
    public void addView(ButtonsPanel panel) {
    }

    
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
    
    public void loadGame() {
        
        // Load Game code goes here...
        
        XmlParser parser = XmlParser.getInstance();
        parser.readFile(country);
        
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis() / 1000;
        long timeDiff = currentTime - previousTime;
        country.increaseBalance(timeDiff * country.getTaxes());
        
    }
    
    public static GameController getInstance() {
        return instance;
    }
    
    public void setPreviousTime(long time) {
        previousTime = time;
    }
    
    public void doSomething() {
        
    }
    
}
