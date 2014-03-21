import java.util.Scanner;

public class SherlockAndTheBeast {
	
	private static final char THREE = '3';
	private static final char FIVE = '5';

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		
		while (testCases > 0) {
			decentNumber(in.nextInt());
			testCases--;
		}

	}
	
	private static void decentNumber(int n) {
		StringBuffer numbers = new StringBuffer();
		int fiveCount = 0;
		int threeCount = 0;
		
		for (int i = 0; i < n; i++) {
			numbers.append(FIVE);
			fiveCount++;
		}
		
		if (fiveCount % 3 == 0) {
			System.out.println(numbers);
		} else {
			int length = numbers.length();
			
			for (int i = length-1; i >= 0; i--) {
				numbers.setCharAt(i, THREE);
				threeCount++;
				fiveCount--;
				if (threeCount % 5 == 0 && fiveCount % 3 == 0) {
					System.out.println(numbers);
					return;
				}
			}
			System.out.println(-1);
		}
	}

}
