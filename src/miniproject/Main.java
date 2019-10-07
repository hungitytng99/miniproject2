package miniproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("fxml/Menu.fxml"));
		AnchorPane layout = loader.load();
		Scene scene = new Scene(layout);

		MenuController data = loader.getController();
		data.getParent(this.primaryStage);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Menu");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/miniproject/picture/icon.png"));
		primaryStage.show();
	}

}
