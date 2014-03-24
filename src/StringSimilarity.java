import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringSimilarity {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int tests = Integer.parseInt(in.readLine());
		
		while (tests > 0) {
			stringSim(in.readLine());
			//kmpTable(in.readLine());
			/*if (kmpSearch(in.readLine(), in.readLine())) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}*/
			tests--;
		}
	}
	
	private static void stringSim(String str) {
		int totalCount = str.length();
		for (int i = 1; i < str.length(); i++) {
			if (kmpSearch(str, str.substring(i))) {
				System.out.println(str.substring(i));
				totalCount += str.substring(i).length();
			}
		}
		System.out.println(totalCount);
	}
	
	
	private static boolean kmpSearch(String s, String w) {
		int m = 0;
		int i = 0;
		int[] t = kmpTable(s);
		
		while (m+i < s.length()) {
			if (w.charAt(i) == s.charAt(m+i)) {
				if (i == w.length()-1) {
					return true;
				}
				i++;
			} else {
				m = m + i - t[i];
				if (t[i] > -1) {
					i = t[i];
				} else {
					i = 0;
				}
			}
		}
		return false;
	}
	
	private static int[] kmpTable(String s) {
		int[] table = new int[s.length()];
		table[0] = -1;
		table[1] = 0;
		
		int i = 0;
		int j = 1;
		
		while (j != s.length()-1) {
			
			if (s.charAt(i) != s.charAt(j)) {
				i = 0;
				if (s.charAt(i) != s.charAt(j)) {
					table[j+1] = 0;					
				} else {
					table[j+1] = 1;
					i++;
				}
				j++;
			} else {
				table[j+1] = table[j] + 1;
				i++;
				j++;
			}	
		}
		/*for (int k = 0; k < table.length; k++) {
			System.out.print(table[k] + " ");
		}*/
		return table;
	}
	
	
	
	// Results in timeout on last 2 test cases.
	/*private static void stringSim(String str) {
		int totalCount = 0;
		for (int i = 1; i < str.length(); i++) {
			
			
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(j) == str.charAt(j - i)) {
					totalCount++;
				} else {
					break;
				}
			}
		}
		System.out.println(totalCount + str.length());
	}*/

}
