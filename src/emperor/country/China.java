/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emperor.country;

/**
 *
 * @author RuN
 */
public class China extends Country {
	
	private static final China instance = new China();
    
    protected China() {
        
        // Init Variables
        balance = 0;
        theft = 1;
        adjustedTheft = theft;
        taxes = 1;
        adjustedTaxes = taxes;
        power = 10;
        popularity = 70;
    }
    
    @Override
    public void collect() {
        balance += adjustedTheft;
        increasePopularity(-1);
    }
    
    public static China getInstance() {
    	return instance;
    }
}
