package miniproject;

import javafx.animation.*;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class shelf {
  public static final int height = 20;
  public static final int max_floor = 7;
  public static final int padding = 20;
  public static final int base_border = 10;
  public static final Color[] colors = {
    Color.BLUE,
    Color.DARKSLATEBLUE,
    Color.FIREBRICK,
    Color.YELLOW,
    Color.GOLD,
    Color.DARKBLUE,
    Color.FUCHSIA
  };

  public VBox shelf;

  
  public shelf() {
   
    int depth = (max_floor + 2) * height;
    int width = 150 * 3 + padding * 2;
    Rectangle base = new Rectangle(0, depth, width, height);
    base.setArcWidth(base_border);
    base.setArcHeight(base_border);
    base.setFill(Color.BLACK);

    
    Rectangle collum1 = new Rectangle(0, 0, height, depth - height);
    collum1.setArcWidth(20);
    collum1.setArcHeight(20);
    collum1.setFill(Color.BLACK);

    Rectangle collum2 = new Rectangle(0, 0, height, depth - height);
    collum2.setArcWidth(20);
    collum2.setArcHeight(20);
    collum2.setFill(Color.BLACK);

    Rectangle collum3 = new Rectangle(0, 0, height, depth - height);
    collum3.setArcWidth(20);
    collum3.setArcHeight(20);
    collum3.setFill(Color.BLACK);

    
    HBox collums = new HBox();
    collums.getChildren().addAll(collum1, collum2, collum3);
    collums.setAlignment(Pos.CENTER);
    collums.setSpacing((width - height * 3) / 3 + 5);

    shelf = new VBox();
    shelf.getChildren().addAll(collums, base);
    shelf.setAlignment(Pos.TOP_CENTER);
    shelf.setSpacing(20 * -0.5);
  }
}
