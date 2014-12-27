/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Timer;

import emperor.data.XmlParser;
import emperor.model.ChinaPoliticalSystem;
import emperor.model.PoliticalSystem;
import emperor.view.MainFrame;

/**
 *
 * @author RuN
 */
public class GameController {
    
    private static final GameController instance = new GameController();
    private final PoliticalSystem country;
    private Timer taxesTimer;
    private Timer popularityTimer;
    private long previousTime;
    
    private GameController() {
        
        // Init Variables
        country = ChinaPoliticalSystem.getInstance();
    }
    
    public void initTimers() {
        
        // Initialise Timers
        taxesTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                country.incrementBalance();
                MainFrame.displayPanel.updateBalance();
            }
        });
        
        popularityTimer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                country.incrementPopularity();
                MainFrame.displayPanel.updatePopularity();
            }
        });
        
        // Start Timers
        taxesTimer.start();
        popularityTimer.start(); 
    }
    
    public void pauseTimers() {
        
    }
    
    public void saveGame() {
        
        // Save Game code goes here...
//        Calendar calendar = Calendar.getInstance();
//        long currentTime = calendar.getTimeInMillis();
        
        XmlParser parser = XmlParser.getInstance();
        parser.updateFile();
        
        country.getBalance();
        country.getPower();
        country.getTaxes();
        country.getTheft();
        country.getPopularity();
    }
    
    public void loadGame() {
        
        // Load Game code goes here...
        
        XmlParser parser = XmlParser.getInstance();
        parser.readFile();
        
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis() / 1000;
        long timeDiff = currentTime - previousTime;
        country.increaseBalance(timeDiff * country.getTaxes());
        
        System.out.println("current: " + currentTime);
        System.out.println("previous: " + previousTime);
        System.out.println("diff: " + timeDiff);
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
