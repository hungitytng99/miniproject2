package miniproject;

import java.util.ArrayList;
import java.util.Stack;

import miniproject.*;

public class Town extends ButtonPanel {
	private ArrayList<Stack<floor>> floors = new ArrayList<Stack<floor>>();

	public Town(int numberOfDisks) {
		Stack<floor> floor1 = new Stack<floor>();

		for (int index = 0; index < numberOfDisks; index++) {
			floor1.push(new floor(index));
		}

		floors.add(floor1);
		floors.add(new Stack<floor>());
		floors.add(new Stack<floor>());
		shelf shelfs = new shelf();
		this.getChildren().add(shelfs.shelf);
		for (floor Floor : floor1) {
			this.getChildren().add(Floor.self);
		}
		initializeAnimationSteps();
	}

	private void moveTopDisk(int from_rod, int to_rod) {
		floor Floor = floors.get(from_rod).pop();

		Floor.Move(floors.get(to_rod).size(), to_rod - from_rod);

		floors.get(to_rod).push(Floor);
	}

	@Override
	public void initializeAnimationSteps() {

		towerOfHanoi(floors.get(0).size(), 0, 2, 1);
	}

	private void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod) {
		if (n == 1) {

			steps.add(new Run() {
				@Override
				public int play() {
					moveTopDisk(from_rod, to_rod);
					return -1;
				}
			});

			return;
		}

		towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);

		steps.add(new Run() {
			@Override
			public int play() {
				moveTopDisk(from_rod, to_rod);
				return -1;
			}
		});

		towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
	}

}
