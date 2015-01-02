package emperor.model.personnel;

import emperor.model.personnel.Person;

public class Farmer extends Person {
	
	public Farmer() {
		
		name = Names.newRandomBasicName();
        age = (byte) (18 + (Math.random() * 30));
        intelligence = (byte) (Math.random() * 35);
		strength = (byte) (20 + Math.random() * 30);
	}
}
