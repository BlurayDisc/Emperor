package emperor.model.personnel;


/**
 *
 * @author RuN
 */
public class Person {
    
    protected String name;
    protected byte age;
    protected byte strength;
    protected byte intelligence;
    
    public Person() {
    	
        name = Names.newRandomBasicName();
        age = 0;
        strength = 0;
        intelligence = 0;
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
    
    public byte getStrength() {
    	return strength;
    }
    
}
