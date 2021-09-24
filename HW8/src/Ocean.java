import java.util.Random;
import java.util.*;

public class Ocean {

	public static Ship[][] ships = new Ship[10][10];
	int shotsFired; 
	int hitCount; //hit shit, increase it but hitting the same spot don't increase it
	int shipsSunk; //increment to 10 total ships sunk
	static ArrayList<int[]> userInputs = new ArrayList<int[]>();
	int[] input = new int[2];

	Random randomRow = new Random();
	Random randomColumn = new Random();
	Random horOrVert = new Random();
	int upperbound = 10;


	//This returns the input location set by the user. 
//	public int[] getInput() {
//		return input;
//	}

	//This sets the userInput location (where to shoot) and adds the location into ArrayList <int[]> userInputs 
//		public void setInput(int[] input) {
//			this.input = input;
//			userInputs.add(input);
//		}

	/*
	 * This method sets a given ship at given locations [row][column].
	 * 
	 * @param row
	 * @param column
	 * @param ship
	 */
	void setShips(int row, int column, Ship ship) {
		ships[row][column] = ship;
	}

	/**
	 * This method initializes the following game variables:
	 * 
	 * 1) shotsFired - number of shots fired during the game
	 * 2) hitCount - number of shots that hit a ship during the game
	 * 3) shipsSunk - number of ships sunk
	 * 4) input - contains array of size 2 to include shots at [[row],[column]]
	 * 
	 * This method also fills in the null locations of the 2D ship array with an emptySea
	 * to indicate that the specific location does not contain a ship. 
	 */
	Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		input = null;
		//userInputs.clear();
		int arr[] = {10, 10};
		input = arr;
		userInputs.add(input);

