package emperor.message;

public class GameMessage {
		
	// GUI Components Text
	public String confirmButtonText;
	public String quitButtonText;
	public String TechnologyButtonText;
	public String InfoButtonText;
	public String BuildingButtonText;
	public String PoliticButtonText;
	
	// Game Text
	public String collectButtonName;
	public String currencyName;
	public String balanceName;
	public String theftName;
	public String taxesName;
	public String powerName;
	public String popularityName;
	
	// Popup Box Text
	public String newGameMsg;
	public String newGameTitle;
	
	 /** Provides storing and accessing all game related Message Strings **/
	public GameMessage() {
		
		initDefaultSettings();
	}
	
	 /** Sets language option to English **/
	public void setEnglish() {
		confirmButtonText = "Confirm";
		quitButtonText =  "Quit";
		TechnologyButtonText = "Technology";
		InfoButtonText = "Information";
		BuildingButtonText = "Build";
		PoliticButtonText = "Politics";
		collectButtonName = "Collect Tax";
		currencyName = " Silver";
		balanceName = "Treasure: ";
		theftName = "Collect Tax: ";
		taxesName = "Tax: ";
		powerName = "Central Power: ";
		popularityName = "Popularity: ";
		
		newGameMsg = "Start a new game? (This will erase all previously saved data!)";
		newGameTitle = "New Game";
	}
	
	 /** Sets language option to Chinese **/
	public void setChinese() {
		confirmButtonText = "确认";
		quitButtonText =  "退出";
		TechnologyButtonText = "改良科技";
		InfoButtonText = "基本信息";
		BuildingButtonText = "建造设施";
		PoliticButtonText = "处理公务";
		collectButtonName = "征税";
        currencyName = " 两白银";
        balanceName = "国库余额: ";
        theftName = "征税: ";
        taxesName = "税收: ";
        powerName = "中央集权: ";
        popularityName = "民心: ";
        
		newGameMsg = "确认开始新的游戏? (这将清除之前所保存的进度！)";
		newGameTitle = "开始新游戏";
	}
	
	/** Sets default language option **/
	private void initDefaultSettings() {
		setChinese();
	}
}
