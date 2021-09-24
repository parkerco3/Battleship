import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class JunitTesting {

	@BeforeEach
	void setUp() throws Exception {
	}

	//TESTING Battleship ================================================================================

	//Tests if Battleship constructor works and returns length 4
	@Test
	void CreateBattleshipAndTest() {
		Battleship test = new Battleship(); 
		assertEquals(test.getLength(), 4);
	}

	//Tests if Battleship constructor works and returns hit[] all initialized to false
	@Test
	void CheckBattleshipHitArray() {
		Battleship test = new Battleship();
		assertEquals(test.hit[0], false);
		assertEquals(test.hit[1], false);
		assertEquals(test.hit[2], false);
		assertEquals(test.hit[3], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckBattleshipIsSunk() {
		Battleship test = new Battleship();
		test.hit[0] = true;
		test.hit[1] = true;
		test.hit[2] = true;
		test.hit[3] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckBattleshipIsNotSunk() {
		Battleship test = new Battleship();
		test.hit[0] = true;
		test.hit[1] = true;
		test.hit[3] = true;
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Battleship"
	}
	@Test
	void CheckBattleShipGetShipType() {
		Battleship test1 = new Battleship();
		assertTrue(test1.getShipType().contains("Battleship"));
	}


	//TESTING CRUISER ================================================================================

	//Tests if Cruiser constructor works and returns length 3
	@Test
	void CreateCruiserAndTest() {
		Cruiser  test = new Cruiser(); 
		assertEquals(test.getLength(), 3);
	}

	//Tests if Cruiser constructor works and returns hit[] all initialized to false
	@Test
	void CheckCruiserHitArray() {
		Battleship test = new Battleship();
		assertEquals(test.hit[0], false);
		assertEquals(test.hit[1], false);
		assertEquals(test.hit[2], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckCruiserIsSunk() {
		Cruiser  test = new Cruiser ();
		test.hit[0] = true;
		test.hit[1] = true;
		test.hit[2] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckCruiserIsNotSunk() {
		Cruiser test = new Cruiser();
		test.hit[0] = true;
		test.hit[1] = true;
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Cruiser"
	}
	@Test
	void CheckCruiserGetShipType() {
		Cruiser test1 = new Cruiser();
		assertTrue(test1.getShipType().contains("Cruiser"));
	}

	//TESTING Destroyer ================================================================================

	//Tests if Destroyer constructor works and returns length 2
	@Test
	void CreateDestroyerAndTest() {
		Destroyer test = new Destroyer(); 
		assertEquals(test.getLength(), 2);
	}

	//Tests if Destroyer constructor works and returns hit[] all initialized to false
	@Test
	void CheckDestroyerHitArray() {
		Destroyer  test = new Destroyer();
		assertEquals(test.hit[0], false);
		assertEquals(test.hit[1], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckDestroyerIsSunk() {
		Destroyer test = new Destroyer();
		test.hit[0] = true;
		test.hit[1] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckDestroyerIsNotSunk() {
		Destroyer  test = new Destroyer();
		test.hit[0] = true;
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Destroyer"
	}
	@Test
	void CheckDestroyerGetShipType() {
		Destroyer test1 = new Destroyer();
		assertTrue(test1.getShipType().contains("Destroyer"));
	}

	//TESTING Submarine ================================================================================

	//Tests if Submarine constructor works and returns length 2
	@Test
	void CreateSubmarineAndTest() {
		Submarine test = new Submarine(); 
		assertEquals(test.getLength(), 1);
	}

	//Tests if Submarine constructor works and returns hit[] all initialized to false
	@Test
	void CheckSubmarineHitArray() {
		Submarine test = new Submarine();
		assertEquals(test.hit[0], false);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckSubmarineIsSunk() {
		Submarine test = new Submarine();
		test.hit[0] = true;
		assertTrue(test.toString().contains("x"));
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckSubmarineIsNotSunk() {
		Submarine test = new Submarine();
		assertTrue(test.toString().contains("S"));

		//Tests if getShipType will return "Submarine"
	}
	@Test
	void CheckSubmarineGetShipType() {
		Submarine test1 = new Submarine();
		assertTrue(test1.getShipType().contains("Submarine"));
	}

	//TESTING emptySea ================================================================================

	//Tests if EmptySea constructor works and returns length 1
	@Test
	void CreateemptySeaAndTest() {
		EmptySea test = new EmptySea(); 
		assertEquals(test.getLength(), 1);
	}

	//Tests if hit[] all updated to true will return toString "x"
	@Test
	void CheckEmptySeaIsSunk() {
		EmptySea test = new EmptySea();
		assertFalse(test.isSunk());
	}

	//Tests if not all hit[] updated to true will return toString "S"
	@Test
	void CheckEmptySeaIsNotSunk() {
		EmptySea test = new EmptySea();
		assertTrue(test.toString().contains("-"));

		//Tests if getShipType will return "Submarine"
	}
	@Test
	void CheckEmptySeaGetShipType() {
		EmptySea test1 = new EmptySea();
		assertTrue(test1.getShipType().contains("empty"));
	}

	//Tests if shootAt emptySea will return false, since there is no ship at location [0][1]
	@Test
	void CheckEmptySeaShootAt() {
		EmptySea test1 = new EmptySea();
		assertFalse(test1.shootAt(0, 1));
	}

	//TESTING SHIP ======Since can't instantiate Ship class, will use Battleship as testing case===============

	//Test to see if a ship can be placed vertically and another horizontally 
	@Test
	void CheckPlaceShips() {
		Battleship test = new Battleship();
		Battleship test2 = new Battleship();
		Ocean ocean = new Ocean();

		test.placeShipAt(5, 0, true, ocean);
		test.placeShipAt(0, 5, false, ocean);


		//TODO NOT SURE HOW TO TEST THIS//TODO NOT SURE HOW TO TEST THIS
		//TODO NOT SURE HOW TO TEST THIS
		//TODO NOT SURE HOW TO TEST THIS
		//TODO NOT SURE HOW TO TEST THIS

	}
	//This will test the if-conditionals in CheckOkToPlaceShipAt returns true without any ships already placed
	//This will also check if ship placed will be out of boundary, which will return false 
	@Test
	void CheckOkToPlaceShipAt1() {
		Battleship Battleship = new Battleship();
		Ocean ocean = new Ocean();

		//Test Top left corner horizontal/vertical
		assertTrue(Battleship.okToPlaceShipAt(0, 0, true, ocean)); 
		assertTrue(Battleship.okToPlaceShipAt(0, 0, false, ocean));

		//Test Left most column [6][0]: horizontal legal, vertical legal
		assertTrue(Battleship.okToPlaceShipAt(6, 0, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 0, false, ocean));

		//Test bottom Left corner [9][9]: horizontal legal, vertical illegal
		assertTrue(Battleship.okToPlaceShipAt(9, 0, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(9, 0, false, ocean));

		//Test Left column Middle [2][0]: horizontal legal, vertical legal
		assertTrue(Battleship.okToPlaceShipAt(2, 0, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 0, false, ocean));

		//Test First Row Middle [0][2]: horizontal legal, vertical legal
		assertTrue(Battleship.okToPlaceShipAt(0, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(0, 2, true, ocean));

		//Test First Row + right corner[0][6]: horizontal legal, vertical legal
		assertTrue(Battleship.okToPlaceShipAt(0, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(0, 6, true, ocean));

		//Test First Row Middle [0][2]: horizontal legal, vertical legal
		assertTrue(Battleship.okToPlaceShipAt(0, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(0, 2, true, ocean));

		//Test Top right corner [0][9]: horizontal illegal, vertical legal
		assertFalse(Battleship.okToPlaceShipAt(0, 9, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(0, 9, false, ocean));

		//Test Right column middle [2][9] horizontal illegal, vertical legal
		assertFalse(Battleship.okToPlaceShipAt(2, 9, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 9, false, ocean));

		//Test bottom Right corner [9][9] horizontal illegal, vertical illegal
		assertFalse(Battleship.okToPlaceShipAt(9, 9, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(9, 9, false, ocean));

		//Test bottom Middle [9][2] horizontal legal, vertical illegal
		assertTrue(Battleship.okToPlaceShipAt(9, 2, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(9, 2, false, ocean));

		//Test ships not next to the edges
		
		
		//Row 1
		
		
		assertTrue(Battleship.okToPlaceShipAt(1, 1, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 3, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 4, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 5, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(1, 7, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(1, 8, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(1, 8, false, ocean));

		//Row 2
		assertTrue(Battleship.okToPlaceShipAt(2, 1, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 3, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 4, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 5, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(2, 7, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(2, 8, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(2, 8, false, ocean));

		//Row 3
		assertTrue(Battleship.okToPlaceShipAt(3, 1, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 3, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 4, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 5, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(3, 7, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(3, 8, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(3, 8, false, ocean));

		//Row 4
		assertTrue(Battleship.okToPlaceShipAt(4, 1, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 3, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 4, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 5, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(4, 7, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(4, 8, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(4, 8, false, ocean));

		//Row5
		assertTrue(Battleship.okToPlaceShipAt(5, 1, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 3, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 4, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 5, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(5, 7, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(5, 8, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(5, 8, false, ocean));
		
		//Row6
		assertTrue(Battleship.okToPlaceShipAt(6, 1, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 2, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 3, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 4, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 5, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 6, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(6, 7, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(6, 8, true, ocean));
		assertTrue(Battleship.okToPlaceShipAt(6, 8, false, ocean));
		
		//Row7
		assertTrue(Battleship.okToPlaceShipAt(7, 1, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(7, 2, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(7, 3, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(7, 4, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(7, 5, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(7, 6, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 7, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 8, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(7, 8, false, ocean));
		
		//Row8
		assertTrue(Battleship.okToPlaceShipAt(8, 1, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 1, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(8, 2, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 2, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(8, 3, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 3, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(8, 4, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 4, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(8, 5, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 5, false, ocean));
		assertTrue(Battleship.okToPlaceShipAt(8, 6, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 6, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 7, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 7, false, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 8, true, ocean));
		assertFalse(Battleship.okToPlaceShipAt(8, 8, false, ocean));
	}
	
	//Tests whether the if-conditions returns false when there is already a ship in every spot in Ships 2D array
	@Test
	void CheckOkToPlaceShipAt2() {
		int counterRow0Horizontal = 0;
		int counterRow0Vertical = 0;
		int counterRow1Horizontal = 0;
		int counterRow1Vertical = 0;
		int counterRow2Horizontal = 0;
		int counterRow2Vertical = 0;
		int counterRow3Horizontal = 0;
		int counterRow3Vertical = 0;
		int counterRow4Horizontal = 0;
		int counterRow4Vertical = 0;
		int counterRow5Horizontal = 0;
		int counterRow5Vertical = 0;
		int counterRow6Horizontal = 0;
		int counterRow6Vertical = 0;
		int counterRow7Horizontal = 0;
		int counterRow7Vertical = 0;
		int counterRow8Horizontal = 0;
		int counterRow8Vertical = 0;
		int counterRow9Horizontal = 0;
		int counterRow9Vertical = 0;

		
		Submarine Submarine = new Submarine();
		Ocean ocean = new Ocean();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				ocean.setShips(i, j, Submarine);
			}
		}
		
		/**=====================================
		 * Checking Row0 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(0, i, true, ocean)) {
				counterRow0Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(0, i, false, ocean)) {
				counterRow0Vertical++;
			}
		}
		assertEquals(counterRow0Vertical++, 10); 
		assertEquals(counterRow0Horizontal++, 10); 
// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(0, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(0, 9, false, ocean));
		
		
		/**=====================================
		 * Checking Row1 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(1, i, true, ocean)) {
				counterRow1Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(1, i, false, ocean)) {
				counterRow1Vertical++;
			}
		}
		assertEquals(counterRow1Vertical++, 10); 
		assertEquals(counterRow1Horizontal++, 10); 
		
// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(1, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(1, 9, false, ocean));
		
		
		/**=====================================
		 * Checking Row2 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(2, i, true, ocean)) {
				counterRow2Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(2, i, false, ocean)) {
				counterRow2Vertical++;
			}
		}
		assertEquals(counterRow2Vertical++, 10); 
		assertEquals(counterRow2Horizontal++, 10); 
		
// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(2, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(2, 9, false, ocean));
		

		/**=====================================
		 * Checking Row3 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(3, i, true, ocean)) {
				counterRow3Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(3, i, false, ocean)) {
				counterRow3Vertical++;
			}
		}
		assertEquals(counterRow3Vertical++, 10); 
		assertEquals(counterRow3Horizontal++, 10); 
		
// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(3, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(3, 9, false, ocean));

		/**=====================================
		 * Checking Row4 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(4, i, true, ocean)) {
				counterRow4Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(4, i, false, ocean)) {
				counterRow4Vertical++;
			}
		}
		assertEquals(counterRow4Vertical++, 10); 
		assertEquals(counterRow4Horizontal++, 10); 
		
// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(4, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(4, 9, false, ocean));
		
		
		/**=====================================
		 * Checking Row5 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(5, i, true, ocean)) {
				counterRow5Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(5, i, false, ocean)) {
				counterRow5Vertical++;
			}
		}
		assertEquals(counterRow5Vertical++, 10); 
		assertEquals(counterRow5Horizontal++, 10);
		
		// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(5, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(5, 9, false, ocean));
		
		/**=====================================
		 * Checking Row6 horizontal and vertical 
		 *=====================================
		 */
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(6, i, true, ocean)) {
				counterRow6Horizontal++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (!Submarine.okToPlaceShipAt(6, i, false, ocean)) {
				counterRow6Vertical++;
			}
		}
		assertEquals(counterRow6Vertical++, 10); 
		assertEquals(counterRow6Horizontal++, 10);
		
		// =====The Chunk below is verified====
//		assertFalse(Submarine.okToPlaceShipAt(6, 0, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 0, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 1, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 1, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 2, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 2, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 3, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 3, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 4, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 4, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 5, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 5, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 6, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 6, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 7, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 7, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 8, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 8, false, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 9, true, ocean));
//		assertFalse(Submarine.okToPlaceShipAt(6, 9, false, ocean));
		
		
		//Row 7
		assertFalse(Submarine.okToPlaceShipAt(7, 0, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 0, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 1, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 1, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 2, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 2, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 3, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 3, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 4, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 4, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 5, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 5, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 6, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 6, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 7, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 7, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 8, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 8, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 9, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(7, 9, false, ocean));
		
		//Row 8
		assertFalse(Submarine.okToPlaceShipAt(8, 0, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 0, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 1, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 1, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 2, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 2, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 3, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 3, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 4, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 4, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 5, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 5, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 6, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 6, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 7, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 7, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 8, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 8, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 9, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(8, 9, false, ocean));
		
		//Row 9
		assertFalse(Submarine.okToPlaceShipAt(9, 0, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 0, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 1, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 1, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 2, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 2, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 3, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 3, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 4, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 4, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 5, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 5, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 6, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 6, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 7, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 7, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 8, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 8, false, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 9, true, ocean));
		assertFalse(Submarine.okToPlaceShipAt(9, 9, false, ocean));

		
	}
	
	//Testing if ship row setters/getters work as expected
	@Test
	void CheckShipSettersGettersRow() {
		Battleship test = new Battleship();
		test.setBowRow(0);
		assertEquals(test.getBowRow(), 0);
	}

	//Testing if ship column setters/getters work as expected
	@Test
	void CheckShipSettersGettersColumn() {
		Battleship test = new Battleship();
		test.setBowColumn(0);
		assertEquals(test.getBowColumn(), 0);
	}

	//Testing if ship horizontal setters/getters work as expected
	@Test
	void CheckShipSettersGettersHorizontal() {
		Battleship test = new Battleship();
		Battleship test2 = new Battleship();
		test.setHorizontal(false);
		test2.setHorizontal(true);
		assertFalse(test.isHorizontal());
		assertTrue(test2.isHorizontal());

	}

	//Testing if ship can be placed ===========================
	@Test
	void CheckokToPlaceShipAt() {
		//TODO need to test placeships
	}

	//TESTING OCEAN ==================================================================

	//Testing setShips method TODO TO CHECK IF THIS IS ENOUGH
	@Test
	void CheckSetShip() {
		Battleship test = new Battleship();
		Ocean ocean = new Ocean();
		ocean.setShips(0, 5, test);
	}

	//Test if shotsFired is updated as expected and BOTTOM RIGHT CORNER of grid should mostly return false
	@Test 
	void CheckShotsFired() {
		Ocean ocean = new Ocean();
		ocean.shootAt(0, 5);
		assertEquals(ocean.getShotsFired(), 1);
		assertFalse(ocean.shootAt(9, 9));

	}
	
	//Test if shotsFired is updated as expected when there is a ship there at the fired location
	@Test 
	void CheckShotsFired2() {
		Ocean ocean = new Ocean();
		Submarine Submarine = new Submarine();
		ocean.setShips(0, 5, Submarine);
		assertTrue(ocean.shootAt(0, 5));


	}

	//Test if shotsFired is updated as expected, this test no shots are fired, so Hitscount(); must be zero
	@Test 
	void CheckgetHitsCount() {
		Ocean ocean = new Ocean();
		assertEquals(ocean.getHitsCount(), 0);

	}


	//Test isGameOver() when shipsSunk = 10
	@Test 
	void IsGameOver1() {
		Ocean ocean = new Ocean();
		ocean.setShipsSunk(10);
		assertTrue(ocean.isGameOver());
		
	}
	
	//Test isGameOver() when shipsSunk < 10
	@Test 
	void IsGameOver2() {
		Ocean ocean = new Ocean();
		ocean.setShipsSunk(9);
		assertFalse(ocean.isGameOver());
		
	}
	
	
	//Test if shipsSunk getter works as expected
	@Test 
	void CheckShipsSunk() {
		Ocean ocean = new Ocean();
		assertEquals(ocean.getShipsSunk(), 0);

	}

	//Test if getShipArray() returns as expected and should not be null because it creates emptySea in all cells
	@Test 
	void CheckGetShipArray() {
		Ocean ocean = new Ocean();
		assertNotNull(ocean.getShipArray());
	}

	//Test if isOccupied() returns false when the ocean is first instantiated, because all emptySeas are in each location
	@Test 
	void CheckisOccupied() {
		Ocean ocean = new Ocean();
		assertFalse(ocean.isOccupied(0, 2));
	}

	//Test if setUserinputs() setter is working as expected
	@Test 
	void CheckUserInputs() {
		Ocean ocean = new Ocean();
		int[] input = {2,4};
		ocean.setUserInputs(input);
		assertNotNull(ocean.userInputs.get(0));
	}



}
