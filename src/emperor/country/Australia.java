package emperor.country;

public class Australia extends Country {
	
	private static final Australia instance = new Australia();
	
	protected Australia() {
		
	}

	@Override
	public void collect() {
		// TODO Auto-generated method stub
		
	}
	
	public static Australia getInstance() {
		return instance;
	}

}
