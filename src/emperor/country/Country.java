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
public abstract class Country {

    protected long balance;
    protected long theft;
    protected long adjustedTheft;
    protected long taxes;
    protected long adjustedTaxes;
    protected int power;
    protected int popularity;
    protected int inflation;
    protected int taxesBonusPercent;
    protected int theftBonusPercent;
    
    protected Country() {
        taxesBonusPercent = 0;
        theftBonusPercent = 0;
        inflation = 0;
        popularity = 0;
    }
    
    public abstract void collect();
    
    // Balance
    public void incrementBalance() {
        balance += adjustedTaxes;
    }
    
    public void increaseBalance(long value) {
        balance += value;
    }
    
    public void setBalance(long balance) {
        this.balance = balance;
    }
    
    public long getBalance() {
        return balance;
    }
    
    // Taxes
    public void increaseTaxes(int value) {
        taxes += value;
        adjustedTaxes = taxes * taxesBonusPercent / 100;
    }
    
    public void increaseTaxBonus(int value) {
        taxesBonusPercent += value;
        adjustedTaxes = taxes * (100 + taxesBonusPercent) / 100;
    }
    
    public void setTaxesBonusPercent(int taxesBonusPercent) {
        this.taxesBonusPercent = taxesBonusPercent;
    }
    
    public int getTaxesBonusPercent() {
        return taxesBonusPercent;
    }
    
    public void setTaxes(long taxes) {
        this.taxes = taxes;
        adjustedTaxes = taxes;
    }
    
    public long getTaxes() {
        return taxes;
    }
    
    // Theft
    public void increaseTheft(int value) {
        theft += value;
        adjustedTheft = theft * theftBonusPercent / 100;
    }
    
    public void increaseTheftBonus(int value) {
        theftBonusPercent += value;
        adjustedTheft = theft * (1 + theftBonusPercent) / 100;
    }
    
    public void setTheftBonusPercent(int theftBonusPercent) {
        this.theftBonusPercent = theftBonusPercent;
    }
    public int getTheftBonusPercent() {
        return theftBonusPercent;
    }

    public void setTheft(long theft) {
        this.theft = theft;
        adjustedTheft = theft;
    }
    
    public long getTheft() {
        return theft;
    }
    
    // Others
    public void incrementPopularity() {
        increasePopularity(1);
    }
    
    public void increasePopularity(int value) {
        if (popularity > 0 && popularity < 100)
            popularity += 1;
    }
    
    public boolean hasPopularitySystem() {
        return popularity != 0;
    }
    
    // Getters
    public int getPower() {
        return power;
    }
    
    public int getPopularity() {
        return popularity;
    }

    
    public int getInflation() {
        return inflation;
    }

    // Setters

    public void setPower(int power) {
        this.power = power;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setInflation(int inflation) {
        this.inflation = inflation;
    }
}
