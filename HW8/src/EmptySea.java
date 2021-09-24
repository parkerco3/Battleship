
public class EmptySea extends Ship {
	
	
	/**
	 * EmptySea constructor with length set to 1
	 */
	EmptySea() {
		this.length = 1;
	}
	
	//Overridden to always return false because EmptySea
	@Override 
	boolean shootAt(int row, int column) {
		return false;
	}
	
	//Overridden to always return false because EmptySea
	@Override 
	boolean isSunk() {
		return false;
	}
	
	//Overridden to alwasy return a dash because there is no ship
	@Override
	public String toString() {
		return "-";
	}
	
	//To return the ship type, which in this case is empty
	@Override
	String getShipType() {
		return "empty";
	}
	
	//Overridden to return appropriate length
	@Override 
	public int getLength() {
		return length;
	}

}
