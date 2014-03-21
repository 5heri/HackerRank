import java.util.Scanner;


public class UtopianTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		
		while (testCases > 0) {
			System.out.println(cyclesHeight(in.nextInt()));
			testCases--;
		}
	}
	
	private static int cyclesHeight(int n) {
		int height = 1;
		
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				height *= 2;
			} else {
				height++;
			}			
		}
		return height;
	}

}
