package miniproject;

import java.lang.Math;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class floor {	
	private int x;
	private int y;
	public Rectangle self;


	public floor(int index) {
		int width = 150 - (index + 1) * 20;
		int x = (150 - width) / 2;
		int y = (shelf.max_floor - index) * shelf.height - 20 / 2;

		this.x = x;
		this.y = y;
		self = new Rectangle(x, y, width, shelf.height);
		self.setArcWidth(30);
		self.setArcHeight(30);
		self.setFill(shelf.colors[index]);
	}

	public void Move(int index, int offset) {
		SequentialTransition action = new SequentialTransition();
		action.getChildren().addAll(moveVertical(shelf.max_floor + 1), moveHorizontal(offset), moveVertical(index));
		action.play();
	}

	
	TranslateTransition moveVertical(int index) {
		int y = (shelf.max_floor - index) * shelf.height -20 / 2;
		int delta = y - this.y;
		this.y = y;
		return move(0, delta);
	}

	
	TranslateTransition moveHorizontal(int offset) {
		int delta = offset * (150 + shelf.padding);
		x = x + delta;
		return move(delta, 0);
	}


	TranslateTransition move(int x, int y) {
		TranslateTransition transition = new TranslateTransition(Duration.millis(500), self);

		transition.setByX(x);
		transition.setByY(y);
		return transition;
	}
}
