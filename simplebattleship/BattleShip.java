package simplebattleship;

import java.util.ArrayList;

public class BattleShip {

	private ArrayList<String> locationCells; // an ArrayList of cell locations
	private String name; // the battleship's name

	public void setLocationCells(ArrayList<String> loc) { // A setter method
															// that updates the
															// battleship's
															// location.
		locationCells = loc;
	}

	public void setName(String n) { // basic setter method
		name = n;
	}

	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);

			if (locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}
		return result;
	}

}
