package emperor.model.personnel;


/**
 *
 * @author RuN
 */
public abstract class Person {
    
    protected String name;
    protected byte age;
    protected byte strength;
    protected byte intelligence;
    
    protected Person(String name) {
    	this.name = name;
        age = 0;
        strength = 0;
        intelligence = 0;
    }
    
    public void increaseAge() {
        age++;
    }
    
    public boolean isOldEnoighToDie() {
        return age >= 50;
    }
    
    public String getName() {
        return name;
    }
    
    public byte getIntelligence() {
        return intelligence;
    }
    
    public byte getStrength() {
    	return strength;
    }
    
}
