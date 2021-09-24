
public abstract class Ship {

	int bowRow; //0-9 the front of the ship
	int bowColumn; //0-9 front of the ship
	int length; //number of squares occupied by ship and empty sea location has length of 1
	boolean horizontal; //true if the ship occupies a single row, false otherwise
	boolean[] hit = new boolean [4]; //array of booleans telling weather that part of ship has been hit


	//Returns ship length and is overridden 
	abstract int getLength(); 

	//Returns ship type and is overridden
	abstract String getShipType(); 

	//Returns ship row position that is front of the ship. 
	int getBowRow() {
		return bowRow;
	}

	//Returns ship column position that is front of the ship. 
	int getBowColumn() {
		return bowColumn;
	}

	//Returns if the ship is horizontal or not
	boolean isHorizontal() {
		return horizontal; 
	}
	
	/*
	 * Sets row number of a ship's bow location
	 * 
	 * @param row
	 */
	void setBowRow(int row) {
		this.bowRow = row;
	}

	/*
	 * Sets column of a ship's bow location
	 * 
	 * @param column
	 */
	void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/*
	 * Sets whether the ship is horizontal or vertical
	 * 
	 * @param horizontal 
	 */
	void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}


	/*
	 * This method checks if the given ship can be legally placed horizontally/vertically
	 * at the starting given location [row][column]. This ship will be placed in an instance of ocean so that all 
	 * the ships are placed in the same ocean and that new locations [row][column] can be used to check against
	 * other already existing ships in the ocean. 
	 * 
	 * The conditional ladders will basically check whether the ship is horizontal or vertical. Under those
	 * two conditions, the method will check if the successive rows (if vertical) or successive columns (if horzontal)
	 * can accommodate a ship of a given length.
	 * 
	 * This method will also boundary check and check if there are ships adjacent.
	 * 
	 * If the conditions of legally placing a ship are met at bow location [row][column], then the method
	 * will return true, or otherwise, false if ship can not be placed. 
	 * 
	 * @param row
	 * @param column
	 * @param horizontal 
	 * @param ocean
	 * 
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		int shipLeng = this.getLength();
		boolean areaFine = true;

		//		if (this.getShipType().equals("Submarine")) {
		//			if (column == 0) {
		//				if (row == 0) {
		//					if (ocean.isOccupied(1, 1) || ocean.isOccupied(0, 1) || ocean.isOccupied(1, 0)) {
		//						areaFine = false;
		//					}
		//				}
		//				if (row == 9) {
		//					if (ocean.isOccupied(8, 1) || ocean.isOccupied(8, 0) || ocean.isOccupied(9, 1)) {
		//						areaFine = false;
		//					}
		//				}
		//				if (row != 0 && row != 9) {
		//					if (ocean.isOccupied(row - 1, 1) || ocean.isOccupied(row + 1, 1) || ocean.isOccupied(row, 1) || ocean.isOccupied(row + 1, 0) || ocean.isOccupied(row - 1, 0)) {
		//						areaFine = false;
		//					}
		//				}
		//			}
		//			if (column == 9) {
		//				if (row == 0) {
		//					if (ocean.isOccupied(1, 8) || ocean.isOccupied(0, 8) || ocean.isOccupied(1, 9)) {
		//						areaFine = false;
		//					}
		//				}
		//				if (row == 9) {
		//					if (ocean.isOccupied(8, 8) || ocean.isOccupied(8, 9) || ocean.isOccupied(9, 8)) {
		//						areaFine = false;
		//					}
		//				}
		//				if (row != 0 && row != 9) {
		//					if (ocean.isOccupied(row - 1, 8) || ocean.isOccupied(row + 1, 8) || ocean.isOccupied(row, 8) || ocean.isOccupied(row + 1, 9) || ocean.isOccupied(row - 1, 9)) {
		//						areaFine = false;
		//					}
		//
		//				}
		//			}
		//			if (column != 0 && column != 9) {
		//				if (row == 0) {
		//					if (ocean.isOccupied(row + 1, column - 1) || ocean.isOccupied(row + 1, column + 1) || ocean.isOccupied(row + 1, column) || ocean.isOccupied(row, column + 1) 
		//							|| ocean.isOccupied(row, column - 1)) {
		//						areaFine = false;
		//					}
		//				}
		//				if (row == 9) {
		//					if (ocean.isOccupied(row - 1, column - 1) || ocean.isOccupied(row - 1, column + 1) || ocean.isOccupied(row, column + 1) || ocean.isOccupied(row, column - 1) 
		//							|| ocean.isOccupied(row - 1, column)) {
		//						areaFine = false;
		//					}
		//				}
		//				if (row != 0 && row != 9) {
		//					if (ocean.isOccupied(row - 1, column - 1) || ocean.isOccupied(row - 1, column + 1) || ocean.isOccupied(row + 1, column - 1) || ocean.isOccupied(row + 1, column + 1)
		//							|| ocean.isOccupied(row - 1, column) || ocean.isOccupied(row + 1, column) || ocean.isOccupied(row, column - 1) || ocean.isOccupied(row, column + 1)) {
		//						areaFine = false;
		//					}
		//				}
		//			}
		//
		//		}




		if (horizontal) {
			if (shipLeng + column - 1 > 9) {
				areaFine = false;
			}
			else {
				if (shipLeng + column - 1 == 9) {
					for (int i = 0; i < shipLeng + 1; i++) {
						if (ocean.isOccupied(row, i + column - 1)) {
							areaFine = false;
						}
					}
				}
				if (column == 0) {
					for (int i = 0; i < shipLeng + 1; i++) {
						if (ocean.isOccupied(row, column + i)) {
							areaFine = false;
						}
					}
				}
				if (column != 0 && shipLeng + column - 1 != 9) {
					for (int i = 0; i < shipLeng + 2; i++) {
						if (ocean.isOccupied(row, column + i - 1)) {
							areaFine = false;
						}
					}
				}
			}
		}


		if (!horizontal) {
			if (shipLeng + row - 1 > 9) {
				areaFine = false;
			}
			else {
				if (shipLeng + row - 1 == 9) {
					for (int i = 0; i < shipLeng + 1; i++) {
						if (ocean.isOccupied(i + row - 1, column)) {
							areaFine = false;
						}
					}
				}
				if (row == 0) {
					for (int i = 0; i < shipLeng + 1; i++) {
						if (ocean.isOccupied(i + row, column)) {
							areaFine = false;
						}
					}
				}
				if(shipLeng + row - 1 != 9 & row != 0) {
					for (int i = 0; i < shipLeng + 2; i++) {
						if (ocean.isOccupied(i + row - 1, column)) {
							areaFine = false;
						}
					}
				}
			}
		}

		//from here on we check if boats are next to the location 
		if (areaFine) {
			for (int i = 0; i < shipLeng + 1; i++) {
				if (horizontal && row == 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(1, i + column)) { //|| ocean.isOccupied(1, shipLeng)) {
							areaFine = false;
						}
					}
					if (column + shipLeng - 1 == 9) {
						if (ocean.isOccupied(1, i + column - 1)) { // || ocean.isOccupied(1, 9)) {
							areaFine = false;
						}
					}
					if(column!= 0 && column + shipLeng - 1 < 9) {
						if (ocean.isOccupied(1, column - 1)  || ocean.isOccupied(1, column + i)) { //|| ocean.isOccupied(1, column + shipLeng)) {
							areaFine = false;
						}
					}
				}
				//if not edges
				if (horizontal && row == 9) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(8, i + column)) {// || ocean.isOccupied(8, shipLeng)) {
							areaFine = false;
						}
					}
					if (column + shipLeng - 1 == 9) {
						if (ocean.isOccupied(8, i + column - 1)) {// || ocean.isOccupied(8, 9)) {
							areaFine = false;
						}
					}
					if (column != 0 && column + shipLeng - 1 < 9) {
						if (ocean.isOccupied(8, column - 1) || ocean.isOccupied(8, column + i)) {// || ocean.isOccupied(8, column + shipLeng) ) {
							areaFine = false;
						}
					}
				}
				//if not edges 
				if (horizontal && row != 9 && row != 0) {
					if(column == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(row - 1, i + column)) { //|| ocean.isOccupied(row - 1, shipLeng)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, i + column)) { // || ocean.isOccupied(row + 1, shipLeng)) {
							areaFine = false;
						}
					}
					if (column + shipLeng - 1 == 9) {
						if (ocean.isOccupied(row - 1, i + column - 1)) {// || ocean.isOccupied(row - 1, 9)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, i + column - 1)) {// || ocean.isOccupied(row + 1, 9)) {
							areaFine = false;
						}
					}
					if(column != 0 && column + shipLeng - 1 < 9) {
						if (ocean.isOccupied(row - 1, column - 1)  || ocean.isOccupied(row - 1, column + i)) { //|| ocean.isOccupied(row - 1, column + shipLeng)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row + 1, column - 1) || ocean.isOccupied(row + 1, column + i)) {// || ocean.isOccupied(row + 1, column + shipLeng) ) {
							areaFine = false;
						}
					}
				}

				if (!horizontal && column == 0) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, 1)) { // || ocean.isOccupied(shipLeng, 1)) {
							areaFine = false;
						}
					}
					if (row + shipLeng - 1 == 9) {
						if (ocean.isOccupied(i + row - 1, 1)) { // || ocean.isOccupied(9,1)) {
							areaFine = false;
						}
					}
					if (row != 0 && row + shipLeng - 1 < 9) {
						if (ocean.isOccupied(row - 1, 1) || ocean.isOccupied(row + i, 1)) {// || ocean.isOccupied(row + shipLeng, 1) ) {
							areaFine = false;
						}
					}
				}
				//if not edges
				if (!horizontal && column == 9) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, 8)) { // || ocean.isOccupied(shipLeng, 8)) {
							areaFine = false;
						}
					}
					if (row + shipLeng - 1 == 9) {
						if (ocean.isOccupied(i + row - 1, 8)) { // || ocean.isOccupied(9, 8)) {
							areaFine = false;
						}
					}
					if (row != 0 && row + shipLeng - 1 < 9) {
						if (ocean.isOccupied(row - 1, 8)  || ocean.isOccupied(row + i, 8)) { // || ocean.isOccupied(row + shipLeng, 8)) {
							areaFine = false;
						}
					}
				}
				//if not edges 
				if (!horizontal && column != 9 && column != 0) {
					if(row == 0) { //If spot is top left corner of ocean
						if (ocean.isOccupied(i + row, column - 1)) { // || ocean.isOccupied(shipLeng, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(i + row, column + 1)) { // || ocean.isOccupied(shipLeng, column + 1)) {
							areaFine = false;
						}
					}
					if (row + shipLeng - 1 == 9) {
						if (ocean.isOccupied(i + row - 1, column - 1)) { // || ocean.isOccupied(9, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(i + row - 1, column + 1)) { // || ocean.isOccupied(9, column + 1)) {
							areaFine = false;
						}
					}
					if(row!=0 && row + shipLeng - 1 < 9) {
						if (ocean.isOccupied(row - 1, column - 1)  || ocean.isOccupied(row + i, column - 1)) { // || ocean.isOccupied(row + shipLeng, column - 1)) {
							areaFine = false;
						}
						if (ocean.isOccupied(row - 1, column + 1)  || ocean.isOccupied(row + i, column + 1)) { // || ocean.isOccupied(row + shipLeng, column + 1)) {
							areaFine = false;
						}
					}
				}

			}

		}
		return areaFine;
	}



	/**
	 * This method places the given ship horizontally/vertically at the starting given location [row][column].
	 * This method uses a for loop and uses the length of the ship to determine how many times to place the ships
	 * in the ocean.
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

		this.setBowColumn(column);
		this.setBowRow(row);
		this.setHorizontal(horizontal);
		for (int i = 0; i < this.getLength(); i++) {
			if (horizontal) {
				ocean.setShips(row, column + i, this);
			}
			else {
				ocean.setShips(row + i, column, this);
			}
		}


	}

	/*
	 * This method will update the hit[] array of each the ship that happens to be at location [row][column]
	 * only if the ship is not already sunk and that the getShipType at said location is not "empty." 
	 * Otherwise, location [row][column] does not contain a ship. 
	 * 
	 * @param row
	 * @param column
	 */
	boolean shootAt(int row, int column) {
		if (!this.getShipType().equals("empty") && !this.isSunk()) {
		//	Ship currentShip = ocean.getShipArray()[row][column];
			if(this.isHorizontal()) {
				this.hit[column - this.getBowColumn()] = true;
			}
			else {
				this.hit[row - this.getBowRow()] = true;
			}
			return true;
		}
		return false;
	}
	
	
	//This method returns whether the ship is sunk and is overridden
	boolean isSunk() {
		return true;
	}

}
