package emperor.data;

public class GameParameter {

	private static final GameParameter instance = new GameParameter();
	
	public static int WINDOW_WIDTH = 600;
	public static int WINDOW_HEIGHT = 400;
	
	private GameParameter() {
		
	}
	
	public static GameParameter getInstance() {
		return instance;
	}
}
