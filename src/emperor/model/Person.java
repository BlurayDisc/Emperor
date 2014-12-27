/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.model;

/**
 *
 * @author RuN
 */
public class Person {
    
    private final String name;
    private byte age;
    private byte intelligence;
    
    public Person() {
        this(Names.getInstance().getRandomBasicName());
    }
    
    public Person(String name) {
        this.name = name;
        age = (byte) (0b10010 + (Math.random() * 0b1010));                  // 18, 10
        intelligence = (byte) (0b11110 + (Math.random() * 0b1000110));      // 30, 70
    }
    
    public void increaseAge() {
        age++;
    }
    
    public boolean isOldEnoighToDie() {
        return age >= 0b110010;     // 50
    }
    
    public String getName() {
        return name;
    }
    
    public byte getIntelligence() {
        return intelligence;
    }
    
}
