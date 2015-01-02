package emperor.message;

public class GameMessage {
		
	public String confirmButtonText;
	public String quitButtonText;
	public String TechnologyButtonText;
	public String InfoButtonText;
	public String BuildingButtonText;
	public String PoliticButtonText;
	
	public GameMessage() {
	}
	
	public void selectEnglish() {
		confirmButtonText = "Confirm";
		quitButtonText =  "Quit";
		TechnologyButtonText = "Technology";
		InfoButtonText = "Information";
		BuildingButtonText = "Build";
		PoliticButtonText = "Politics";
	}
	
	public void selectChinese() {
		confirmButtonText = "确认";
		quitButtonText =  "退出";
		TechnologyButtonText = "改良科技";
		InfoButtonText = "基本信息";
		BuildingButtonText = "建造设施";
		PoliticButtonText = "处理公务";
	}
}
