
import java.util.Scanner;


public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		
		while (testCases > 0) {
			System.out.println(totalChoc(in.nextInt(), in.nextInt(), in.nextInt()));
			testCases--;
		}

	}
	
	private static int totalChoc(int n, int c, int m) {
		int total = n/c;
		int currWrappers = total;
		int overallTotal = total;
		
		while (currWrappers >= m) {
			overallTotal += (currWrappers/m);
			currWrappers = (currWrappers/m) + (currWrappers%m);
		}
		return overallTotal;
	}

}