		//adds emptySea into null
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (ships [i][j] == null) {
					EmptySea emptySea = new EmptySea();
					ships [i][j] = emptySea;
				}
			}
		}
	}

	/**
	 * This method sets the userInputs, which will include all user choices of coordinates he/she wants
	 * to shootAt.
	 * 
	 * @param userInputs
	 */
	public void setUserInputs(int[] input) {
		Ocean.userInputs.add(input);
	}

	/*
	 * This method will place all the ships. It will first create:
	 * (1) Battleship
	 * (2) Cruisers
	 * (3) Destroyers
	 * (4) Submarines
	 * 
	 * Then, with a for loop, it will put the ships into the fleet array containing 10 ships. 
	 * 
	 * Then, using random generators to generate (1) row and column (0-9) and (2) whether the ship
	 * will be horizontal or vertical. 
	 * 
	 * Once these are generated, the method calls okToPlaceShipAt() method until the ship can be
	 * legally placed (i.e. no overlapping of ships + no adjacency to other ships + full fits the entire ship).
	 * It will iterate through all the ships in fleet, from largest (Battleship) to smallest (Submarine).
	 */
	public void placeAllShipsRandomly() { //feed in a ship so that the code is cleaner


		Ship battleship = new Battleship();
		Ship cruiser1 = new Cruiser();
		Ship cruiser2 = new Cruiser();
		Ship destroy1 = new Destroyer();
		Ship destroy2 = new Destroyer();
		Ship destroy3 = new Destroyer();
		Ship sub1 = new Submarine();
		Ship sub2 = new Submarine();
		Ship sub3 = new Submarine();
		Ship sub4 = new Submarine();
		Ship[] fleet = new Ship[10];

		for (int i = 0; i < 1; i++) {
			fleet[i] = battleship;
			fleet[i+1] = cruiser1;
			fleet[i+2] = cruiser2;
			fleet[i+3] = destroy1;
			fleet[i+4] = destroy2;
			fleet[i+5] = destroy3;
			fleet[i+6] = sub1;
			fleet[i+7] = sub2;
			fleet[i+8] = sub3;
			fleet[i+9] = sub4;
		}

		for (int i = 0; i < fleet.length; i++) {
			int randomR = randomRow.nextInt(upperbound);
			int randomC = randomColumn.nextInt(upperbound);
			boolean horVert = horOrVert.nextBoolean();

			while(!fleet[i].okToPlaceShipAt(randomR, randomC, horVert, this)) {
				randomR = randomRow.nextInt(upperbound);
				randomC = randomColumn.nextInt(upperbound);
				horVert = horOrVert.nextBoolean();
			}
			fleet[i].placeShipAt(randomR, randomC, horVert, this);
		}
	}

	/*
	 * This method returns a boolean depending on if there is a ship at the location (row, column).
	 * Specifically, this method gets the ship type of the ship at location (row, column) and
	 * if the return string is "empty", it will return false and any string other than "empty",
	 * this method will return true, indicating that the location (row, column) is occupied. 
	 * 
	 * @param row
	 * @param column
	 */
	boolean isOccupied(int row, int column) {
		if (ships[row][column].getShipType().equals("empty")) { //would this have an issue with all different types of ships
			//System.out.println("location is emptySea");
			return false;
		}
		else {
			//System.out.println("location is occupied");
			return true;
		}
	}

	/*
	 * This method returns a boolean depending if the there is a ship at location (row, column).
	 * For it to return true, there must be a ship at the chosen location in order for the ship
	 * to be "shot at", which is determined whether the getShipType at the location is "empty" or else.
	 * If "empty", there is no ship at location (row, column) and return false. Else, the method will return true. 
	 * 
	 * @param row
	 * @param column
	 */
	boolean shootAt(int row, int column) {
		shotsFired++;
		if (!ships[row][column].getShipType().equals("empty") && !ships[row][column].isSunk()) {
			hitCount++;
			return true;
		}
		// ------------------- implement shooting 
		// ------------------- This updates shotsfired and hitscount, if the ship becomes sunk, the additional shots return false
		return false;
	}


	//Returns total number of shots fired during the game 
	int getShotsFired() {
		return shotsFired;
	}

	//Returns number of shoots that actually hit a ship in the ocean
	int getHitsCount() {
		return hitCount;
	}

	//Returns number of ships that are sunk. 10 sunk ships indicate the game is over
	int getShipsSunk() {
		return shipsSunk;
	}
	
	//Sets number of sunk ships, easier for JUnitTesting for isGameOver() method
	int setShipsSunk(int input) {
		this.shipsSunk = input;
		return shipsSunk;	
	}

	//Returns T/F if the game is over. The game is over when all 10 ships are sunk
	boolean isGameOver() {
		if (shipsSunk == 10) {

			return true;
		}
		else {

			return false;
		}
	}

	//Returns the ships 2D array
	Ship[][] getShipArray() {
		return ships;
	}

	/*
	 * This method will print the game board, or the game grid that shows the 10x10 ships 2D array with
	 * numbers 0-9 to indicate the rows and columns for better user accessibility. 
	 * 
	 * This method uses for loops to iterate through the rows and columns of the grid and will indicate the
	 * following status of the ships:
	 * 
	 * 1) 'S' to show that the location has been fired upon and is occupied by a ship
	 * 2) '-' to show that the location has been fired upon and is empty
	 * 3) 'x' to show that the location contains a sunken ship
	 * 4) '.' to show that the location has never fired upon
	 * 
	 * The status above is determined by checking the ArrayList<int[]> userInputs, which will contain user
	 * shootAt locations which are made of arrays of size 2 such as [[row][column]]. Looping through 
	 * ArrayList: userInputs and if it contains a [row][column] that corresponds to a location on the game board,
	 * then the status of location will be updated depending on whether the location is: 
	 * 
	 *  - empty
	 *  - has ship and sunk
	 *  - has ship and not sunk
	 *  
	 *  According to the specs, The grid will show "." as the default status
	 * 
	 */
	void print() {
		System.out.println("        The gameboard:");
		System.out.println();

		for (int i = 0; i < 10; i++ ) {
			boolean hasBeenCalled = false;
			if (i == 0) {
				for (int j = 0; j < 10; j++) {
					if (j == 0) {
						System.out.print("   " + j);
					}
					else {
						System.out.print("  " + j);
					}
				}
				System.out.println();
			}

			for (int j = 0; j < 10; j++) {
				//hasBeenCalled = false;
				String symbol = ".";
				Ship currentShip = ships[i][j];
				boolean isHor = currentShip.isHorizontal();
				int column = currentShip.getBowColumn();
				int row = currentShip.getBowRow();

				for (int k = 1; k < userInputs.size(); k++) {
					if (userInputs.get(k)[0] == i && userInputs.get(k)[1] == j) {
						hasBeenCalled = true;
						symbol = currentShip.toString();
						k = userInputs.size() + 1;

					}
				}


				if (j == 0) {
					System.out.print(i + " ");
				}
				
				System.out.print("[" + symbol + "]");
				//				hasBeenCalled = false;
			}
			System.out.println();
		}
		System.out.println("________________________________");


	}


	public static void main(String[] args) {
		Ocean a = new Ocean();
		a.placeAllShipsRandomly();
		int [] arr = new int[2];
		arr[0] = 7;
		arr[1] = 3;
//		input = arr;
//		userInputs.add(input);
		a.setUserInputs(arr);
		System.out.println(Arrays.toString(userInputs.get(0)) + Arrays.toString(userInputs.get(1)));
		a.print();
		
		int [] arr1 = new int[2];
		arr1[0] = 2;
		arr1[1] = 4;
//		input = arr;
//		userInputs.add(input);
		a.setUserInputs(arr1);
//				userInputs.add(input);
		System.out.println(Arrays.toString(userInputs.get(0)) + Arrays.toString(userInputs.get(1)) + Arrays.toString(userInputs.get(2)));
		a.print();
		
		int [] arr2 = new int[2];
		arr2[0] = 0;
		arr2[1] = 0;
//		input = arr;
//		userInputs.add(input);
		a.setUserInputs(arr2);
//				userInputs.add(input);
		System.out.println(Arrays.toString(userInputs.get(0)) + Arrays.toString(userInputs.get(1)) + Arrays.toString(userInputs.get(2)));
		a.print();
	}

}
