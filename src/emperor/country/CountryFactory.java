package emperor.country;

public class CountryFactory {
	
	private CountryFactory() {}
	
    public Country get(int country) {
    	
    	Country instance;
    	
    	if (country == Country.CH) {
    		instance = China.getInstance();
    	} else if (country == Country.AU) {
    		instance = Australia.getInstance();
    	} else {
    		instance = null;
    	}
    	
    	return instance;
    }
    
    public static CountryFactory newInstance() {
    	return new CountryFactory();
    }
}
