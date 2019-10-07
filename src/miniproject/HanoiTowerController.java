package miniproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import miniproject.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HanoiTowerController implements Initializable {

	@FXML
	private Button playBtn;

	@FXML
	private Button pauseBtn;

	@FXML
	private HBox playerContainer;

	@FXML
	private HBox animationPane;
	@FXML
	private BorderPane mainPane;
	@FXML
	TextField Text;

	private ButtonPanel Town;

	protected Timer playTimer;
	private boolean isAutoplayAnimation = false;
	private int floor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerContainer.getChildren().remove(pauseBtn);

		Town = new Town(3);
		animationPane.getChildren().clear();
		animationPane.getChildren().add(Town);
	}

	public void backToMenu(MouseEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(""));			
			Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
			stage.setScene(new Scene(root, screenSize.getWidth(), screenSize.getHeight()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateDisks(ActionEvent event) {
		String text = Text.getText();
		try {
			floor = (Integer.parseInt(text));
			updateDisksAndTextField();
		} catch (NumberFormatException ex) {
		}
	}

	public void randomizeDisks(ActionEvent event) {
		Random rand = new Random();
		floor = 2 + rand.nextInt(3); // 2 - 4

		updateDisksAndTextField();
	}

	private void updateDisksAndTextField() {		
		Text.setText(((Integer) floor).toString());

		Town = new Town(floor);
		animationPane.getChildren().clear();
		animationPane.getChildren().add(Town);
	}

	public void go(ActionEvent event) {
		generateDisks(null);

		if (!isAutoplayAnimation) {
			play(null);
		}
	}

	public void play(ActionEvent event) {
		isAutoplayAnimation = true;
		playTimer = new Timer();

		playTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int animationIndex = Town.goNext();
				setActiveInstruction(animationIndex);

				if (Town.isLastAnimation()) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							pause(null);
						}
					});
					return;
				}
			}

		}, 0, 1800);

		playerContainer.getChildren().clear();

		playerContainer.getChildren().add(pauseBtn);

	}

	public void pause(ActionEvent event) {
		isAutoplayAnimation = false;
		playTimer.cancel();
		playTimer.purge();
		playerContainer.getChildren().remove(pauseBtn);
		playerContainer.getChildren().add(playBtn);

	}

	private void setActiveInstruction(int animationIndex) {

	}

}
