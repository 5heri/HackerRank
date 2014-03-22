import java.util.Scanner;

public class FillingJars {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int jarCount = in.nextInt();
		int iterations = in.nextInt();

		long sum = 0;
		while (iterations > 0) {
			long a = in.nextInt();
			long b = in.nextInt();
			long k = in.nextInt();
			
			// As same amount is added, it is just simple multiplication.
			sum += (b-a+1)*k;
			
			iterations--;
		}
		System.out.println(sum/jarCount);			
	}
}
