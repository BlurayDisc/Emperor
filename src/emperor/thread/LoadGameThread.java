package emperor.thread;

import javax.swing.SwingWorker;

import emperor.controller.GameController;
import emperor.country.China;
import emperor.country.Country;
import emperor.data.GameParameter;
import emperor.message.GameMessage;

public class LoadGameThread extends SwingWorker<Void, Void> {
	
	Country country;
	GameController gc;
	GameMessage gm;
	GameParameter gp;

	@Override
	protected Void doInBackground() throws Exception {
		
        // Init Variables
		country = China.getInstance();
        
        // Loads Game Save Data
		gc = GameController.getInstance();
        gc.loadGame();
        
        // Init Game Messages
        gm = new GameMessage();
        
        // Init Game Parameters
        gp = GameParameter.getInstance();
		
		return null;
	}
	
	@Override
	public void done() {
		
	}
}
