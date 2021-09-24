
public class Battleship extends Ship {


	/**
	 * Battleship constructor with length set to 4 and initialize array of hit array 
	 * depending on the length of the ship. 
	 */
	Battleship() {
		this.length = 4;
		this.hit = new boolean[4]; 
		for (int i = 0; i < length; i++) {
			hit[i] = false;
		}
	}
	
	//Overridden to return appropriate length 
	@Override 
	public int getLength() {
		return length;
	}

	/**
	 * Overridden to give appropriate strings to show the state of the ship
	 * "x" if the ship is sunk
	 * "S" if the ship is not sunk but hit at a certain location
	 */
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		}
		else {
			return "S";
		}
	}

	
	/*
	 * Checks the ship's hit array for number of trues (max number = ship length)
	 */
	@Override 
	boolean isSunk() {
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			if (hit[i] == true) {
				counter++;
			}
		}
		if (counter == 4) {
			return true;
		}
		else {
			return false;
		}
	}

	//To return the ship type
	@Override
	String getShipType() {
		return "Battleship";
	}
}
