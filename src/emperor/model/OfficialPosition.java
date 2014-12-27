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
public class OfficialPosition {
    
    private String title;
    
    public void setTen() {
        title = "十人长";
    }
    
    public void setHundred() {
        title = "百人长";
    }
    
    public void setThousand() {
        title = "千人长";
    }
    
    public String getTitle() {
        return title;
    }
}
