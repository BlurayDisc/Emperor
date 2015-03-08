package emperor.controller.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import emperor.model.country.Country;
import emperor.view.MainFrame;

public class TaxThread implements ActionListener {

	private Timer taxesTimer;
	private final Country country;

	public TaxThread(Country country) {
		
		this.country = country;
	}
	
	public void setInterval(int delay) {
		taxesTimer = new Timer(delay, this);
	}
	
	public void execute() {
		taxesTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        country.incrementBalance();
        MainFrame.displayPanel.updateBalance();
	}
}


