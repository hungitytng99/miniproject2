package miniproject;

import java.util.ArrayList;

import javafx.animation.PathTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class InsertionSortRunable implements Runnable {
	private int num = 1;
	private ArrayList<Text> textShape = new ArrayList<Text>();
	private ArrayList<Circle> circleShape = new ArrayList<Circle>();
	private ArrayList<Label> labelTemp = new ArrayList<Label>();
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private Text textProcess;
	private Text textDistance;
	private int check = 0;
	private int time = 1000;
	private Text textSorted, textUnsorted;
	private Line line;

	@Override
	public void run() {

		textSorted.setVisible(true);
		if (num > 1)
			textUnsorted.setVisible(true);
		if (check == 0)
			increase();
		else if (check == 1)
			decrease();

	}

	public void decrease() {
		int key, j;
		circleShape.get(0).setFill(Color.GREEN);
		for (int i = 1; i < num; i++) {
			labelTemp.get(i).setStyle("-fx-border-color: yellow;");
			circleShape.get(i).setFill(Color.YELLOW);
			textProcess.setText("Find suitable positon for a[" + i + "].");
			sleep(time);

			key = Integer.parseInt(textShape.get(i).getText());
			j = i - 1;

			textProcess.setText("Compare a[" + i + "] and a[" + j + "].");
			circleShape.get(j).setFill(Color.YELLOW);
			labelTemp.get(j).setStyle("-fx-border-color: yellow;");
			sleep(time);
			if (key > array.get(j)) {
				circleShape.get(j).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-color: yellow;");
			}
			while (j >= 0 && key > Integer.parseInt(textShape.get(j).getText())) {

				textProcess.setText("Update a[" + (j + 1) + "] by a[" + (j) + "].");
				circleShape.get(j).setFill(Color.GREEN);
				circleShape.get(j + 1).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-color: green;");
				labelTemp.get(j + 1).setStyle("-fx-border-color: green;");
				textShape.get(j + 1).setText(textShape.get(j).getText());
				sleep(time);
				j = j - 1;
				if (j < 0)
					break;
				circleShape.get(j).setFill(Color.YELLOW);
				circleShape.get(j + 1).setFill(Color.YELLOW);
				labelTemp.get(j).setStyle("-fx-border-color: yellow;");
				labelTemp.get(j + 1).setStyle("-fx-border-color: yellow;");
				textProcess.setText("Compare a[" + (j + 1) + "] and a[" + j + "].");
				sleep(time);

			}
			circleShape.get(i).setFill(Color.GREEN);
			labelTemp.get(i).setStyle("-fx-border-color: green;");
			textProcess.setText("The suitable position for a[" + i + "] is a[" + (j + 1) + "].");
			circleShape.get(j + 1).setFill(Color.GREEN);
			labelTemp.get(j + 1).setStyle("-fx-border-color: green;");
			if (j >= 0) {
				circleShape.get(j).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-color: green;");
			}
			textShape.get(j + 1).setText(String.valueOf(key));
			sleep(time / 2);
			if (num > 1)
				moveLine(i);
			sleep(time);
		}
		line.setVisible(false);
		textDistance.setVisible(false);
		textProcess.setLayoutX(450);
		textProcess.setText("COMPLETE !!!");
		textProcess.setFill(Color.GREEN);
		textUnsorted.setVisible(false);
	}

	public void increase() {
		int key, j;
		circleShape.get(0).setFill(Color.GREEN);
		for (int i = 1; i < num; i++) {
			labelTemp.get(i).setStyle("-fx-border-color: yellow;");
			circleShape.get(i).setFill(Color.YELLOW);
			textProcess.setText("Find suitable positon for a[" + i + "].");
			sleep(time);

			key = Integer.parseInt(textShape.get(i).getText());
			j = i - 1;

			textProcess.setText("Compare a[" + i + "] and a[" + j + "].");
			circleShape.get(j).setFill(Color.YELLOW);
			labelTemp.get(j).setStyle("-fx-border-color: yellow;");
			sleep(time);
			if (key > array.get(j)) {
				circleShape.get(j).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-color: yellow;");
			}
			while (j >= 0 && key < Integer.parseInt(textShape.get(j).getText())) {

				textProcess.setText("Update a[" + (j + 1) + "] by a[" + (j) + "].");
				circleShape.get(j).setFill(Color.GREEN);
				circleShape.get(j + 1).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-color: green;");
				labelTemp.get(j + 1).setStyle("-fx-border-color: green;");
				textShape.get(j + 1).setText(textShape.get(j).getText());
				sleep(time);
				j = j - 1;
				if (j < 0)
					break;
				circleShape.get(j).setFill(Color.YELLOW);
				circleShape.get(j + 1).setFill(Color.YELLOW);
				labelTemp.get(j).setStyle("-fx-border-color: yellow;");
				labelTemp.get(j + 1).setStyle("-fx-border-color: yellow;");
				textProcess.setText("Compare a[" + (j + 1) + "] and a[" + j + "].");
				sleep(time);

			}
			circleShape.get(i).setFill(Color.GREEN);
			labelTemp.get(i).setStyle("-fx-border-color: green;");
			textProcess.setText("The suitable position for a[" + i + "] is a[" + (j + 1) + "].");
			circleShape.get(j + 1).setFill(Color.GREEN);
			labelTemp.get(j + 1).setStyle("-fx-border-color: green;");
			if (j >= 0) {
				circleShape.get(j).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-color: green;");
			}
			textShape.get(j + 1).setText(String.valueOf(key));
			sleep(time / 2);
			if (num > 1)
				moveLine(i);
			sleep(time);
		}
		line.setVisible(false);
		textDistance.setVisible(false);
		textProcess.setLayoutX(450);
		textProcess.setText("COMPLETE !!!");
		textProcess.setFill(Color.GREEN);
		textUnsorted.setVisible(false);
	}

	private double tempY, tempX1, tempX2;
	private double startX;
	private double DISTANCE;

	public void moveLine(int i) {
		tempY = 200;
		tempX1 = startX + (i - 1) * DISTANCE;
		tempX2 = tempX1 + DISTANCE;
		PathTransition trans = new PathTransition();
		Line tempLine = new Line(tempX1, tempY, tempX2, tempY);

		trans.setNode(line);
		trans.setPath(tempLine);
		trans.setDuration(Duration.seconds(time / 1000));
		trans.setCycleCount(1);
		trans.play();
	}

	public void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getData(int num, int check, ArrayList<Integer> array, Line line, double startX, double DISTANCE) {
		this.num = num;
		this.check = check;
		this.array = array;
		this.line = line;
		this.startX = startX;
		this.DISTANCE = DISTANCE;
	}

	public void getProcess(ArrayList<Text> textShape, ArrayList<Circle> circleShape, Text textProcess, Text textSorted,
			Text textUnsorted, Text textDistance, ArrayList<Label> labelTemp) {
		this.textShape = textShape;
		this.circleShape = circleShape;
		this.textProcess = textProcess;
		this.textDistance = textDistance;
		this.labelTemp = labelTemp;
		this.textSorted = textSorted;
		this.textUnsorted = textUnsorted;
	}

}
