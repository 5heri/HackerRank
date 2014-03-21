import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AngryChildren {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int numPackets = Integer.parseInt(in.readLine());
		int numKids = Integer.parseInt(in.readLine());
		int[] packets = new int[numPackets];

		for(int i = 0; i < numPackets; i ++)
		{
			packets[i] = Integer.parseInt(in.readLine());
		}

		int unfairness = Integer.MAX_VALUE;

		unfairness = findUnfairness(numKids, packets);

		System.out.println(unfairness);
	}
	
	private static int findUnfairness(int kids, int[] packets) {
		// Sort array using mergeSort O(n logn)
		mergeSort(packets);
		
		int minPointer = 0;
		int maxPointer = kids - 1;
		int minUnfairness = Integer.MAX_VALUE;
		
		// find mininum difference between packets within range kids O(n)
		while (maxPointer < packets.length) {
			if (packets[maxPointer] - packets[minPointer] < minUnfairness) {
				minUnfairness = packets[maxPointer] - packets[minPointer];
			}
			minPointer++;
			maxPointer++;
		}
		
		return minUnfairness;
	}
	
	private static void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			// To prevent overflow
			int mid = low + ((high - low) / 2);
			mergeSort(array, helper, low, mid);
			mergeSort(array, helper, mid + 1, high);
			merge(array, helper, low, mid, high);
		}
	}

	private static void merge(int[] array, int[] helper, int low, int mid, int high) {

		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;

		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
}
