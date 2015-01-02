package emperor.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import emperor.country.Country;
import emperor.view.MainFrame;

public class PopularityThread implements ActionListener {

	private Timer popularityTimer;
	private final Country country;

	public PopularityThread(Country country) {
		
		this.country = country;
	}
	
	public void setInterval(int delay) {
		popularityTimer = new Timer(delay, this);
	}
	
	public void execute() {
		popularityTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        country.incrementPopularity();
        MainFrame.displayPanel.updatePopularity();
	}
}