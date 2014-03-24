import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SampleTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(in.readLine());
		String[] strArray = in.readLine().split(" ");
		int[] array = new int[length];
		for (int i = 0; i < strArray.length; i++) {
			array[i] = Integer.parseInt(strArray[i]);
		}
		
		missingNumber(array);

	}
	
	private static void missingNumber(int[] array) {
		int startingTerm = array[0];
		int commonDiff = array[1] - startingTerm;
		
		int currentTerm = startingTerm;
		
		for (int i = 0; i < array.length; i++) {
			if (currentTerm != array[i]) {
				//System.out.println(currentTerm);
				//System.out.println(array[i]);
				System.out.println(currentTerm);
				break;
			} else {
				currentTerm += commonDiff;
			}
		}
	}

}
