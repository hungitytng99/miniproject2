package miniproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SuccessStageController {
	private Stage stage;
	private int num;
	@FXML
	private Label label;
	
	@FXML
	public void initialize()
	{
	}
	
	public void confirm(ActionEvent event)
	{
		stage.close();
	}
	public void getStage(Stage stage,int num) {
		this.stage = stage;
		this.num = num;
	}
	
}
