import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SampleTestPalantirOne {
	
	 private static final int NUMBER_OF_ASCII = 256;
	 private static final String ARE = "Anagrams!";
	 private static final String NOT = "Not anagrams!";


	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		String firstStr = in.readLine();
		String secondStr = in.readLine();
		
		isAnagram(firstStr, secondStr);
	
	}
	
	private static void isAnagram(String first, String second) {
		if (first.length() == second.length()) {
			
			int[] charCount = new int[NUMBER_OF_ASCII];
			
			for (int i = 0; i < first.length(); i++) {
				charCount[(int)first.charAt(i)]++;
				charCount[(int)second.charAt(i)]--;
			}
			
			for (int i = 0; i < charCount.length; i++) {
				if (charCount[i] != 0) {
					System.out.println(NOT);
					return;
				}
			}
			System.out.println(ARE);
			
		} else {
			System.out.println(NOT);
		}
	}

}
