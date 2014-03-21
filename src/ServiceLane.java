import java.util.Scanner;

public class ServiceLane {
	
	private static int MAX_N = 10000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int length = in.nextInt();
		int testCases = in.nextInt();
		
		int[] laneWidth = new int[length];
		
		for (int i = 0; i < length; i++) {
			laneWidth[i] = in.nextInt();
		}
		
		while (testCases > 0) {
			System.out.println(serLane(laneWidth, in.nextInt(), in.nextInt()));
			testCases--;
		}
	}
	
	private static int serLane(int[] width, int i, int j) {
		int currentMin = MAX_N;
		
		for (; i <= j; i++) {
			if (width[i] < currentMin) {
				currentMin = width[i];
			}
		}
		return currentMin;
	}

}
