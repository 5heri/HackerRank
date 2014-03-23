import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AlienUsername {
	
	private static final String VALID = "VALID";
	private static final String INVALID = "INVALID";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(in.readLine());
		
		while (testCases > 0) {
			validUsername(in.readLine());
			testCases--;
		}
	}
	
	/*
	 * It has to begin with either an underscore ‘_’ (ascii value 95) or a dot ‘.’ (ascii value 46)
	 * It has to be immediately followed by one or more occurrences of digits numbered 0-9
	 * It can then have letters, either uppercase or lowercase, 0 or more in number
	 * It can then end with an optional ‘_’ (ascii value 95)
	 */

	private static void validUsername(String username) {
		
		if (username.length() < 2) {
			System.out.println(INVALID);
			return;
		}
		
		// Checks if username begins with '_' or '.'
		if (username.charAt(0) != '_' && username.charAt(0) != '.') {
			System.out.println(INVALID);
			return;
		} else if (username.charAt(1) < '0' || username.charAt(1) > '9') {
			System.out.println(INVALID);
			return;
		}
				
							
		boolean alphaExists = false;
		
		int pointer = username.length()-1;
		for (int i = 2; i < username.length(); i++) {
			if (username.charAt(i) < '0' || username.charAt(i) > '9') {
				pointer = i;
				if (isAlpha(username.charAt(i))) {
					alphaExists = true;
				}
				break;
			}
		}
		
		while (pointer < username.length()-1) {
			if (!isAlpha(username.charAt(pointer))) {
				System.out.println(INVALID);
				return;
			}
			pointer++;
		}
	
		char lastChar = username.charAt(pointer);
		if (alphaExists) {
			if ((lastChar == '_')
					|| isAlpha(lastChar)) {
				System.out.println(VALID);
				return;
			}
		} else if ((lastChar == '_')
					|| (lastChar >= '0' && lastChar <= '9')) {
				System.out.println(VALID);
				return;
		}
		System.out.println(INVALID);
	}
	
	private static boolean isAlpha(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}
}
