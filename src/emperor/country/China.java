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
        
        // Init Strings
        currencyName = " 两白银";
        balanceName = "国库余额: ";
        theftName = "征税: ";
        taxesName = "税收: ";
        powerName = "中央集权: ";
        popularityName = "民心: ";
        
        collectButtonName = "征税";
        
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
