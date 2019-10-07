package miniproject;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ShellSortRunable implements Runnable {
	private int num = 1;
	private ArrayList<Text> textShape = new ArrayList<Text>();
	private ArrayList<Circle> circleShape = new ArrayList<Circle>();
	private ArrayList<Label> labelTemp = new ArrayList<Label>();
	private Text textProcess;
	private Text textDistance;
	private int check = 0;
	@Override
	public void run() {
		if (check == 0)
			increase();
		else if (check == 1)
			decrease();
	}

	public void decrease() {
		int dis = 1;
		while (dis < num) {
			dis = dis * 3 + 1;
		}
		computeDis(dis);
		int i, j, X;

		while (dis > 0) {
			for (i = dis; i < num; i++) {
				X = Integer.parseInt(textShape.get(i).getText());
				j = i;
				textProcess.setText("Compare a[" + j + "] and a[" + (j - dis) + "].");
				circleShape.get(j).setFill(Color.GREEN);
				circleShape.get(j - dis).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-style: solid inside;" + "-fx-border-color: red;");
				sleep(1000);
				circleShape.get(j).setFill(Color.RED);
				circleShape.get(j - dis).setFill(Color.RED);
				while ((Integer.parseInt(textShape.get(j - dis).getText()) < X) && (j >= dis - 1)) {
					textShape.get(j).setText(textShape.get(j - dis).getText());
					circleShape.get(j).setFill(Color.GREEN);
					j -= dis;
					textShape.get(j).setText(String.valueOf(X));
					circleShape.get(j).setFill(Color.GREEN);
					textProcess.setText("Change a[" + (j + dis) + "] and a[" + j + "].");
					sleep(1000);
					circleShape.get(j + dis).setFill(Color.RED);
					circleShape.get(j).setFill(Color.RED);
					if ((j - dis) >= 0) {
						textProcess.setText("Compare a[" + j + "] and a[" + (j - dis) + "].");
						circleShape.get(j).setFill(Color.GREEN);
						circleShape.get(j - dis).setFill(Color.GREEN);
						sleep(1000);
						circleShape.get(j - dis).setFill(Color.RED);
						circleShape.get(j).setFill(Color.RED);
					} else {
						break;
					}
				}
				labelTemp.get(i).setStyle("-fx-border-style: solid inside;" + "-fx-border-color: blue;");
			}
			dis = (dis - 1) / 3;
			computeDis(dis);

		}
		textDistance.setVisible(false);
		textProcess.setLayoutX(450);
		textProcess.setText("COMPLETE !!!");
		textProcess.setFill(Color.BLUE);
		for (Circle circle : circleShape) {
			circle.setFill(Color.BLUE);
		}
		for (Text textTemp : textShape) {
			textTemp.setFill(Color.RED);
		}
	}

	public void increase() {
		int dis = 1;
		while (dis < num) {
			dis = dis * 3 + 1;
		}
		computeDis(dis);
		int i, j, X;

		while (dis > 0) {
			for (i = dis; i < num; i++) {
				X = Integer.parseInt(textShape.get(i).getText());
				j = i;
				textProcess.setText("Compare a[" + j + "] and a[" + (j - dis) + "].");
				circleShape.get(j).setFill(Color.GREEN);
				circleShape.get(j - dis).setFill(Color.GREEN);
				labelTemp.get(j).setStyle("-fx-border-style: solid inside;" + "-fx-border-color: red;");
				sleep(1000);
				circleShape.get(j).setFill(Color.RED);
				circleShape.get(j - dis).setFill(Color.RED);
				while ((Integer.parseInt(textShape.get(j - dis).getText()) > X) && (j >= dis - 1)) {
					textShape.get(j).setText(textShape.get(j - dis).getText());
					circleShape.get(j).setFill(Color.GREEN);
					j -= dis;
					textShape.get(j).setText(String.valueOf(X));
					circleShape.get(j).setFill(Color.GREEN);
					textProcess.setText("Change a[" + (j + dis) + "] and a[" + j + "].");
					sleep(1000);
					circleShape.get(j + dis).setFill(Color.RED);
					circleShape.get(j).setFill(Color.RED);
					if ((j - dis) >= 0) {
						textProcess.setText("Compare a[" + j + "] and a[" + (j - dis) + "].");
						circleShape.get(j).setFill(Color.GREEN);
						circleShape.get(j - dis).setFill(Color.GREEN);
						sleep(1000);
						circleShape.get(j - dis).setFill(Color.RED);
						circleShape.get(j).setFill(Color.RED);
					} else {
						break;
					}
				}
				labelTemp.get(i).setStyle("-fx-border-style: solid inside;" + "-fx-border-color: blue;");
			}
			dis = (dis - 1) / 3;
			computeDis(dis);

		}
		textDistance.setVisible(false);
		textProcess.setLayoutX(450);
		textProcess.setText("COMPLETE !!!");
		textProcess.setFill(Color.BLUE);
		for (Circle circle : circleShape) {
			circle.setFill(Color.YELLOW);
		}
		for (Text textTemp : textShape) {
			textTemp.setFill(Color.RED);
		}
	}

	public void computeDis(int h) {
		textDistance.setText("Compute distance");
		textDistance.setVisible(true);
		sleep(1000);
		textDistance.setText("Distance = " + h);
		sleep(1000);
	}

	public void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void get(int num, ArrayList<Text> textShape, ArrayList<Circle> circleShape, Text textProcess,
			Text textDistance, ArrayList<Label> labelTemp, int check) {
		this.num = num;
		this.textShape = textShape;
		this.circleShape = circleShape;
		this.textProcess = textProcess;
		this.textDistance = textDistance;
		this.labelTemp = labelTemp;
		this.check = check;
	}

}
