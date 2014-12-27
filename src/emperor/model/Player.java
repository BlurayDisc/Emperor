/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.model;

import java.util.ArrayList;

/**
 *
 * @author RuN
 */
public class Player {
    
    private static final Player instance = new Player();
    private String name;
    private final OfficialPosition position;
    private final ArrayList<Person> personels;
    
    private Player() {
        
        position = new OfficialPosition();
        personels = new ArrayList<>(10);
    }
    
    public void init() {
        
        position.setTen();
        personels.clear();
        
        for (int i = 0; i < 10; i++) {
            personels.add(new Person());
        }
    }
    
    public void addPersonels(Person person) {
        personels.add(person);
    }
    
    public ArrayList<Person> getPersonels() {
        return personels;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static Player getInstance() {
        return instance;
    }
}
