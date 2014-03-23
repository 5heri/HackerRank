import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagram {
	
	private static final int NUM_OF_ALPHA = 26;
	private static final int ASCII_a = 97;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int tests = Integer.parseInt(in.readLine());
		
		while (tests > 0) {
			stepsToAnagram(in.readLine()); 
			tests--;
		}

	}
	
	private static void stepsToAnagram(String str) {
		if (str.length() % 2 == 0) {
			int[] alphaCount = new int[NUM_OF_ALPHA];
			
			for (int i = 0; i < str.length()/2; i++) {
				//System.out.println(str.charAt(i));
				alphaCount[((int)str.charAt(i)) - ASCII_a]++;
			}
			for (int i = str.length()/2; i < str.length(); i++) {
				//System.out.println(str.charAt(i));
				alphaCount[((int)str.charAt(i)) - ASCII_a]--;
			}
			int absSum = 0;
			for (int i = 0; i < alphaCount.length; i++) {
				absSum += Math.abs(alphaCount[i]);
			}
			System.out.println(absSum/2);
		} else {
			System.out.println(-1);
		}
	}

}
