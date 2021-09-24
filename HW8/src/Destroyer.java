
public class Destroyer extends Ship {

	/**
	 * Destroyer constructor with length set to 2 and initialize array of hit array 
	 * depending on the length of the ship. 
	 */
	Destroyer() {
		this.length = 2;
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
	
	//To return the ship type
	@Override
	String getShipType() {
		return "Destroyer";
	}
	
	/*
	 * Checks the ship's hit array for number of trues (max number = ship length)
	 */
	@Override 
	boolean isSunk() {
		int counter = 0;
		for (int i = 0; i < 2; i++) {
			if (hit[i] == true) {
				counter++;
			}
		}
		if (counter == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Overridden to give appropriate strings to show state of the ship
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

}
