package emperor.country;

public class CountryFactory {
	
	private CountryFactory() {}
	
    public Country get(CountryType type) {
    	
    	Country instance;
    	
    	if (type == CountryType.CH) {
    		instance = China.getInstance();
    	} else if (type == CountryType.AU) {
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
