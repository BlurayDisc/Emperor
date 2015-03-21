package emperor.model.personnel;

import emperor.model.personnel.Person;

public class Farmer extends Person {
	
	public Farmer() {
		this(Names.newRandomBasicName());
	}
	
	public Farmer(String name) {
		super(name);
        age = (byte) (18 + (Math.random() * 30));
        intelligence = (byte) (Math.random() * 35);
		strength = (byte) (20 + Math.random() * 30);
	}
}
