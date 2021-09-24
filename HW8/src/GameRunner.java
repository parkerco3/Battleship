import java.util.*;

public class GameRunner {
	int runningScore = 101;

	public void RunGame() {
		Scanner s = new Scanner(System.in);
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		ArrayList<int[]> sunkLocation = new ArrayList<int[]>();
		boolean alreadySunk = false;

		ocean.print();
		while (!ocean.isGameOver()) {
			System.out.println("Please input your row you want to fire on");
			while (!s.hasNextInt()) { 
				System.out.println("Please input a number less than 10");
				s.next();
			}
			int input = s.nextInt();
			while(input > 9 || input < 0) {
				System.out.println("Please input a number less than 10");
				while (!s.hasNextInt()) {
					System.out.println("Please input a number less than 10");
					s.next();
				}
				input = s.nextInt();
			}
			int rowNum = input;
			
			System.out.println("Please input your column you want to fire on");
			while (!s.hasNextInt()) { // ||
				System.out.println("Please input a number less than 10");
				s.next();
			}
			int input2 = s.nextInt();
			while(input2 > 9 || input2 < 0) {
				System.out.println("Please input a number less than 10");
				while (!s.hasNextInt()) {
					System.out.println("Please input a number less than 10");
					s.next();
				}
				input2 = s.nextInt();
			}
			int colNum = input2;
			int[] arr = {rowNum, colNum};
			ocean.setUserInputs(arr);
			ocean.shootAt(arr[0], arr[1]);
			Ship shotShip = ocean.getShipArray()[arr[0]][arr[1]];
			boolean shot = shotShip.shootAt(arr[0], arr[1]);
			
//			for (int i = 0; i < sunkLocation.size(); i++) {
//				if (sunkLocation.get(i)[0] == arr[0] && sunkLocation.get(i)[1] == arr[1]) {
//					alreadySunk = true;
//					i = sunkLocation.size() + 1;
//				}
//			}
//			
			if (shotShip.isSunk() && shot == true) {
					ocean.shipsSunk++;
			//		sunkLocation.add(arr);
			}
			
			ocean.print();
			//please delete 
			System.out.println();
			System.out.println("Shots Fired: " + ocean.getShotsFired());
			System.out.println("Hits: " + ocean.getHitsCount());
			System.out.println("Sunken Ships: " + ocean.getShipsSunk());
			System.out.println("________________________________");

		}
		//runningScore = ocean.getShotsFired();
		
		if (ocean.getShotsFired() < runningScore) {
			runningScore = ocean.getShotsFired();
		}
		
		
		System.out.println("The number of shots you had was: " + ocean.getShotsFired());
		System.out.println("Your lowest shots was: " + runningScore);
		System.out.println("The number of hits you had was: " + ocean.getHitsCount());
		System.out.println("Thanks for playing!");

	}
	
	public static void main(String[] args) {
		GameRunner r = new GameRunner();
		r.RunGame();
	}
}
