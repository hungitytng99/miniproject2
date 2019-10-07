package miniproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InsertionSortController {
	private Stage stage;
	private ToggleGroup InDecreaseGroup;
	private int num = 10;
	private AnchorPane contentcenter;
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private ArrayList<dataShape> arrayShape = new ArrayList<dataShape>();
	private ArrayList<Text> textShape = new ArrayList<Text>();
	private ArrayList<Circle> circleShape = new ArrayList<Circle>();
	private ArrayList<Label> labelTemp = new ArrayList<Label>();
	private double X = -40;
	private static final double Y = 200;
	public double DISTANCE = 75;
	private Text textProcess;
	private Text textDistance;
	private int check;
	private Line line ;
	/*
	 *  
	 */
	@FXML
	private TextField numofarray;
	@FXML
	private RadioButton increase;
	@FXML
	private RadioButton decrease;
	@FXML
	private BorderPane Content;
	@FXML
	private Button btnPause = new Button();
	@FXML
	private Text textSorted,textUnsorted;

	@FXML
	private void initialize() {
		InDecreaseGroup = new ToggleGroup();
		this.decrease.setToggleGroup(InDecreaseGroup);
		this.increase.setToggleGroup(InDecreaseGroup);
		increase.setSelected(true);

	}

	public void inputNum(ActionEvent event) throws IOException {
		try {
			do {
				num = Integer.valueOf(numofarray.getText());
				if (num < 1)
					numofarray.setText("1");
				if (num > 15)
					numofarray.setText("15");
			} while ((num < 1) || (num > 15));

		} catch (Exception e) {
		}
		if (num > 0) displaySuccessStage();
	}

	public void inputKeyboard(ActionEvent event) throws IOException {
		if(num>0)
		{
		reset();
		Stage stageInput = new Stage();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("fxml/inputfromkeyboard.fxml"));
		AnchorPane input = loader.load();

		InputKeyboardController data = loader.getController();
		data.getData(num, stageInput, array);
		
		
		
		stageInput.initOwner(this.stage);
		stageInput.initModality(Modality.APPLICATION_MODAL);

		stageInput.setTitle("Input from Keyboard");
		Scene scene = new Scene(input);
		stageInput.setScene(scene);
		stageInput.showAndWait();
		if(num == array.size())
		{
		drawElement();
		}
		}
	}

	public void reset() throws IOException {
		this.X = -40;
		this.arrayShape.clear();
		this.array.clear();
		this.circleShape.clear();
		this.textShape.clear();
		this.labelTemp.clear();
	}

	public void inputRandom(ActionEvent event) throws IOException {
		if(num>0)
		{
		reset();
		Random ran = new Random();
		for (int i = 0; i < this.num; i++) {
			this.array.add(10+ran.nextInt(89));
		}
		drawElement();
		displaySuccessStage();
		}
	}
	public void getParent(Stage stage) {
		this.stage = stage;
	}

	public void displaySuccessStage() throws IOException {
		Stage successStage = new Stage();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("fxml/successdialog.fxml"));
		AnchorPane layout = loader.load();

		SuccessStageController data = loader.getController();
		data.getStage(successStage,num);

		successStage.initOwner(this.stage);
		successStage.initModality(Modality.APPLICATION_MODAL);

		Scene scene = new Scene(layout);
		successStage.setTitle("Success");
		successStage.getIcons().add(new Image("/miniproject/picture/icon.png"));
		successStage.setScene(scene);
		successStage.show();
	}

	public void selectDistance() {
		int n = array.size();
		if (n < 10)
		{
			  X=(1045 - num*DISTANCE)/2-18*num;
			DISTANCE = 90;
		}
		else
		{
			X=(1045 - num*DISTANCE)/2;
			DISTANCE = 67;
		}
	}
	private double x;
	public void drawElement() throws IOException {
		selectDistance();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("fxml/content2.fxml"));
		this.contentcenter = loader.load();
		
		
		int i = 0;
		for (int temp : array) {
			X += DISTANCE;
			dataShape tempData = new dataShape(X, Y, temp);
			arrayShape.add(i, tempData);
			i++;
		}
		i = 0;
		for (dataShape tempData : arrayShape) {
			Circle circle = new Circle(tempData.getX() + 20, tempData.getY() + 26, 20, Color.RED);
			Text text = new Text(String.valueOf(tempData.getNum()));
			text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 22));
			text.setFill(javafx.scene.paint.Color.WHITE);
			if (tempData.getNum() > 9)
				text.setLayoutX(tempData.getX() + 10);
			else
				text.setLayoutX(tempData.getX() + 13);
			text.setLayoutY(tempData.getY() + 33);
			Label label;
			if (i < 10)
				label = new Label("  " + i + "  ");
			else
				label = new Label(" " + i + " ");
			label.setFont(Font.font("Times New Roman", 20));
			label.setStyle("-fx-border-style: solid inside;" + "-fx-border-color: blue;");
			label.setLayoutX(tempData.getX() + 4);
			label.setLayoutY(tempData.getY() - 45);

			Label labelNum = new Label("Num of array : " + array.size());
			labelNum.setLayoutX(450);
			labelNum.setLayoutY(25);
			labelNum.setFont(Font.font("Times New Roman", 25));
			labelNum.setStyle("-fx-border-style: solid inside;" + "-fx-border-color: green;");
			labelTemp.add(label);

			textShape.add(text);
			circleShape.add(circle);
			contentcenter.getChildren().add(labelNum);
			i++;
		}
		
		textSorted= new Text();
		textSorted.setLayoutX(arrayShape.get(0).getX()- 18);
		textSorted.setLayoutY(arrayShape.get(0).getY() - 100);
		textSorted.setText("Sorted");
		textSorted.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		textSorted.setFill(Color.GREEN);
		
		textUnsorted = new Text();
		textUnsorted.setLayoutX(arrayShape.get(num-1).getX()-15);
		textUnsorted.setLayoutY(arrayShape.get(num-1).getY() - 100);
		textUnsorted.setText("Unsorted");
		textUnsorted.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		textUnsorted.setFill(Color.RED);
		
		textDistance = new Text();
		textDistance.setLayoutX(400);
		textDistance.setLayoutY(275);
		
		textProcess = new Text();
		textProcess.setLayoutX(420);
		textProcess.setLayoutY(375);
		
		textDistance.setVisible(false);
		textProcess.setVisible(false);
		textSorted.setVisible(false);
		textUnsorted.setVisible(false);
		
		x =arrayShape.get(0).getX()+DISTANCE/2+20;
		double y1 = (arrayShape.get(0).getY()+50);
		double y2 = (arrayShape.get(0).getY()-50);
		line = new Line(x,y1,x,y2);
		line.setStyle("-fx-stroke: green;");
		line.setStrokeWidth(8);
		line.setVisible(false);
		if(num == 1) line.setVisible(false);
		
		contentcenter.getChildren().addAll(textProcess, textDistance,textSorted,textUnsorted,line);
		textProcess.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		textDistance.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		contentcenter.getChildren().addAll(circleShape);
		contentcenter.getChildren().addAll(textShape);
		contentcenter.getChildren().addAll(labelTemp);
		Content.setCenter(contentcenter);
	}
	

	private Thread th2;

	@FXML
	public void start(ActionEvent event) throws InterruptedException {
		line.setVisible(true);
		if (increase.isSelected())
			check = 0;
		if (decrease.isSelected())
			check = 1;
		textProcess.setVisible(true);
		InsertionSortRunable run = new InsertionSortRunable();
		th2 = new Thread(run);
		run.getData(num, check,array,line,x,DISTANCE);
		run.getProcess(textShape, circleShape, textProcess, textSorted, textUnsorted, textDistance, labelTemp);
		th2.setDaemon(true);
		th2.start();
	}

	int check2 = 0;

	@SuppressWarnings("deprecation")
	public void pause() throws InterruptedException {
			if (check2 == 0) {
				th2.suspend();
				btnPause.setText(" Play ");
				btnPause.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
				check2 = 1;
			} else {
				th2.resume();
				btnPause.setText("Pause");
				btnPause.setFont(Font.font("Times New Roman", FontWeight.BOLD, 17));
				check2 = 0;
			}
	}
}
