import java.math.BigInteger;
import java.util.Scanner;


public class IsFibo {
	
	private static final String IS = "IsFibo";
	private static final String IS_NOT = "IsNotFibo";

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		
		while (testCases > 0) {
			long n = Long.parseLong(in.next());
			
			if (isFibo(n)) {
				System.out.println(IS);
			} else {
				System.out.println(IS_NOT);
			}
			testCases--;
		}
		
	}
	
	
	// n is fib if and only if one of 5n^2 + 4 and 5n^2 - 4 is a perfect square  
	
	//8341170321
	private static boolean isFibo(long n) {
		BigInteger bigN = new BigInteger(Long.toString(n));
		BigInteger big5 = new BigInteger("5");
		BigInteger big4 = new BigInteger("4");

		
		BigInteger value1 = ((bigN.multiply(bigN)).multiply(big5)).add(big4);
		BigInteger value2 = ((bigN.multiply(bigN)).multiply(big5)).subtract(big4);
		
		BigInteger value1Sqrt = sqrt(value1);
		BigInteger value2Sqrt = sqrt(value2);
		
		//System.out.println(value1 + " " + value1Sqrt);
		//System.out.println(value2 + " "+ value2Sqrt);
		
		return (value1Sqrt.multiply(value1Sqrt)).equals(value1)
				|| (value2Sqrt.multiply(value2Sqrt)).equals(value2);
		
		
		
		
		/*long value1 = 5*(n * n) + 4;
		long value2 = 5*(n * n) - 4;
		
		long value1Sqrt = (long) Math.sqrt(value1);
		long value2Sqrt = (long) Math.sqrt(value2);
		
		System.out.println(value1 + " " + value1Sqrt);
		System.out.println(value2 + " "+ value2Sqrt);
		
		
		return (value1Sqrt * value1Sqrt == value1)
				|| (value2Sqrt * value2Sqrt == value2);*/
	}
	
	private static BigInteger sqrt(BigInteger n) {
		  BigInteger a = BigInteger.ONE;
		  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		  while(b.compareTo(a) >= 0) {
		    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
		    if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
		    else a = mid.add(BigInteger.ONE);
		  }
		  return a.subtract(BigInteger.ONE);
		}

}
