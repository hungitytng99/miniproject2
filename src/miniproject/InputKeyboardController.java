package miniproject;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputKeyboardController {
	ShellSortController shell;
	private Stage stage;
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private int num;
	private int i = 1;
	@FXML private TextField sttField;
    @FXML private Label stt;
    @FXML public void initialize()
    {
    	stt.setText(String.valueOf(i));
    }
    public void inputkeyboard(ActionEvent event)
    {
    	try
    	{
    		stt.setText(String.valueOf(i+1));
    		array.add(Integer.valueOf(sttField.getText()));
    		sttField.setText("");
    		i++;
    		if(i > num) 
    			{
    			    stage.close();	
    			}
    	}catch(Exception e)
    	{
    	}
    }
    public void getData(int num,Stage stage,ArrayList<Integer> array)
    {
    	this.num = num;
    	this.stage = stage;
    	this.array = array;
    }
}	
