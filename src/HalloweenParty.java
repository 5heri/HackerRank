import java.math.BigInteger;
import java.util.Scanner;

public class HalloweenParty {

	public static final void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		
		while (testCases > 0) {
			maxChoc(in.nextInt());
			testCases--;
		}
	}
	
	private static void maxChoc(int k) {
		BigInteger bigValueX = new BigInteger(Integer.toString(k/2));
		BigInteger bigValueY = null;
		if (k % 2 == 0) {
			bigValueX = bigValueX.multiply(bigValueX);
			System.out.println(bigValueX);	
		} else {
			bigValueY = new BigInteger(Integer.toString(k/2 + 1));
			bigValueX = bigValueX.multiply(bigValueY);
			System.out.println(bigValueX);
		}
	}

}
