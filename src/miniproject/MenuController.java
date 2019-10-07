package miniproject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {
	private Stage ShellSortStage;
	private Stage IntersectionSortStage;
	private Stage TowerStage;
	private Stage stage;

	@FXML
	void exit(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void shellsort(ActionEvent event) throws IOException {
		FXMLLoader loadlayout = new FXMLLoader();
		loadlayout.setLocation(getClass().getResource("fxml/ShellSort.fxml"));
		BorderPane layout = loadlayout.load();

		ShellSortController shellsort = loadlayout.getController();
		shellsort.getParent(this.ShellSortStage);

		Scene scene = new Scene(layout);

		ShellSortStage = new Stage();
		ShellSortStage.initOwner(stage);
		ShellSortStage.initModality(Modality.APPLICATION_MODAL);
		ShellSortStage.setScene(scene);
		ShellSortStage.setTitle("Shell Sort Algorithm");
		ShellSortStage.setResizable(false);
		ShellSortStage.getIcons().add(new Image("/miniproject/picture/icon.png"));
		ShellSortStage.show();
	}

	@FXML
	void interectionsort(ActionEvent event) throws IOException {
		FXMLLoader loadlayout = new FXMLLoader();
		loadlayout.setLocation(getClass().getResource("fxml/IntersectionSort.fxml"));
		BorderPane layout = loadlayout.load();

		InsertionSortController intersectionsort = loadlayout.getController();
		intersectionsort.getParent(this.IntersectionSortStage);

		Scene scene = new Scene(layout);

		IntersectionSortStage = new Stage();
		IntersectionSortStage.initOwner(stage);
		IntersectionSortStage.initModality(Modality.APPLICATION_MODAL);
		IntersectionSortStage.setScene(scene);
		IntersectionSortStage.setTitle("Intersection Sort Algorithm");
		IntersectionSortStage.setResizable(false);
		IntersectionSortStage.getIcons().add(new Image("/miniproject/picture/icon.png"));
		IntersectionSortStage.show();
	}

	@FXML
	void towerproblem(ActionEvent event) throws IOException {
		Parent menuScene = FXMLLoader.load(getClass().getResource("fxml/HaNoiTower.fxml"));
		TowerStage = new Stage();
		TowerStage.setTitle("HaNoi Tower Problems");
		TowerStage.setScene(new Scene(menuScene));
		TowerStage.getIcons().add(new Image("/miniproject/picture/icon.png"));
		TowerStage.show();
	}

	public void getParent(Stage stage) {
		this.stage = stage;
	}

}
