package miniproject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import miniproject.*;

import javafx.scene.layout.AnchorPane;

public abstract class ButtonPanel extends AnchorPane implements Button {

	protected ArrayList<Run> steps = new ArrayList<Run>();
	protected int currentStep = -1;
	protected Timer playTimer;
	protected boolean isExecutingAnimation;
	
	
	
	public abstract void initializeAnimationSteps();
	
	public int goNext() {
		if (currentStep >= steps.size() - 1) {
			return 1;
		}
		if (isExecutingAnimation) {
			return 1;
		}
		
		currentStep++;
		Run animation = steps.get(currentStep);
		int instructionIndex = animation.play();
		isExecutingAnimation = true;
		Timer animationTimer = new Timer();
		animationTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				isExecutingAnimation = false;
			}
			
		}, 400);
		
		return instructionIndex;
	}
	@Override
	public void play() {
		playTimer = new Timer();

		playTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				goNext();
				if (currentStep >= steps.size() - 1) {
					playTimer.cancel();
					playTimer.purge();
			        return;
				}
			}
			
		}, 0, 600);
	}
	
	@Override
	public void pause() {
		 playTimer.cancel();
		 playTimer.purge();
	}
	
	public boolean isLastAnimation() {
		return currentStep >= steps.size() - 1;
	}
}
