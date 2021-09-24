import java.util.Arrays;

public class RC {

 static int digit = 0;

	public static String killCommas(String string) {
		//Base case: no string
		if (string == "") throw new IllegalArgumentException ("No string");
		//Base case: string length = 1
		if (string.length() == 1) {
			if (string.charAt(0) == ',') {
				return ""; 
			}
			else {
				return string; 
			}
		}
		//If charAt(0) is a comma, remove the comma and return 1 index after
		if (string.charAt(0) == ',') {
			return killCommas(string.substring(1));
		}
		//Return all 
		else {
			return string.charAt(0) + killCommas(string.substring(1));
		}
	}
	

	public static int sumDigits(int num) {
		//Base case: number is zero
		if (num == 0) {
			int output = digit;
			digit = 0;
			return output;
		}
		//Base case: number given is negative
		if (num < 0) throw new IllegalArgumentException ("No negative numbers");
		else {
			//Modulo to num and add to digit (running total)
			digit = digit + num % 10;
			return sumDigits(num / 10);
		}
	}
	
	public void powerSet(int[] arr) {

		
		//Base case: empty array
		if (arr.length == 0) {
			System.out.println("[]");
		}
		//Base case: array with 1 element
		if (arr.length == 1) {
			System.out.println("{" + arr + "}");
		}
		//Cases where array size is greater than 1
		if (arr.length > 1) {
			
		}
		
	}

	public static void main(String[] args) {
//		System.out.println(killCommas("a,c"));
//		System.out.println(killCommas(",abc,d"));
//		System.out.println(killCommas(",___,"));
//		System.out.println(killCommas("lma,o,"));
//		System.out.println(killCommas(",,"));
//		System.out.println(killCommas("a,c,d,,,"));
//		System.out.println(killCommas(""));
		
		System.out.println(sumDigits(111)); // Need to ask about if i need to clear the variables
		System.out.println(sumDigits(123));
//		int[] arr = new int[] {1};
//
//		
//		System.out.println(Arrays.toString(arr));
		
	

	}
}




