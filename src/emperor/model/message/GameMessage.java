package emperor.model.message;

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

	}
}
